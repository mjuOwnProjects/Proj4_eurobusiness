package mjuApps.model.gameBoard.fieldEnums;

public enum Country {

    ANGLIA (200),
    AUSTRIA (400),
    BENELUX (300),
    GRECJA (100),
    HISZPANIA (200),
    RFN (400),
    SZWECJA (300),
    WŁOCHY (100);

    private int buildingPrice;

    Country(int buildingPrice) {
        this.buildingPrice = buildingPrice;
    }

    public int getBuildingPrice() {
        return buildingPrice;
    }
}
