package mjuApps.model.gameBoard.buildings;

public enum BuildingType {
    HOUSE (32),
    HOTEL (12);

    private int numberOfBuildings;

    BuildingType(int numberOfBuildings) {
        this.numberOfBuildings = numberOfBuildings;
    }

    public int getNumberOfBuildings() {
        return numberOfBuildings;
    }
}
