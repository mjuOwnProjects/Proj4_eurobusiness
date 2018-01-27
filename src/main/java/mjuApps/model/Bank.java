package mjuApps.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {

    private Map<Integer,Integer> bankNotes;

    public Bank() {
        this.bankNotes = new HashMap<>();
        this.bankNotes.put(1000,10);
        this.bankNotes.put(500,30);
        this.bankNotes.put(100,40);
        this.bankNotes.put(50,30);
        this.bankNotes.put(20,40);
        this.bankNotes.put(10,50);
        this.bankNotes.put(5,30);
    }

    public Map<Integer, Integer> getBankNotes() {
        return bankNotes;
    }
}
