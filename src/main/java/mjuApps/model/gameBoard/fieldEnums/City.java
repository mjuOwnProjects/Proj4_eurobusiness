package mjuApps.model.gameBoard.fieldEnums;

public enum City {
    AMSTERDAM (480),
    ATENY (120),
    BRUKSELA (440),
    BARCELONA (280),
    BONN (640),
    INNSBRUCK (700),
    KOLONIA (600),
    LIVERPOOL (360),
    FRANKFURT (600),
    GOETEORG (520),
    GLASGOW (360),
    LONDYN (400),
    MADRYT (320),
    MALMO (520),
    MEDIOLAN (200),
    NEAPOL (200),
    ROTTERDAM (440),
    RZYM (240),
    SALONIKI (120),
    SEWILLA (280),
    SZTOKHOLM (560),
    WIEDEŃ (800);

    private int fieldPrice;

    City(int fieldPrice) {
        this.fieldPrice = fieldPrice;
    }

    public int getFieldPrice() {
        return this.fieldPrice;
    }
}
