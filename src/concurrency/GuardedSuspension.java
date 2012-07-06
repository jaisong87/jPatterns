package concurrency;

/*
 * Pattern - GuardedSuspension
 * 
 * @ref - Kuchana(2004)
 * 
 * A Task is suspended till the time the precondition is satisfied
 * Once the precondition is met, the Task gets a call-back so that it could
 * wake up from sleep and handle the implementation.
 */

public class GuardedSuspension {

    private boolean isDirty;
    private String _logFile; 

    public GuardedSuspension(String curLogFile)
    {
        _logFile = curLogFile;
        isDirty = false;
    }

    public synchronized void guardedMethod() {
        while(!precondition())
        {
            try {
                wait();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
            
        }

        /* We took care of the issues */
        isDirty = false;
        System.out.println("Log File is changed to "+_logFile);
    }

    public boolean precondition() {
        return isDirty;
    }

    public synchronized void updateLoggerFile(String logFile) {
        /* Update object State */
        _logFile = logFile;
        isDirty = true;
        notify(); /* Inform waiting threads */
    }
    
}
