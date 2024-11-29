import java.util.HashMap;
import java.util.Map;

interface InMemoryDB {
    int get(String key);

    void put(String key, int val);

    void begin_transaction();

    void commit();

    void rollback();

}

public class InMemoryDBImpl implements InMemoryDB {
    private Map<String, Integer> mainState; // Committed data
    private Map<String, Integer> transactionState; // Data in current transaction
    private boolean inTransaction;

    public InMemoryDBImpl() {
        System.out.println("InMemoryDB created");
        mainState = new HashMap<>();
        inTransaction = false;
    }


    public void put(String key, int val) {
        if (inTransaction) {
            System.out.println("Transaction in progress");
            transactionState.put(key, val);
        } else {
            throw new RuntimeException("No transaction in progress");
        }
    }

    @Override
    public int get(String key) { // Note the return type is now Integer, to allow null values
        if (mainState.containsKey(key)) {
            System.out.println("Key found in mainState" + " "  + " " + key + " with value " + mainState.get(key));
            return mainState.get(key);
        }
        System.out.println("Key not found in mainState");
        return -1;
    }

    public void begin_transaction() {
        if (inTransaction) {
            throw new RuntimeException("Transaction already in progress");
        }
        System.out.println("Transaction started");
        inTransaction = true;
        transactionState = new HashMap<>();
        
    }

    public void commit() {
        if (!inTransaction) {
            throw new RuntimeException("No transaction in progress");
        }
        // add transactionState to mainState
        System.out.println("Transaction committed");
        mainState.putAll(transactionState);
        inTransaction = false;
        
    }

    public void rollback() {
        if (!inTransaction) {
            throw new RuntimeException("No transaction in progress");
        }
        System.out.println("Transaction rolled back");
        inTransaction = false;
        transactionState = null;
        
    }
}

