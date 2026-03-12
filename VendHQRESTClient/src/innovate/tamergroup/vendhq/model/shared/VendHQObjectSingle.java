package innovate.tamergroup.vendhq.model.shared;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class VendHQObjectSingle<T extends Object> {
    
    @SerializedName("data")
    @Expose
    private T data = null;
    @SerializedName("includes")
    @Expose
    private Object includes;


    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setIncludes(Object includes) {
        this.includes = includes;
    }

    public Object getIncludes() {
        return includes;
    }
}
