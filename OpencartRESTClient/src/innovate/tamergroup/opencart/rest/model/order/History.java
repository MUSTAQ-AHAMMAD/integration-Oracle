package innovate.tamergroup.opencart.rest.model.order;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class History implements Serializable {

    @SerializedName("notify")
    @Expose
    private String notify;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("date_added")
    @Expose
    private Date dateAdded;
    private final static long serialVersionUID = 3052112832988279823L;

    /**
     * No args constructor for use in serialization
     *
     */
    public History() {
    }

    /**
     *
     * @param status
     * @param notify
     * @param dateAdded
     * @param comment
     */
    public History(String notify, String status, String comment, Date dateAdded) {
        super();
        this.notify = notify;
        this.status = status;
        this.comment = comment;
        this.dateAdded = dateAdded;
    }

    public String getNotify() {
        return notify;
    }

    public void setNotify(String notify) {
        this.notify = notify;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

}
