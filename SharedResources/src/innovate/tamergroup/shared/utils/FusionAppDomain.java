package innovate.tamergroup.shared.utils;

public enum FusionAppDomain {
    
    SCM("scm"), FIN("fin");
    
    private String appDomain;
    
    private FusionAppDomain(String appDomain) {
        this.appDomain = appDomain;
    }
    
    public String getAppDomain() {
        return this.appDomain;
    }
    
}
