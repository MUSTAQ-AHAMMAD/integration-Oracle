package innovate.tamergroup.shared.utils;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BackgroundTaskExecutor {

    private static BackgroundTaskExecutor instance;
    ExecutorService executor = Executors.newFixedThreadPool(4);

    public BackgroundTaskExecutor() {
        super();
    }

    public static synchronized BackgroundTaskExecutor getInstance() {
        if (instance == null) {
            instance = new BackgroundTaskExecutor();
        }
        return instance;
    }

    public void execute(Runnable task, ExecutionListener executionListener) {
        Future<Void> future = executor.submit(task, null);
        //updateStatus(executionListener);
        completionDetector(future, executionListener);
    }
    
    
    private void completionDetector(Future<Void> future, ExecutionListener executionListener) {
        try {
            future.get();
            if (executionListener != null) 
                executionListener.onExecutionComplete();
        } catch (ExecutionException | InterruptedException e) {
            Throwable c = e.getCause();
              System.out.println("Something happened running task" + e.getMessage());
        }
    }
}
