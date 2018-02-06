package mjuApps.service.gameBoard;

import mjuApps.model.gameBoard.BoardFieldCity;
import mjuApps.model.gameBoard.fieldEnums.City;
import mjuApps.model.gameBoard.fieldEnums.Colour;
import mjuApps.model.gameBoard.fieldEnums.Country;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardFieldCityServiceTest {

    BoardFieldCity boardFieldCity;
    BoardFieldCityService boardFieldCityService;

    @Before
    public void setUp() throws Exception {
        boardFieldCity = new BoardFieldCity(Country.ANGLIA, City.GLASGOW, Colour.ORANGE);
    }

    @Test
    public void sellFieldToPlayer() {
    }

    @Test
    public void buildHouse() {
    }

    @Test
    public void buildHotel() {
    }
}