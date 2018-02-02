package mjuApps.service.banking;

import mjuApps.model.banking.Bank;
import mjuApps.model.player.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class BankServiceTest {

    Bank bank;
    BankService bankService;
    Player player;

    @Before
    public void setUp() {
        bank = new Bank();  //Bank: 1000 x 10, 500 x 30, 100 x 40, 50 x 30, 20 x 40, 10 x 50, 5 x 30
        bankService = new BankService();
        player = new Player("Test Player"); //Player: 1000 x 1, 500 x 2, 100 x 6, 50 x 4, 20 x 5, 10 x 8, 5 x 4
    }


    @Test
    public void deductBankDepositByPlayer() {
        bank = bankService.deductBankDepositByPlayer(bank, player);

        Map<Integer,Integer> deductedDeposit = bank.getBankDeposit();

        Assert.assertEquals("1000$ x 9", Integer.valueOf(9),Integer.valueOf(deductedDeposit.get(1000)));
        Assert.assertEquals("500$ x 28",Integer.valueOf(28),Integer.valueOf(deductedDeposit.get(500)));
        Assert.assertEquals("100$ x 34",Integer.valueOf(34),Integer.valueOf(deductedDeposit.get(100)));
        Assert.assertEquals("50$ x 26",Integer.valueOf(26),Integer.valueOf(deductedDeposit.get(50)));
        Assert.assertEquals("20$ x 35",Integer.valueOf(35),Integer.valueOf(deductedDeposit.get(20)));
        Assert.assertEquals("10$ x 42",Integer.valueOf(42),Integer.valueOf(deductedDeposit.get(10)));
        Assert.assertEquals("5$ x 26",Integer.valueOf(26),Integer.valueOf(deductedDeposit.get(5)));
    }
}