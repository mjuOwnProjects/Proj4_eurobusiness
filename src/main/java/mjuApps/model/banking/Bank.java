package mjuApps.model.banking;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private Map<Integer,Integer> bankDeposit;

    public Bank() {
        this.bankDeposit = new HashMap<>();
        this.bankDeposit.put(1000,10);
        this.bankDeposit.put(500,30);
        this.bankDeposit.put(100,40);
        this.bankDeposit.put(50,30);
        this.bankDeposit.put(20,40);
        this.bankDeposit.put(10,50);
        this.bankDeposit.put(5,30);
    }

    public Map<Integer, Integer> getBankDeposit() {
        return bankDeposit;
    }

    public Map<Integer, Integer> addToBankDeposit(Map<Integer, Integer> givenDeposit) {
        Map<Integer, Integer> deposit = givenDeposit;

        for (Map.Entry<Integer,Integer> entry : deposit.entrySet()) {
            int entryKey = entry.getKey();
            int entryValue = entry.getValue();
            int depositValue = this.bankDeposit.get(entryKey);
            this.bankDeposit.put(entryKey,entryValue+depositValue);
        }

        return deposit;
    }

    public Map<Integer, Integer> deductBankDeposit(Map<Integer, Integer> depositToBeTaken) {
        Map<Integer, Integer> deposit = depositToBeTaken;

        for (Map.Entry<Integer, Integer> entry : deposit.entrySet()) {
            int entryKey = entry.getKey();
            int entryValue = entry.getValue();
            int depositValue = this.bankDeposit.get(entryKey);
            this.bankDeposit.put(entryKey,depositValue-entryValue);
        }

        return deposit;
    }
}
