package mjuApps.service.banking;

import mjuApps.model.banking.Bank;
import mjuApps.model.player.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class BankService {

    public Bank deductBankDepositByPlayer(Bank bankGiven, Player playerGiven) {
        Bank bank = bankGiven;
        bank.deductBankDeposit(playerGiven.getPlayerDeposit());
        return bank;
    }

    public Optional<Map<Integer, Integer>> changeAmountToDeposit(int amount, Bank bank) {

        Map<Integer, Integer> deposit = new HashMap<>();
        Map<Integer, Integer> bankDeposit = new TreeMap<>(bank.getBankDeposit()).descendingMap();

        int amountToChange = amount;

        for (Map.Entry<Integer, Integer> entry : bankDeposit.entrySet()) {
            int bankNotesQty = amountToChange / entry.getKey();

            if (bankNotesQty>entry.getValue()) {
                bankNotesQty=entry.getValue();
            }

            amountToChange = amountToChange - bankNotesQty*entry.getKey();
            deposit.put(entry.getKey(),bankNotesQty);
        }

        if (amountToChange==0) {
            return Optional.of(deposit);
        }

        return Optional.empty();
    }

}
