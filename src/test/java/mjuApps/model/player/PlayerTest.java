package mjuApps.model.player;

import mjuApps.abstractCommonTest.AbstractCommonTest;
import mjuApps.model.banking.Bank;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PlayerTest extends AbstractCommonTest {

    Player player;
    Map<Integer, Integer> testDeposit;

    @Before
    public void setUp() {
        player = new Player("test player");  //Bank: 1000 x 1, 500 x 2, 100 x 6, 50 x 4, 20 x 5, 10 x 8, 5 x 4
        testDeposit = createTestDeposit();
    }

    @Test
    public void addToPlayerDeposit() {
        player.addToDeposit(testDeposit);

        Map<Integer,Integer> deductedDeposit = player.getDeposit();

        Assert.assertEquals("1000$ x 2", Integer.valueOf(2),Integer.valueOf(deductedDeposit.get(1000)));
        Assert.assertEquals("500$ x 3",Integer.valueOf(3),Integer.valueOf(deductedDeposit.get(500)));
        Assert.assertEquals("100$ x 7",Integer.valueOf(7),Integer.valueOf(deductedDeposit.get(100)));
        Assert.assertEquals("50$ x 5",Integer.valueOf(5),Integer.valueOf(deductedDeposit.get(50)));
        Assert.assertEquals("20$ x 6",Integer.valueOf(6),Integer.valueOf(deductedDeposit.get(20)));
        Assert.assertEquals("10$ x 9",Integer.valueOf(9),Integer.valueOf(deductedDeposit.get(10)));
        Assert.assertEquals("5$ x 5",Integer.valueOf(5),Integer.valueOf(deductedDeposit.get(5)));
    }

    @Test
    public void deductPlayerDeposit() {
        player.deductDeposit(testDeposit);
        Map<Integer,Integer> deductedDeposit = player.getDeposit();

        Assert.assertEquals("1000$ x 0", Integer.valueOf(0),Integer.valueOf(deductedDeposit.get(1000)));
        Assert.assertEquals("500$ x 1",Integer.valueOf(1),Integer.valueOf(deductedDeposit.get(500)));
        Assert.assertEquals("100$ x 5",Integer.valueOf(5),Integer.valueOf(deductedDeposit.get(100)));
        Assert.assertEquals("50$ x 3",Integer.valueOf(3),Integer.valueOf(deductedDeposit.get(50)));
        Assert.assertEquals("20$ x 4",Integer.valueOf(4),Integer.valueOf(deductedDeposit.get(20)));
        Assert.assertEquals("10$ x 7",Integer.valueOf(7),Integer.valueOf(deductedDeposit.get(10)));
        Assert.assertEquals("5$ x 3",Integer.valueOf(3),Integer.valueOf(deductedDeposit.get(5)));
    }

}