package mjuApps.model.gameBoard;

import java.util.List;

public class Board {

    private final List<BoardFieldAbstract> fields;

    public Board(List<BoardFieldAbstract> fields) {
        this.fields = fields;
    }
}
