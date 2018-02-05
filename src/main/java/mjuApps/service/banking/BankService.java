package mjuApps.service.banking;

import mjuApps.model.banking.Bank;
import mjuApps.model.player.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class BankService implements Changeable {

    public Bank deductBankDepositByPlayer(Bank bankGiven, Player playerGiven) {
        Bank bank = bankGiven;
        bank.deductDeposit(playerGiven.getDeposit());
        return bank;
    }


    @Override
    public Optional<Map<Integer, Integer>> changeAmountToDeposit(int amount, Depositable objectWithDeposit) {
        Map<Integer, Integer> deposit = new HashMap<>();
        Bank bank = (Bank) objectWithDeposit;
        Map<Integer, Integer> bankDeposit = new TreeMap<>(bank.getDeposit()).descendingMap();

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
