package mjuApps.model.gameBoard;

import mjuApps.model.gameBoard.buildings.BuildingType;
import mjuApps.model.gameBoard.fieldEnums.FieldType;
import mjuApps.model.gameBoard.fieldEnums.City;
import mjuApps.model.gameBoard.fieldEnums.Colour;
import mjuApps.model.gameBoard.fieldEnums.Country;
import mjuApps.model.player.Player;
import mjuApps.service.gameBoard.Buildable;
import mjuApps.service.gameBoard.Sellable;

import java.util.Optional;


public class BoardFieldCity extends BoardFieldAbstract implements Buildable, Sellable{

    private Country country;
    private City city;
    private int fieldPrice;
    private int buildingPrice;
    private Colour colour;
    private int housesQty;
    private int hotelQty;
    private Optional<Player> owner;

    public BoardFieldCity(Country country, City city, Colour colour) {
        super(FieldType.CITY);
        this.country = country;
        this.city = city;
        this.fieldPrice = city.getFieldPrice();
        this.buildingPrice = country.getBuildingPrice();
        this.colour = colour;
        this.owner = Optional.empty();
    }

    @Override
    public Buildable build(BuildingType buildingType) {
        switch (buildingType) {
            case HOUSE: {
                ++this.housesQty;
            }
            case HOTEL: {
                ++this.hotelQty;
            }

        }
        return this;
    }

    @Override
    public Sellable sellField(Player player) {
        this.owner = Optional.of(player);
        return this;
    }

    public int getHousesQty() {
        return housesQty;
    }

    public int getHotelQty() {
        return hotelQty;
    }


    public int getFieldPrice() {
        return fieldPrice;
    }

    public Optional<Player> getOwner() {
        return owner;
    }
}
