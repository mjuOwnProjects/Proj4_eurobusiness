package mjuApps.model.gameBoard;

import mjuApps.model.player.Player;

import java.util.Optional;

public class BoardField {

    private final BoardFIeldType fieldType;
    private final int fieldNumber;
    private Optional<Player> owner;

    public BoardField(BoardFIeldType fIeldType, int fieldNumber) {
        this.fieldType = fIeldType;
        this.fieldNumber = fieldNumber;
        owner = Optional.empty();
    }
}
