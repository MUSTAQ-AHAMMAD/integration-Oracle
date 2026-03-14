package innovate.tamergroup.shared.utils;

/**
 * Application-wide constants used across the integration middleware.
 *
 * <p>This class acts as a central registry of string literals so that the
 * same value is never hard-coded in more than one place.</p>
 *
 * <p><b>How to use:</b></p>
 * <ol>
 *   <li>Import this class in any component that needs to check or set a
 *       status or mode value.</li>
 *   <li>Reference the relevant constant by its fully qualified name, e.g.
 *       {@code Constants.RUNNING}, instead of using a raw string literal.</li>
 * </ol>
 *
 * <p><b>Scheduler status constants</b> ({@link #RUNNING}, {@link #IDLE})
 * are stored in the database and shown in the UI to indicate whether the
 * Quartz scheduler is currently processing a job.</p>
 *
 * <p><b>Integration mode constants</b> ({@link #AUTOMATIC}, {@link #MANUAL},
 * {@link #NONE}) control how integration jobs are triggered:
 * {@code AUTOMATIC} means the Quartz cron schedule is active, {@code MANUAL}
 * means a user triggered the job from the UI, and {@code NONE} means the
 * scheduler has not yet been started.</p>
 */
public class Constants {

    /**
     * Constructs a Constants instance.
     * All members are {@code static final}; direct instantiation is not required.
     */
    public Constants() {
        super();
    }

    /**
     * Scheduler / job status indicating that an integration job is currently
     * executing.
     *
     * <p>Set on the integration status record in the database before a job
     * starts and cleared (set to {@link #IDLE}) when it finishes.</p>
     */
    public static final String RUNNING = "RUNNING";

    /**
     * Scheduler / job status indicating that no integration job is currently
     * executing and the system is waiting for the next scheduled trigger or
     * manual invocation.
     */
    public static final String IDLE = "IDLE";

    /**
     * Integration mode indicating that jobs are triggered automatically by
     * the Quartz cron scheduler without any manual intervention.
     */
    public static final String AUTOMATIC = "AUTOMATIC";

    /**
     * Integration mode indicating that a job was triggered manually by a
     * user through the ADF UI rather than by the cron schedule.
     */
    public static final String MANUAL = "MANUAL";

    /**
     * Integration mode indicating that the scheduler has not been started
     * and no integration mode has been selected yet.
     */
    public static final String NONE = "NONE";
}
