/**
 * Class implementing the Runnable interface to increment a given counter.
 */
public class Numbers implements Runnable {
    private Counter totalCount;

    /**
     * Constructor accepting one parameter.
     * @param totalCount the counter
     */
    public Numbers(Counter totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * Method responsible for executing the thread.
     */
    @Override
    public void run() {
        for (int i = 1; i < 100001; i++) {
            getCounter().increment();
        }
    }

    /**
     * Method returning the counter.
     * @return the counter
     */
    public Counter getCounter() {
        return totalCount;
    }

    /**
     * Method setting a new counter.
     * @param totalCount the new counter
     */
    public void setCounter(Counter totalCount) {
        this.totalCount = totalCount;
    }
}