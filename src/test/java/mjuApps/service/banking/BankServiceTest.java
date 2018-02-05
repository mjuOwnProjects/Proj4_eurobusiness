package mjuApps.service.banking;

import mjuApps.model.banking.Bank;
import mjuApps.model.player.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BankServiceTest {

    private Bank bank;
    private BankService bankService;
    private Player player;

    @Before
    public void setUp() {
        bank = new Bank();  //Bank: 1000 x 10, 500 x 30, 100 x 40, 50 x 30, 20 x 40, 10 x 50, 5 x 30
        bankService = new BankService();
        player = new Player("Test Player"); //Player: 1000 x 1, 500 x 2, 100 x 6, 50 x 4, 20 x 5, 10 x 8, 5 x 4
    }

    @Test
    public void deductBankDepositByPlayer() {
        bank = bankService.deductBankDepositByPlayer(bank, player);

        Map<Integer,Integer> deductedDeposit = bank.getDeposit();

        Assert.assertEquals("1000$ x 9", Integer.valueOf(9),Integer.valueOf(deductedDeposit.get(1000)));
        Assert.assertEquals("500$ x 28",Integer.valueOf(28),Integer.valueOf(deductedDeposit.get(500)));
        Assert.assertEquals("100$ x 34",Integer.valueOf(34),Integer.valueOf(deductedDeposit.get(100)));
        Assert.assertEquals("50$ x 26",Integer.valueOf(26),Integer.valueOf(deductedDeposit.get(50)));
        Assert.assertEquals("20$ x 35",Integer.valueOf(35),Integer.valueOf(deductedDeposit.get(20)));
        Assert.assertEquals("10$ x 42",Integer.valueOf(42),Integer.valueOf(deductedDeposit.get(10)));
        Assert.assertEquals("5$ x 26",Integer.valueOf(26),Integer.valueOf(deductedDeposit.get(5)));
    }

    @Test
    public void breakAmountToDepositBankHasEnough() {
        int givenAmount = 5555;
        Map<Integer,Integer> expectedMap = new HashMap<>();
        expectedMap.put(1000,5);
        expectedMap.put(500,1);
        expectedMap.put(100,0);
        expectedMap.put(50,1);
        expectedMap.put(20,0);
        expectedMap.put(10,0);
        expectedMap.put(5,1);

        //when
        Map<Integer, Integer> resultMap = bankService.changeAmountToDeposit(givenAmount,bank).get();

        //then
        Assert.assertEquals("1000$ x 5", expectedMap.get(1000),resultMap.get(1000));
        Assert.assertEquals("500$ x 1", expectedMap.get(500),resultMap.get(500));
        Assert.assertEquals("100$ x 0", expectedMap.get(100),resultMap.get(100));
        Assert.assertEquals("50$ x 1", expectedMap.get(50),resultMap.get(50));
        Assert.assertEquals("20$ x 0", expectedMap.get(20),resultMap.get(20));
        Assert.assertEquals("10$ x 0", expectedMap.get(10),resultMap.get(10));
        Assert.assertEquals("5$ x 1", expectedMap.get(5),resultMap.get(5));
    }

    @Test
    public void breakAmountToDepositMoreThanBankHas() {
        int givenAmount = 9999999;
        //when

        Optional<Map<Integer, Integer>> resultMapOptional = bankService.changeAmountToDeposit(givenAmount,bank);

        //then
        Assert.assertEquals("Amount bigger than bank deposit so no optional empty",Optional.empty(),resultMapOptional);
    }

    @Test
    public void breakAmountToDepositNotAllBanknotes() {
        //given
        int givenAmount = 2585;
        Map<Integer,Integer> expectedMap = new HashMap<>();
        expectedMap.put(1000,0);    //1000 = 0
        expectedMap.put(500,4);     //500 = 4 = 2000%
        expectedMap.put(100,5);     //100 = 5 = 500$
        expectedMap.put(50,0);      //50 = 0
        expectedMap.put(20,3);      //20 = 3 = 60$
        expectedMap.put(10,2);      //10 = 2 = 20$
        expectedMap.put(5,1);       //5 = 1 = 5$

        Map<Integer,Integer> simulatedBankDeposit = new HashMap<>();
        simulatedBankDeposit.put(1000,0);
        simulatedBankDeposit.put(500,4);
        simulatedBankDeposit.put(100,10);
        simulatedBankDeposit.put(50,0);
        simulatedBankDeposit.put(20,3);
        simulatedBankDeposit.put(10,10);
        simulatedBankDeposit.put(5,10);

        bank.setDeposit(simulatedBankDeposit);

        //when
        Map<Integer, Integer> resultMap = bankService.changeAmountToDeposit(givenAmount,bank).get();

        //then
        Assert.assertEquals("1000$ x 5", expectedMap.get(1000),resultMap.get(1000));
        Assert.assertEquals("500$ x 1", expectedMap.get(500),resultMap.get(500));
        Assert.assertEquals("100$ x 0", expectedMap.get(100),resultMap.get(100));
        Assert.assertEquals("50$ x 1", expectedMap.get(50),resultMap.get(50));
        Assert.assertEquals("20$ x 0", expectedMap.get(20),resultMap.get(20));
        Assert.assertEquals("10$ x 0", expectedMap.get(10),resultMap.get(10));
        Assert.assertEquals("5$ x 1", expectedMap.get(5),resultMap.get(5));
    }

}