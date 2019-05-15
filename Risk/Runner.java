public class Runner 
{
    public Runner()
    {
    }
    
    
    public static void main(String[] args)
    {
        Army arthursArmy = new Army("Arthur");
        Army alexsArmy = new Army("Alex");
        Player arthur = new Player(arthursArmy);
        Player alex = new Player(alexsArmy);
        CountriesContinents cc = new CountriesContinents();
        cc.setAdjacentCountries();
        Country Alaska = cc.getCountry("Alaska");
        //Alaska.getAdjacentCountries();
        Troop firstTroop = new Troop("Artillery", Alaska);
        arthursArmy.addTroopToArmy(firstTroop);
        Country Alberta = cc.getCountry("Alberta");
        Troop secondTroop = new Troop("Artillery", Alberta);
        alexsArmy.addTroopToArmy(secondTroop);
        //arthursArmy.battleOfTroops(arthur, alex, Alaska, Alberta);
    }

}
