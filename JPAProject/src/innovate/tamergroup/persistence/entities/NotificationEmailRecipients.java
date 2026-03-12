package innovate.tamergroup.persistence.entities;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * To create ID generator sequence "NOTIFICATION_EMAIL_RECIPIENTS_ID_SEQ_GEN":
 * CREATE SEQUENCE "NOTIFICATION_EMAIL_RECIPIENTS_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({
              @NamedQuery(name = "NotificationEmailRecipients.findAll",
                          query = "select o from NotificationEmailRecipients o"),
              @NamedQuery(name = "NotificationEmailRecipients.findActive",
                          query = "select o from NotificationEmailRecipients o where o.status = 'Y'")
    })
@Table(name = "NOTIFICATION_EMAIL_RECIPIENTS")
@SequenceGenerator(name = "NotificationEmailRecipients_Id_Seq_Gen",
                   sequenceName = "NOTIF_EMAIL_RECP_ID_SEQ_GEN", allocationSize = 10, initialValue = 10)
public class NotificationEmailRecipients implements Serializable {
    private static final long serialVersionUID = -1728118864114499116L;
    @Column(name = "EMAIL_ADDRESS", nullable = false, unique = true, length = 40)
    private String emailAddress;
    @Column(name = "EMAIL_MODE", nullable = false, length = 4)
    private String emailMode;
    @Column(name = "FULL_NAME", nullable = false, length = 40)
    private String fullName;
    @Id
    @Column(name = "ROW_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NotificationEmailRecipients_Id_Seq_Gen")
    private BigDecimal rowId;
    @Column(nullable = false)
    private String status;

    public NotificationEmailRecipients() {
    }

    public NotificationEmailRecipients(String emailAddress, String emailMode, String fullName, BigDecimal rowId,
                                       String status) {
        this.emailAddress = emailAddress;
        this.emailMode = emailMode;
        this.fullName = fullName;
        this.rowId = rowId;
        this.status = status;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailMode() {
        return emailMode;
    }

    public void setEmailMode(String emailMode) {
        this.emailMode = emailMode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public BigDecimal getRowId() {
        return rowId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
