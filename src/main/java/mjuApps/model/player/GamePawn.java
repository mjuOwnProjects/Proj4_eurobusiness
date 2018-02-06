package mjuApps.model.player;

import mjuApps.model.gameBoard.BoardFieldAbstract;

public class GamePawn {

    private final Player player;
    private final PawnColour colour;
    private BoardFieldAbstract boardPosition;

    public GamePawn(Player player, PawnColour colour, BoardFieldAbstract boardPosition) {
        this.player = player;
        this.colour = colour;
        this.boardPosition = boardPosition;
    }
}
