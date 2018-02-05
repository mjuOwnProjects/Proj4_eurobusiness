package mjuApps.model.player;

import java.util.Random;

public class Dice {

    private Random random;

    public Dice() {
        this.random = new Random();
    }

    public int throwDice() {
        return random.nextInt(6) + 1; //result of random is from 0 incl. to 6 excl. so that is why it is +1
    }

}
