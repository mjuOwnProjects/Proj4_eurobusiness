package mjuApps.model.gameBoard;

import mjuApps.model.gameBoard.fieldEnums.FieldType;
import mjuApps.model.player.Player;

import java.util.Optional;

public abstract class BoardFieldAbstract {

    protected FieldType fieldType;

    public BoardFieldAbstract(FieldType fieldType) {
        this.fieldType = fieldType;
    }
}
