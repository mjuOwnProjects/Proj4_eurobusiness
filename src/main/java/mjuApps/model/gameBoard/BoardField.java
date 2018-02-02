package mjuApps.model.gameBoard;

import mjuApps.model.player.Player;

public class BoardField {

    private final BoardFieldType fieldType;
    private final int fieldNumber;
    private Player owner;

    public BoardField(BoardFieldType fieldType, int fieldNumber) {
        this.fieldType = fieldType;
        this.fieldNumber = fieldNumber;
    }
}
