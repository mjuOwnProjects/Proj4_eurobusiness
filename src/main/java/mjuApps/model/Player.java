package mjuApps.model;

import java.util.HashMap;
import java.util.Map;

public class Player {

    private String name;
    private Map<Integer,Integer> bankNotes;

    public Player(String name) {
        this.name = name;
        this.bankNotes = new HashMap<>();
        this.bankNotes.put(1000,1);
        this.bankNotes.put(500,2);
        this.bankNotes.put(100,6);
        this.bankNotes.put(50,4);
        this.bankNotes.put(20,5);
        this.bankNotes.put(10,8);
        this.bankNotes.put(5,4);
    }

    public Map<Integer, Integer> getBankNotes() {
        return bankNotes;
    }
}
