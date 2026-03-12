package innovate.tamergroup.opencart.rest.model.product.post;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductAttributeDescriptionPost implements Serializable {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("language_id")
    @Expose
    private String languageId;
    private final static long serialVersionUID = -6888447157651386468L;

    /**
     * No args constructor for use in serialization
     *
     */
    public ProductAttributeDescriptionPost() {
    }

    /**
     *
     * @param text
     * @param languageId
     */
    public ProductAttributeDescriptionPost(String text, String languageId) {
        super();
        this.text = text;
        this.languageId = languageId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ProductAttributeDescriptionPost withText(String text) {
        this.text = text;
        return this;
    }

    public String getLanguageId() {
        return languageId;
    }

    public void setLanguageId(String languageId) {
        this.languageId = languageId;
    }

    public ProductAttributeDescriptionPost withLanguageId(String languageId) {
        this.languageId = languageId;
        return this;
    }

}
