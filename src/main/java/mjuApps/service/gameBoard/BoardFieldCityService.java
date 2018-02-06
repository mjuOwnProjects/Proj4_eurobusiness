package mjuApps.service.gameBoard;

import mjuApps.model.gameBoard.BoardFieldCity;
import mjuApps.model.gameBoard.buildings.BuildingType;
import mjuApps.model.player.Player;

import java.util.Optional;

public class BoardFieldCityService {

    public Optional<Sellable> sellFieldToPlayer(BoardFieldCity boardFieldCity, Player player) {

        if (boardFieldCity.getOwner().isPresent()) {
            return Optional.empty();
        }

        Optional<Sellable> fieldToBeSoldOptional = Optional.of(boardFieldCity.sellField(player));
        return fieldToBeSoldOptional;
    }

    public Optional<BoardFieldCity> buildHouse(BoardFieldCity boardFieldCity) {

        if (canAcceptHouse(boardFieldCity)) {
            BoardFieldCity fieldCity = (BoardFieldCity) boardFieldCity.build(BuildingType.HOUSE);
            return Optional.of(fieldCity);
        }

        return Optional.empty();
    }

    public Optional<BoardFieldCity> buildHotel(BoardFieldCity boardFieldCity) {
        if (canAcceptHotel(boardFieldCity)) {
            BoardFieldCity fieldCity = (BoardFieldCity) boardFieldCity.build(BuildingType.HOTEL);
            return Optional.of(fieldCity);
        }

        return Optional.empty();
    }

    private boolean canAcceptHouse(BoardFieldCity boardFieldCity) {
        return boardFieldCity.getHousesQty()<4 && boardFieldCity.getHotelQty()==0;
    }

    private boolean canAcceptHotel(BoardFieldCity boardFieldCity) {
        return boardFieldCity.getHousesQty()==4 && boardFieldCity.getHotelQty()==0;
    }



}
