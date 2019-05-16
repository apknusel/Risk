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
        Country Congo = cc.getCountry("Congo");
        Troop firstTroop = new Troop("Artillery", Alaska);
        Troop secondTroop = new Troop("Artillery", Alaska);
        arthursArmy.addTroopToArmy(firstTroop);
        arthursArmy.addTroopToArmy(secondTroop);
        Country Alberta = cc.getCountry("Alberta");
        Troop thirdTroop = new Troop("Artillery", Alberta);
        alexsArmy.addTroopToArmy(thirdTroop);
        arthursArmy.battleOfTroops(arthur, alex, Alaska, Alberta);
    }

}
