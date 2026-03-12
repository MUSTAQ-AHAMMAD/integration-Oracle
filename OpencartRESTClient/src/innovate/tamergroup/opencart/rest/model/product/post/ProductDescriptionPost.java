package innovate.tamergroup.opencart.rest.model.product.post;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductDescriptionPost implements Serializable {

    @SerializedName("language_id")
    @Expose
    private String languageId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("meta_title")
    @Expose
    private String metaTitle;
    @SerializedName("meta_description")
    @Expose
    private String metaDescription;
    @SerializedName("meta_keyword")
    @Expose
    private String metaKeyword;
    @SerializedName("tag")
    @Expose
    private String tag;
    private final static long serialVersionUID = -7406121244966204924L;

    /**
     * No args constructor for use in serialization
     *
     */
    public ProductDescriptionPost() {
    }

    /**
     *
     * @param tag
     * @param description
     * @param name
     * @param metaDescription
     * @param metaKeyword
     * @param metaTitle
     * @param languageId
     */
    public ProductDescriptionPost(String languageId, String name, String description, String metaTitle,
                              String metaDescription, String metaKeyword, String tag) {
        super();
        this.languageId = languageId;
        this.name = name;
        this.description = description;
        this.metaTitle = metaTitle;
        this.metaDescription = metaDescription;
        this.metaKeyword = metaKeyword;
        this.tag = tag;
    }

    public String getLanguageId() {
        return languageId;
    }

    public void setLanguageId(String languageId) {
        this.languageId = languageId;
    }

    public ProductDescriptionPost withLanguageId(String languageId) {
        this.languageId = languageId;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductDescriptionPost withName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductDescriptionPost withDescription(String description) {
        this.description = description;
        return this;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public ProductDescriptionPost withMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
        return this;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public ProductDescriptionPost withMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
        return this;
    }

    public String getMetaKeyword() {
        return metaKeyword;
    }

    public void setMetaKeyword(String metaKeyword) {
        this.metaKeyword = metaKeyword;
    }

    public ProductDescriptionPost withMetaKeyword(String metaKeyword) {
        this.metaKeyword = metaKeyword;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public ProductDescriptionPost withTag(String tag) {
        this.tag = tag;
        return this;
    }

}
