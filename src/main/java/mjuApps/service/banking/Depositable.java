package mjuApps.service.banking;

import java.util.Map;

public interface Depositable {


    Map<Integer, Integer> addToDeposit(Map<Integer, Integer> givenDeposit);

    Map<Integer, Integer> deductDeposit(Map<Integer, Integer> depositToBeTaken);

}
