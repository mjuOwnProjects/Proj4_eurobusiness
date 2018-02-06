package mjuApps.model.gameBoard;

import mjuApps.model.gameBoard.fieldEnums.City;

public class Property {
    private final String name;
    private final City city;

    public Property(String name, City city) {
        this.name = name;
        this.city = city;
    }
}
