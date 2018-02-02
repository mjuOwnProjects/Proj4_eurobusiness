package mjuApps.service.banking;

import mjuApps.model.banking.Bank;
import mjuApps.model.player.Player;

import java.util.Map;

public class BankService {

    public Bank deductBankDepositByPlayer(Bank bankGiven, Player playerGiven) {
        Bank bank = bankGiven;
        bank.deductBankDeposit(playerGiven.getPlayerDeposit());
        return bank;
    }

}
