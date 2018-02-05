package mjuApps.service.banking;

import java.util.Map;
import java.util.Optional;

public interface Changeable {

    Optional<Map<Integer, Integer>> changeAmountToDeposit(int amount, Depositable changeableObject);

}
