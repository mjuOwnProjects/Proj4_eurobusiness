package mjuApps.model.player;

import java.util.HashMap;
import java.util.Map;

public class Player {

    private String name;
    private Map<Integer,Integer> playerDeposit;

    public Player(String name) {
        this.name = name;
        this.playerDeposit = new HashMap<>();
        this.playerDeposit.put(1000,1);
        this.playerDeposit.put(500,2);
        this.playerDeposit.put(100,6);
        this.playerDeposit.put(50,4);
        this.playerDeposit.put(20,5);
        this.playerDeposit.put(10,8);
        this.playerDeposit.put(5,4);
    }

    public Map<Integer, Integer> getPlayerDeposit() {
        return playerDeposit;
    }
}
