package innovate.tamergroup.shared.utils;

/**
 * Callback interface used by {@link BackgroundTaskExecutor} to notify callers
 * when an asynchronous integration task has finished.
 *
 * <p><b>Step-by-step usage:</b></p>
 * <ol>
 *   <li>Implement this interface in the class that submits a background task
 *       (for example, an ADF Managed Bean or a job scheduler class).</li>
 *   <li>Provide the implementation body of {@link #onExecutionComplete()} to
 *       perform any post-task work, such as updating a UI progress indicator,
 *       logging a completion message, or triggering the next job in a
 *       pipeline.</li>
 *   <li>Pass the implementing object as the second argument to
 *       {@link BackgroundTaskExecutor#execute(Runnable, ExecutionListener)}.</li>
 *   <li>{@link BackgroundTaskExecutor} calls {@link #onExecutionComplete()}
 *       automatically once the task's {@link Future#get()} call returns
 *       without throwing an exception.</li>
 * </ol>
 *
 * <p><b>Example:</b></p>
 * <pre>{@code
 * BackgroundTaskExecutor.getInstance().execute(myTask, () -> {
 *     statusLabel.setValue("Integration completed successfully.");
 * });
 * }</pre>
 */
public interface ExecutionListener {

    /**
     * Called by {@link BackgroundTaskExecutor} after the submitted
     * {@link Runnable} task has completed successfully.
     *
     * <p>Implementations should keep this method lightweight (e.g. update a
     * status flag or schedule a UI refresh) because it is invoked on the
     * same thread that called
     * {@link BackgroundTaskExecutor#execute(Runnable, ExecutionListener)}.</p>
     */
    void onExecutionComplete();
}
