package mjuApps.service.gameBoard.buildings;

import mjuApps.model.gameBoard.BoardFieldCity;
import mjuApps.model.gameBoard.buildings.BuildingType;
import mjuApps.service.gameBoard.BoardFieldCityService;

import java.util.Optional;

public class BuildingService {

    public Optional<BoardFieldCity> buildHouse(BoardFieldCity boardFieldCity, BoardFieldCityService boardFieldCityService) {

        if (boardFieldCityService.canAcceptHouse(boardFieldCity)) {
            BoardFieldCity fieldCity = (BoardFieldCity) boardFieldCity.build(BuildingType.HOUSE);
            return Optional.of(fieldCity);
        }

        return Optional.empty();
    }

    public Optional<BoardFieldCity> buildHotel(BoardFieldCity boardFieldCity, BoardFieldCityService boardFieldCityService) {
        if (boardFieldCityService.canAcceptHotel(boardFieldCity)) {
            BoardFieldCity fieldCity = (BoardFieldCity) boardFieldCity.build(BuildingType.HOTEL);
            return Optional.of(fieldCity);
        }

        return Optional.empty();
    }

}
