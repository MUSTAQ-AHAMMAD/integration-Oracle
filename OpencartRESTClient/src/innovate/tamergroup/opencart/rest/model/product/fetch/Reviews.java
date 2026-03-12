
package innovate.tamergroup.opencart.rest.model.product.fetch;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Reviews implements Serializable {

    @SerializedName("review_total")
    @Expose
    private String reviewTotal;
    private final static long serialVersionUID = 6731343158045294324L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Reviews() {
    }

    /**
     *
     * @param reviewTotal
     */
    public Reviews(String reviewTotal) {
        super();
        this.reviewTotal = reviewTotal;
    }

    public String getReviewTotal() {
        return reviewTotal;
    }

    public void setReviewTotal(String reviewTotal) {
        this.reviewTotal = reviewTotal;
    }

}
