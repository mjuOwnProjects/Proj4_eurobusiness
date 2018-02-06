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

    public Optional<Buildable> buildHouse(BoardFieldCity boardFieldCity) {

        return Optional.empty();
    }

    public boolean canBuildHouse(BoardFieldCity boardFieldCity) {

        return false;
    }



}
