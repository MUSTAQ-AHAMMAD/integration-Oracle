package innovate.tamergroup.email;


import java.io.IOException;

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

import org.apache.commons.lang.exception.ExceptionUtils;

public class ExceptionAlerter {

    private String region;

    public ExceptionAlerter(String region) {
        super();
        this.region = region;
    }

    public void sendException(Exception exception) {
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
            message.setFrom(new InternetAddress("oracle.nots@ibrahimalqurashi.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("mohammed.mattummal@tamergroup.com"));


            String subject = "Exception in AlQurashi Integration Middleware";
            message.setSubject("[INTEGRATION-" + region + "] " + subject);

            MimeBodyPart textPart = new MimeBodyPart();
            String cause = ExceptionUtils.getRootCauseMessage(exception);
            String errorMessage = ExceptionUtils.getMessage(exception);
            String stackTrace = ExceptionUtils.getFullStackTrace(exception); 
            
            StringBuilder builder = new StringBuilder();
            builder.append("\n").append("CAUSE: ").append(cause);
            //builder.append("\n\n").append("MESSAGE: ").append(errorMessage);
            builder.append("\n\n").append("STACK TRACE: ").append(stackTrace);
            
            textPart.setText(builder.toString());

            Multipart multiPart = new MimeMultipart();
            multiPart.addBodyPart(textPart);

            message.setContent(multiPart);
            Transport.send(message);
            System.out.println("Email sent!!");

        } catch (MessagingException e) {
            System.err.println("[ExceptionAlerter] Failed to send alert email for region " + region + ": " + e);
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException, NamingException {
        ExceptionAlerter exceptionAlerter = new ExceptionAlerter("SA");
        Exception exception = new Exception("Testing Exception!!");
        StackTraceElement stackElement1 = new StackTraceElement("SalesOrder", "createInvoice", "TestScript.java", 65);
        StackTraceElement stackElement2 = new StackTraceElement("SalesOrder", "fetchInvoice", "TestScript.java", 32);
        StackTraceElement stackElement3 = new StackTraceElement("SalesOrder", "getSales", "TestScriptSales.java", 115);
        exception.setStackTrace(new StackTraceElement[]{stackElement1, stackElement2, stackElement3});
        exceptionAlerter.sendException(exception);
    }
}
