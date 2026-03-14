package innovate.tamergroup.email;

import innovate.tamergroup.ejb.utils.EJBClientUtil;
import innovate.tamergroup.persistence.entities.NotificationEmailRecipients;
import innovate.tamergroup.persistence.session.SessionEJB;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import javax.naming.NamingException;

public class SendEmailNotification {

    private Integer requestId;
    private List<String[]> infoLines;
    private List<String[]> errorLines;
    private String subject;
    private String region;


    public SendEmailNotification(Integer requestId, String region) {
        super();
        this.requestId = requestId;
        infoLines = new ArrayList<>();
        errorLines = new ArrayList<>();
        this.region = region;
    }

    public void execute() throws IOException, NamingException {
        final String username = "oracle.nots@ibrahimalqurashi.com";
        final String password = "oracle@qurashi";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            
            SessionEJB databaseSession = EJBClientUtil.getSessionEJB();
            List<NotificationEmailRecipients> activeRecipients =
                databaseSession.getNotificationEmailRecipientsFindActive();
            StringBuilder fromBuilder = new StringBuilder(), toBuilder = new StringBuilder(), ccBuilder = new StringBuilder(), bccBuilder =
                new StringBuilder();
            for (NotificationEmailRecipients emailRecipients : activeRecipients) {
                switch (emailRecipients.getEmailMode()) {
                case "FROM": 
                    fromBuilder.append(",").append(emailRecipients.getEmailAddress());
                    break;
                case "TO":
                    toBuilder.append(",").append(emailRecipients.getEmailAddress());
                    break;
                case "CC":
                    ccBuilder.append(",").append(emailRecipients.getEmailAddress());
                    break;
                case "BCC":
                    bccBuilder.append(",").append(emailRecipients.getEmailAddress());
                    break;
                }
            }
            
            message.setFrom(new InternetAddress(fromBuilder.substring(1)));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toBuilder.substring(1)));
            message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccBuilder.toString().isEmpty() ? "" : ccBuilder.substring(1)));
            message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bccBuilder.toString().isEmpty() ? "" : bccBuilder.substring(1)));
            if (subject == null) subject = "Integration Results Mail for AlQurashi";
            message.setSubject("[INTEGRATION-" + region + "] " + subject);

            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText("Hi,\n\n\t\tAttached are the logs for the integration for the RequestID: " +
                             String.valueOf(requestId) + "\n\nRegards,\nThe Integration Team");

            Boolean infoLineContent = false, errorLineContent = false;
            OutputStream os = null;
            MimeBodyPart infoAttachPart = new MimeBodyPart();
            StringBuilder infoLineBuilder = new StringBuilder();
            for (String[] infoLine : infoLines) {
                infoLineBuilder.append(infoLine[0]).append("\t\t").append(infoLine[1]).append("\n");
                if (!infoLineContent && !infoLine[0].isEmpty() && !infoLine[0].contains("INTEGRATION LOG")) infoLineContent = true;
            }
            File infoFile = new File("integraton-info.txt");

            try {
                os = new FileOutputStream(infoFile);
                os.write(infoLineBuilder.toString().getBytes(), 0, infoLineBuilder.toString().length());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                os.close();
            }
            infoAttachPart.attachFile(infoFile);

            MimeBodyPart errorAttachPart = new MimeBodyPart();
            StringBuilder errorLineBuilder = new StringBuilder();
            for (String[] errorLine : errorLines) {
                errorLineBuilder.append(errorLine[0]).append("\t\t").append(errorLine[1]).append("\n");
                if (!errorLineContent && !errorLine[0].isEmpty() && !errorLine[0].contains("INTEGRATION LOG")) errorLineContent = true;
            }
            File errorFile = new File("integraton-error.txt");

            try {
                os = new FileOutputStream(errorFile);
                os.write(errorLineBuilder.toString().getBytes(), 0, errorLineBuilder.toString().length());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                os.close();
            }
            errorAttachPart.attachFile(errorFile);


            Multipart multiPart = new MimeMultipart();
            multiPart.addBodyPart(textPart);
            if (infoLineContent)
                multiPart.addBodyPart(infoAttachPart);
            if (errorLineContent)
                multiPart.addBodyPart(errorAttachPart);
            
            if (!infoLineContent && !errorLineContent) {
                message.setSubject("[INTEGRATION] " + subject + " - No transactions");
                textPart.setText("Hi,\n\n\t\tThe integration scheduling function with RequestID: " +
                                 String.valueOf(requestId) + ". has run with no integration performed.\n\nRegards,\nThe Integration Team"); 
            }


            message.setContent(multiPart);
            Transport.send(message);
            System.out.println("Email sent!!");

        } catch (MessagingException e) {
            System.err.println("[SendEmailNotification] Failed to send notification email for region " + region + ": " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void addInfoLine(String module, String message) {
        String[] infoLine = new String[] { module, message };
        infoLines.add(infoLine);
    }

    public void addErrorLine(String module, String message) {
        String[] errorLine = new String[] { module, message };
        errorLines.add(errorLine);
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public static void main(String[] args) throws IOException, NamingException {
        SendEmailNotification emailNotify = new SendEmailNotification(1234, "SA");
        emailNotify.addInfoLine("Invoice", "Invoice#: 15054 created against orders: 12, 34, 767, 234");
        emailNotify.addErrorLine("Misc Receipt", "Receipt not shown in UI!!");
        emailNotify.execute();
    }
}
