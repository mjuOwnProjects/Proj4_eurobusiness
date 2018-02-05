package mjuApps.service.player;

import mjuApps.model.player.Dice;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiceServiceTest {

    Dice dice;
    DiceService diceService;

    @Before
    public void setUp() throws Exception {
        dice = new Dice();
        diceService = new DiceService(dice);
    }

    @Test
    public void throwDicesWithOneDoublet() {
        getDiceServiceObject();
    }

    private void getDiceServiceObject() {
        Class diceClass = diceService.getClass();
//        Field
    }
}