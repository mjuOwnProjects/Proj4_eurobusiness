package mjuApps.model.gameBoard;

import mjuApps.model.gameBoard.buildings.Building;

import java.util.List;

public class Board {

    private final List<BoardFieldAbstract> fields;
    private List<Building> houses;
    private List<Building> hotels;

    public Board(List<BoardFieldAbstract> fields, List<Building> houses, List<Building> hotels) {
        this.fields = fields;
        this.houses = houses;
        this.hotels = hotels;
    }
}
