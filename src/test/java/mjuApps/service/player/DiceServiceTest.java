package mjuApps.service.player;

import mjuApps.model.player.Dice;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

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
    public void performThrowsTest() {
        diceService.performThrows(dice);
        int[] firstThrow = diceService.getFirstThrow();
        int[] secondThrow = diceService.getSecondThrow();

        Assert.assertTrue("First result of the first throw is from 1 - 6", firstThrow[0]>=1 && firstThrow[0]<=6);
        Assert.assertTrue("Second result of the first throw is from 1 - 6", firstThrow[1]>=1 && firstThrow[1]<=6);
        Assert.assertTrue("First result of the second throw is from 1 - 6", secondThrow[0]>=1 && secondThrow[0]<=6);
        Assert.assertTrue("Second result of the second throw is from 1 - 6", secondThrow[1]>=1 && secondThrow[1]<=6);
    }

    @Test
    public void regularDicesThrowTest() throws Exception {
        int[] firstThrow = new int[]{1,6};
        int[] secondThrow = new int[]{2,5};
        Optional<Integer> throwResult = diceService.validateThrowsAndGetResult(firstThrow,secondThrow);

        Assert.assertEquals("1+6=7", Integer.valueOf(7), throwResult.get());
    }

    @Test
    public void throwDicesWithOneDoublet() throws Exception {
        int[] firstThrow = new int[]{6,6};
        int[] secondThrow = new int[]{2,5};
        Optional<Integer> throwResult = diceService.validateThrowsAndGetResult(firstThrow,secondThrow);

        Assert.assertEquals("(6+6)+(2+5)=19", Integer.valueOf(19), throwResult.get());
    }

    @Test
    public void throwDicesWithTwoDoublets() throws Exception {
        int[] firstThrow = new int[]{6,6};
        int[] secondThrow = new int[]{5,5};
        Optional<Integer> throwResult = diceService.validateThrowsAndGetResult(firstThrow,secondThrow);

        Assert.assertEquals("(6+6)+(5+5) = metoda powinna zwrócić pusty optional", Optional.empty(), throwResult);
    }
}