package innovate.tamergroup.opencart.rest.model.order;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Total implements Serializable {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("value")
    @Expose
    private Double value;
    private final static long serialVersionUID = 225172468555990919L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Total() {
    }

    /**
     *
     * @param text
     * @param title
     * @param value
     */
    public Total(String title, String text, Double value) {
        super();
        this.title = title;
        this.text = text;
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

}
