package mjuApps.service.gameBoard;

import mjuApps.model.gameBoard.BoardFieldCity;
import mjuApps.model.gameBoard.fieldEnums.City;
import mjuApps.model.gameBoard.fieldEnums.Colour;
import mjuApps.model.gameBoard.fieldEnums.Country;
import mjuApps.model.player.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class BoardFieldCityServiceTest {

    BoardFieldCity boardFieldCity;
    BoardFieldCityService boardFieldCityService;
    Player player;

    @Before
    public void setUp() throws Exception {
        player = new Player("Test Player");
        boardFieldCity = new BoardFieldCity(Country.ANGLIA, City.GLASGOW, Colour.ORANGE);
        boardFieldCityService = new BoardFieldCityService();
    }

    @Test
    public void sellFieldToPlayerTest() {
        Optional<Sellable> checkedField = boardFieldCityService.sellFieldToPlayer(boardFieldCity, player);
        Assert.assertTrue("This field has been sold", checkedField.isPresent());
        Assert.assertEquals("Owner in BoardFiledCity has been set to Player", Optional.of(player), boardFieldCity.getOwner());

        checkedField = boardFieldCityService.sellFieldToPlayer(boardFieldCity, player);
        Assert.assertEquals("Field can't be sold twice, so it is expected to empty optional", Optional.empty(), checkedField);

    }

    @Test
    public void buildHouse() {
    }

    @Test
    public void buildHotel() {
    }


}