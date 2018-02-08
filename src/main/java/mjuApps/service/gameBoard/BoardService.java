package mjuApps.service.gameBoard;

import mjuApps.model.gameBoard.buildings.Building;
import mjuApps.model.gameBoard.buildings.BuildingType;

import java.util.ArrayList;
import java.util.List;

public class BoardService {

    public List<Building> initiateBuildingsList(BuildingType buildingType) {
        List<Building> buildings = new ArrayList<>();
        for (int i=0;i<buildingType.getNumberOfBuildings();i++) {
            buildings.add(new Building(buildingType));
        }
        return buildings;
    }

    public List<Building> removeBuildingFromList(List<Building> buildings) {
        List<Building> buildingResultList = buildings;
        buildingResultList.remove(0);
        return buildingResultList;
    }

}
