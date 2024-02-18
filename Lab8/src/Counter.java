/**

 Class creating a counter object.
 */
public class Counter {
    private long totalCount = 0;

    /**

     Synchronized method for incrementing the counter.
     */
    public synchronized void increment() {
        totalCount = totalCount + 1;
    }
    /**

     Method returning the counter value.
     @return the value of the counter
     */
    public long getCount() {
        return totalCount;
    }
}