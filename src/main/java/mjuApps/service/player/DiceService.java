package mjuApps.service.player;

import mjuApps.model.player.Dice;

import java.util.Optional;

public class DiceService {

    private Dice dice;
    private int[] firstThrow;
    private int[] secondThrow;

    public DiceService(Dice dice) {
        this.dice = dice;
    }

    public void performThrows(Dice dice) {
        this.firstThrow = throwDiceTwice(dice);
        this.secondThrow = throwDiceTwice(dice);
    }

    public Optional<Integer> validateThrowsAndGetResult(int[] firstThrow, int[] secondThrow) {
        Optional<Integer> possibleThrowResult = Optional.empty();

        if (checkIfDoublet(firstThrow)) {
            if (checkIfDoublet(secondThrow)) {
                return Optional.empty();
            }
            return Optional.of(returnThrowValue(firstThrow) + returnThrowValue(secondThrow));
        }

        return Optional.of(returnThrowValue(firstThrow));
    }

    private int[] throwDiceTwice(Dice dice) {
        int[] throwResult = {dice.throwDice(),dice.throwDice()};
        return throwResult;
    }

    private boolean checkIfDoublet(int[] throwResult) {
        return throwResult[0]==throwResult[1];
    }

    private int returnThrowValue(int[] throwResult) {
        return throwResult[0]+throwResult[1];
    }

    public int[] getFirstThrow() {
        return firstThrow;
    }

    public int[] getSecondThrow() {
        return secondThrow;
    }
}
