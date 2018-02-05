package mjuApps.model.banking;

import mjuApps.service.banking.Depositable;

import java.util.HashMap;
import java.util.Map;

public class Bank implements Depositable {

    private Map<Integer,Integer> deposit;

    public Bank() {
        this.deposit = new HashMap<>();
        this.deposit.put(1000,10);
        this.deposit.put(500,30);
        this.deposit.put(100,40);
        this.deposit.put(50,30);
        this.deposit.put(20,40);
        this.deposit.put(10,50);
        this.deposit.put(5,30);
    }

    @Override
    public Map<Integer, Integer> addToDeposit(Map<Integer, Integer> givenDeposit) {
        Map<Integer, Integer> deposit = givenDeposit;

        for (Map.Entry<Integer,Integer> entry : deposit.entrySet()) {
            int entryKey = entry.getKey();
            int entryValue = entry.getValue();
            int depositValue = this.deposit.get(entryKey);
            this.deposit.put(entryKey,entryValue+depositValue);
        }

        return deposit;
    }

    @Override
    public Map<Integer, Integer> deductDeposit(Map<Integer, Integer> depositToBeTaken) {
        Map<Integer, Integer> deposit = depositToBeTaken;

        for (Map.Entry<Integer, Integer> entry : deposit.entrySet()) {
            int entryKey = entry.getKey();
            int entryValue = entry.getValue();
            int depositValue = this.deposit.get(entryKey);
            this.deposit.put(entryKey,depositValue-entryValue);
        }

        return deposit;
    }

    public Map<Integer, Integer> getDeposit() {
        return deposit;
    }

    public void setDeposit(Map<Integer, Integer> deposit) {
        this.deposit = deposit;
    }
}
