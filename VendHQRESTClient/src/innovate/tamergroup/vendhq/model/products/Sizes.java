package innovate.tamergroup.vendhq.model.products;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sizes {

    @SerializedName("ss")
    @Expose
    private String ss;
    @SerializedName("standard")
    @Expose
    private String standard;
    @SerializedName("st")
    @Expose
    private String st;
    @SerializedName("original")
    @Expose
    private String original;
    @SerializedName("thumb")
    @Expose
    private String thumb;
    @SerializedName("sl")
    @Expose
    private String sl;
    @SerializedName("sm")
    @Expose
    private String sm;
    
    public String getSs() {
    return ss;
    }
    
    public void setSs(String ss) {
    this.ss = ss;
    }
    
    public String getStandard() {
    return standard;
    }
    
    public void setStandard(String standard) {
    this.standard = standard;
    }
    
    public String getSt() {
    return st;
    }
    
    public void setSt(String st) {
    this.st = st;
    }
    
    public String getOriginal() {
    return original;
    }
    
    public void setOriginal(String original) {
    this.original = original;
    }
    
    public String getThumb() {
    return thumb;
    }
    
    public void setThumb(String thumb) {
    this.thumb = thumb;
    }
    
    public String getSl() {
    return sl;
    }
    
    public void setSl(String sl) {
    this.sl = sl;
    }
    
    public String getSm() {
    return sm;
    }
    
    public void setSm(String sm) {
    this.sm = sm;
    }

}
