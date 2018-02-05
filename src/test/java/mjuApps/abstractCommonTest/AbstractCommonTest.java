package mjuApps.abstractCommonTest;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCommonTest {

    protected Map<Integer,Integer> createTestDeposit() {
        Map<Integer, Integer> testDeposit = new HashMap<>();

        testDeposit.put(1000,1);
        testDeposit.put(500,1);
        testDeposit.put(100,1);
        testDeposit.put(50,1);
        testDeposit.put(20,1);
        testDeposit.put(10,1);
        testDeposit.put(5,1);

        return testDeposit;
    }

}
