package mjuApps.model.banking;

import mjuApps.abstractCommonTest.AbstractCommonTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class BankTest extends AbstractCommonTest{

    Bank bank;
    Map<Integer, Integer> testDeposit;

    @Before
    public void setUp() {
        bank = new Bank();  //Bank: 1000 x 10, 500 x 30, 100 x 40, 50 x 30, 20 x 40, 10 x 50, 5 x 30
        testDeposit = createTestDeposit();
    }

    @Test
    public void addToBankDeposit() {
        bank.addToDeposit(testDeposit);

        Map<Integer,Integer> deductedDeposit = bank.getDeposit();

        Assert.assertEquals("1000$ x 9", Integer.valueOf(11),Integer.valueOf(deductedDeposit.get(1000)));
        Assert.assertEquals("500$ x 29",Integer.valueOf(31),Integer.valueOf(deductedDeposit.get(500)));
        Assert.assertEquals("100$ x 39",Integer.valueOf(41),Integer.valueOf(deductedDeposit.get(100)));
        Assert.assertEquals("50$ x 29",Integer.valueOf(31),Integer.valueOf(deductedDeposit.get(50)));
        Assert.assertEquals("20$ x 39",Integer.valueOf(41),Integer.valueOf(deductedDeposit.get(20)));
        Assert.assertEquals("10$ x 49",Integer.valueOf(51),Integer.valueOf(deductedDeposit.get(10)));
        Assert.assertEquals("5$ x 29",Integer.valueOf(31),Integer.valueOf(deductedDeposit.get(5)));
    }

    @Test
    public void deductBankDeposit() {
        bank.deductDeposit(testDeposit);
        Map<Integer,Integer> deductedDeposit = bank.getDeposit();

        Assert.assertEquals("1000$ x 9", Integer.valueOf(9),Integer.valueOf(deductedDeposit.get(1000)));
        Assert.assertEquals("500$ x 29",Integer.valueOf(29),Integer.valueOf(deductedDeposit.get(500)));
        Assert.assertEquals("100$ x 39",Integer.valueOf(39),Integer.valueOf(deductedDeposit.get(100)));
        Assert.assertEquals("50$ x 29",Integer.valueOf(29),Integer.valueOf(deductedDeposit.get(50)));
        Assert.assertEquals("20$ x 39",Integer.valueOf(39),Integer.valueOf(deductedDeposit.get(20)));
        Assert.assertEquals("10$ x 49",Integer.valueOf(49),Integer.valueOf(deductedDeposit.get(10)));
        Assert.assertEquals("5$ x 29",Integer.valueOf(29),Integer.valueOf(deductedDeposit.get(5)));
    }

}