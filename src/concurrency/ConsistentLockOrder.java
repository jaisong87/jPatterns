package concurrency;

/*
 * Pattern - ConsistentLockOrder
 * 
 * @ref - Kuchana(2004)
 */
public class ConsistentLockOrder {

    private Object objA, objB; 
    /* Lock-order policy : Always lock objA followed by objB */

    public ConsistentLockOrder() {
        objA = new Object();
        objB = new Object();
    }

    /* Function is Safe because it is consistent with lock-order policy*/
    public void safeFunction1() {
        synchronized(objA) {
            System.out.println("SafeFunction1 : Acquired lock objA waiting for objB");
            synchronized(objB) {
                // Processing goes here
                System.out.println("Successfully completed safeFunction1");
            }
        }
    }

    /* Function is Safe because it is consistent with lock-order policy*/
    public void safeFunction2() {
        synchronized(objA) {
            System.out.println("SafeFunction2 : Acquired lock objA waiting for objB");
            synchronized(objB) {
                // Processing goes here
                System.out.println("Successfully completed safeFunction2");
            }
        }
    }

    /* Function is not Safe because it is inconsistent with lock-order policy
     * CONSEQUENCE : Terrible deadlock ( at-least 2 threads lock, partial or full choke in the application ) 
     */
    public void safeFunction3() {
        synchronized(objB) {
            System.out.println("SafeFunction3 : Acquired lock objA waiting for objB");
            synchronized(objA) {
                // Processing goes here
                System.out.println("Successfully completed safeFunction3");
            }
        }
    }
}
