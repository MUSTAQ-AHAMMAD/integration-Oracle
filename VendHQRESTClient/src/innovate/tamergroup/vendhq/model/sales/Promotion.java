package innovate.tamergroup.vendhq.model.sales;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Promotion {
    
    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("promotion_id")
    @Expose
    private String promotion_id;


    public Promotion(Double amount, String name, String promotion_id) {
        this.amount = amount;
        this.name = name;
        this.promotion_id = promotion_id;
    }


    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPromotion_id(String promotion_id) {
        this.promotion_id = promotion_id;
    }

    public String getPromotion_id() {
        return promotion_id;
    }
}
