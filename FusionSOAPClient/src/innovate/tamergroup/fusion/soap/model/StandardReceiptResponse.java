package innovate.tamergroup.fusion.soap.model;

import java.util.HashMap;

public class StandardReceiptResponse {
    
    private Boolean successResponse;
    private HashMap<String, String> customerReceiptReferenceMap = new HashMap<>();
    
    public StandardReceiptResponse() {
        super();
    }

    public void setSuccessResponse(Boolean successResponse) {
        this.successResponse = successResponse;
    }

    public Boolean getSuccessResponse() {
        return successResponse;
    }

    public void setCustomerReceiptReferenceMap(HashMap<String, String> customerReceiptReferenceMap) {
        this.customerReceiptReferenceMap = customerReceiptReferenceMap;
    }

    public HashMap<String, String> getCustomerReceiptReferenceMap() {
        return customerReceiptReferenceMap;
    }
}
