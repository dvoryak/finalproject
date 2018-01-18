package service.transaction;

public interface TransactionManager {

    <T> T processTransaction(Operation<T> operation);
}
