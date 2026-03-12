package innovate.tamergroup.shared.utils;

public class FusionAppParams {
    
    private String hostname;
    private String region;


    public FusionAppParams(String hostname, String region) {
        this.hostname = hostname;
        this.region = region;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getHostname() {
        return hostname;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }
}
