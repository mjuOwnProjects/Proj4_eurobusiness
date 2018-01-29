package mjuApps.model.player;

import mjuApps.model.gameBoard.BoardField;

public class GamePawn {

    private final Player player;
    private final PawnColour colour;
    private BoardField boardPosition;

    public GamePawn(Player player, PawnColour colour, BoardField boardPosition) {
        this.player = player;
        this.colour = colour;
        this.boardPosition = boardPosition;
    }
}
