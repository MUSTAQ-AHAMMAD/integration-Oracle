package innovate.tamergroup.opencart.rest.model.product.fetch;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductDescription implements Serializable {

    @SerializedName("language_id")
    @Expose
    private String languageId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("meta_description")
    @Expose
    private String metaDescription;
    @SerializedName("meta_keyword")
    @Expose
    private String metaKeyword;
    @SerializedName("meta_title")
    @Expose
    private String metaTitle;
    @SerializedName("tag")
    @Expose
    private String tag;
    private final static long serialVersionUID = -749956506238436587L;

    /**
     * No args constructor for use in serialization
     *
     */
    public ProductDescription() {
    }

    /**
     *
     * @param tag
     * @param description
     * @param name
     * @param metaDescription
     * @param metaTitle
     * @param metaKeyword
     * @param languageId
     */
    public ProductDescription(String languageId, String name, String description, String metaDescription,
                              String metaKeyword, String metaTitle, String tag) {
        super();
        this.languageId = languageId;
        this.name = name;
        this.description = description;
        this.metaDescription = metaDescription;
        this.metaKeyword = metaKeyword;
        this.metaTitle = metaTitle;
        this.tag = tag;
    }

    public String getLanguageId() {
        return languageId;
    }

    public void setLanguageId(String languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public String getMetaKeyword() {
        return metaKeyword;
    }

    public void setMetaKeyword(String metaKeyword) {
        this.metaKeyword = metaKeyword;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

}
