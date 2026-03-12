package innovate.tamergroup.opencart.rest.model.shared;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OpencartListResponse<T extends Object> {
    
    @SerializedName("success")
    @Expose
    private int success;
    @SerializedName("error")
    @Expose
    private List<String> error = null;
    @SerializedName("data")
    @Expose
    private List<T> data = null;
    private final static long serialVersionUID = -1356361644177896124L;

    /**
    * No args constructor for use in serialization
    * 
    */
    public OpencartListResponse() {
    }

    /**
    * 
    * @param error
    * @param data
    * @param success
    */
    public OpencartListResponse(int success, List<String> error, List<T> data) {
    super();
    this.success = success;
    this.error = error;
    this.data = data;
    }

    public int getSuccess() {
    return success;
    }

    public void setSuccess(int success) {
    this.success = success;
    }

    public List<String> getError() {
    return error;
    }

    public void setError(List<String> error) {
    this.error = error;
    }

    public List<T> getData() {
    return data;
    }

    public void setData(List<T> data) {
    this.data = data;
    }
    
}
