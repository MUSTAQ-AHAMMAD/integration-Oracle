package innovate.tamergroup.shared.utils;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * BackgroundTaskExecutor is a Singleton that manages asynchronous execution of
 * integration tasks using a fixed-size thread pool.
 *
 * <p><b>Step-by-step usage:</b></p>
 * <ol>
 *   <li>Obtain the single shared instance via {@link #getInstance()}.</li>
 *   <li>Create a {@link Runnable} containing the work to be done in the
 *       background (e.g. an integration job).</li>
 *   <li>Optionally implement {@link ExecutionListener} to receive a callback
 *       when the task finishes.</li>
 *   <li>Call {@link #execute(Runnable, ExecutionListener)} to submit the task.
 *       The task runs on one of the 4 worker threads; the calling thread
 *       blocks only inside {@code completionDetector} until the task is
 *       done.</li>
 *   <li>When the task completes, {@link ExecutionListener#onExecutionComplete()}
 *       is invoked so the caller can update UI state or trigger follow-up
 *       logic.</li>
 * </ol>
 *
 * <p><b>Thread pool size:</b> 4 threads (configurable by changing the
 * argument passed to {@link Executors#newFixedThreadPool(int)}).</p>
 *
 * <p><b>Singleton guarantee:</b> {@link #getInstance()} is {@code synchronized}
 * so the instance is created only once even under concurrent access.</p>
 */
public class BackgroundTaskExecutor {

    /** The single shared instance (lazy-initialized). */
    private static BackgroundTaskExecutor instance;

    /**
     * Fixed thread pool with 4 worker threads used to run submitted tasks
     * concurrently without creating a new thread for every request.
     */
    ExecutorService executor = Executors.newFixedThreadPool(4);

    /**
     * Creates a new BackgroundTaskExecutor.
     * Prefer {@link #getInstance()} over direct instantiation.
     */
    public BackgroundTaskExecutor() {
        super();
    }

    /**
     * Returns the application-wide singleton instance of
     * {@code BackgroundTaskExecutor}, creating it on the first call.
     *
     * <p>This method is {@code synchronized} to guarantee that only one
     * instance is created when multiple threads call it simultaneously.</p>
     *
     * @return the shared {@code BackgroundTaskExecutor} instance
     */
    public static synchronized BackgroundTaskExecutor getInstance() {
        if (instance == null) {
            instance = new BackgroundTaskExecutor();
        }
        return instance;
    }

    /**
     * Submits a task for asynchronous execution and waits for its completion.
     *
     * <p><b>How it works:</b></p>
     * <ol>
     *   <li>The {@code task} is submitted to the internal thread pool via
     *       {@link ExecutorService#submit(Runnable, Object)}.</li>
     *   <li>A {@link Future} is returned immediately, representing the
     *       pending result.</li>
     *   <li>{@link #completionDetector(Future, ExecutionListener)} is called
     *       to block until the task finishes and then fire the callback.</li>
     * </ol>
     *
     * @param task              the {@link Runnable} containing the integration
     *                          logic to run in a background thread; must not
     *                          be {@code null}
     * @param executionListener callback notified when the task completes;
     *                          may be {@code null} if no callback is needed
     */
    public void execute(Runnable task, ExecutionListener executionListener) {
        Future<Void> future = executor.submit(task, null);
        //updateStatus(executionListener);
        completionDetector(future, executionListener);
    }

    /**
     * Waits for the supplied {@link Future} to complete and then notifies
     * the {@link ExecutionListener}.
     *
     * <p><b>Step-by-step flow:</b></p>
     * <ol>
     *   <li>Calls {@link Future#get()} which blocks the current thread until
     *       the background task finishes.</li>
     *   <li>If the task completes normally and {@code executionListener} is
     *       not {@code null}, calls
     *       {@link ExecutionListener#onExecutionComplete()}.</li>
     *   <li>If an {@link ExecutionException} or {@link InterruptedException}
     *       is thrown (i.e. the task itself threw an exception, or the wait
     *       was interrupted), the error is logged to standard output.</li>
     * </ol>
     *
     * @param future            the {@link Future} representing the running task
     * @param executionListener callback to invoke on successful completion;
     *                          may be {@code null}
     */
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
