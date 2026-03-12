package innovate.tamergroup.fusion;

import java.util.concurrent.atomic.AtomicInteger;

import oracle.adf.view.rich.context.AdfFacesContext;

import org.apache.myfaces.trinidad.event.PollEvent;
import org.apache.myfaces.trinidad.model.BoundedRangeModel;

public class ProgressIndicatorBean extends BoundedRangeModel {
    
    private AtomicInteger count = new AtomicInteger(0);
    private int procVal = 0, totalCount = 0, pollInterval = -1;
    private CompletionCallback callback;
    
    public ProgressIndicatorBean() {
        super();
    }
    
    public void setParams(AtomicInteger count, int totalCount, CompletionCallback callback) {
        this.count = count;
        this.totalCount = totalCount;
        this.callback = callback;
    }

    @Override
    public long getMaximum() {
        return 100;
    }

    @Override
    public long getValue() {
        if (totalCount != 0) 
            procVal = (count.get() / totalCount) * 100;
        return procVal;
    }
    
    public void pollListnerEvt(PollEvent pollEvent) {
        if (procVal == getMaximum()) {
            pollInterval = -1;
            AdfFacesContext.getCurrentInstance().addPartialTarget(pollEvent.getComponent());
            callback.onCompletion();
        }
    }

    public int getProcVal() {
        return procVal;
    }

    public void setProcVal(int procVal) {
        this.procVal = procVal;
    }

    public void setPollInterval(int pollInterval) {
        this.pollInterval = pollInterval;
    }

    public int getPollInterval() {
        return pollInterval;
    }
}
