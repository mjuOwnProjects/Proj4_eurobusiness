package mjuApps.service.gameBoard;

import mjuApps.model.gameBoard.BoardFieldCity;
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


    public boolean canAcceptHouse(BoardFieldCity boardFieldCity) {
        return boardFieldCity.getHousesQty()<4 && boardFieldCity.getHotelQty()==0;
    }

    public boolean canAcceptHotel(BoardFieldCity boardFieldCity) {
        return boardFieldCity.getHousesQty()==4 && boardFieldCity.getHotelQty()==0;
    }



}
