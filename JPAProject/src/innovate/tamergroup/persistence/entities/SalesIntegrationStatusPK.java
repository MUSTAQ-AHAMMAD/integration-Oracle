package innovate.tamergroup.persistence.entities;

import java.io.Serializable;

public class SalesIntegrationStatusPK implements Serializable {
    private String integMode;
    private String region;

    public SalesIntegrationStatusPK() {
    }

    public SalesIntegrationStatusPK(String integMode, String region) {
        this.integMode = integMode;
        this.region = region;
    }

    public boolean equals(Object other) {
        if (other instanceof SalesIntegrationStatusPK) {
            final SalesIntegrationStatusPK otherSalesIntegrationStatusPK = (SalesIntegrationStatusPK) other;
            final boolean areEqual = true;
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String getIntegMode() {
        return integMode;
    }

    public void setIntegMode(String integMode) {
        this.integMode = integMode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
