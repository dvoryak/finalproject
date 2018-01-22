package service.transaction;


/**
 * @author paveldvoryak
 * @version 1.0
 */
public interface TransactionManager {

    /**
     * Process a transaction
     *
     * @param operation implementation of {@link Operation}
     * @param <T> generic type T
     * @return
     */
    <T> T processTransaction(Operation<T> operation);
}
