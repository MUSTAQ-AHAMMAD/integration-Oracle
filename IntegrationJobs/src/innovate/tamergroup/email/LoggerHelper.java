package innovate.tamergroup.email;

import java.util.ArrayList;
import java.util.List;

public class LoggerHelper {

    private List<String[]> infoLines;
    private List<String[]> errorLines;
    private Exception exceptionRaised = null;


    public LoggerHelper() {
        this.infoLines = new ArrayList<>();
        this.errorLines = new ArrayList<>();
    }


    public List<String[]> getInfoLines() {
        return infoLines;
    }

    public List<String[]> getErrorLines() {
        return errorLines;
    }

    public void setExceptionRaised(Exception exceptionRaised) {
        this.exceptionRaised = exceptionRaised;
    }

    public Exception getExceptionRaised() {
        return exceptionRaised;
    }
}
