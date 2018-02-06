package mjuApps.service.gameBoard;

import mjuApps.model.gameBoard.buildings.BuildingType;

public interface Buildable {

    Buildable build(BuildingType buildingType);

}
