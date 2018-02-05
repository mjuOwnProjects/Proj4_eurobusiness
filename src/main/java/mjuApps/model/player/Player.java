package mjuApps.model.player;

import mjuApps.service.banking.Depositable;

import java.util.HashMap;
import java.util.Map;

public class Player implements Depositable {

    private String name;
    private Map<Integer,Integer> deposit;

    public Player(String name) {
        this.name = name;
        this.deposit = new HashMap<>();
        this.deposit.put(1000,1);
        this.deposit.put(500,2);
        this.deposit.put(100,6);
        this.deposit.put(50,4);
        this.deposit.put(20,5);
        this.deposit.put(10,8);
        this.deposit.put(5,4);
    }

    //TODO przerobić aby nie było tutaj powtórzeń
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

    //TODO przerobić aby nie było tutaj powtórzeń
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
}
