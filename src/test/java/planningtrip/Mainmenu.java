package planningtrip;

public enum Mainmenu {
    BuyTickets("https://tickets.southwesternrailway.com/sw/en/journeyplanning/mixingdeck");

    private final String url;
    Mainmenu(String url) {
        this.url = url;
    }

    public  String getUrl(){
        return url;
    }
}
