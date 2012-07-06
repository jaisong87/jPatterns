package concurrency;

/*
 * Pattern -readWriteLock
 * 
 * @ref - Grand98, Lea97, Kuchana(2004)
 * 
 * This is a good abstraction that could be extended
 * by thread-safe classes
 * 
 * Another option is to make getReadLock, getWriteLock, releaseLock 
 * public and use an instance of ReadWriteLock   
 */
public class ReadWriteLock {

    private String _logFile;
    private Object rwLock;

    private boolean writeLockGiven;
    private int readLockRefCount;
    private int waitingWriteLocks;

    public ReadWriteLock(String logFile) {
        _logFile = logFile;
        writeLockGiven = false;
        readLockRefCount = 0;
        waitingWriteLocks = 0;
    }

    private void getReadLock() {
        synchronized(rwLock) {
            while( writeLockGiven == true || waitingWriteLocks>0 ) {
                try {
                    rwLock.wait();
                    }
                catch(Exception e) {
                    e.printStackTrace();
                }
                
            }
            /* Finally we got a read Lock */
            readLockRefCount++;
        }
    }

    private void getWriteLock() {
        synchronized(rwLock) {
            waitingWriteLocks++; /* */
            while( writeLockGiven == true ) {
                try {
                    rwLock.wait();
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
            writeLockGiven = true; /*this aquired the writeLock*/
            waitingWriteLocks--;
        }
    }

    /* Release the lock */
    private void releaseLock() {
        synchronized(rwLock) {
            if(writeLockGiven == true) {
                writeLockGiven = false;
            } else {
                readLockRefCount--;
            }
            rwLock.notifyAll();
            }
    }

    public void setLogFile(String logFile) {
        getWriteLock();
        _logFile = logFile;
        releaseLock();
    }

    public String getLogFile() {
        getReadLock();
        String curLogFile = _logFile;
        return curLogFile;
    }
}
