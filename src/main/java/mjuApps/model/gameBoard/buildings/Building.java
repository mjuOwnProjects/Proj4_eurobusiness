package mjuApps.model.gameBoard.buildings;

public class Building {

    private final BuildingType buildingType;
    private double price;

    public Building(BuildingType buildingType, double price) {
        this.buildingType = buildingType;
        this.price = price;
    }
}
