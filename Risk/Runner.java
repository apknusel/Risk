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
        arthursArmy.addTroopToArmy(firstTroop);
        Country Alberta = cc.getCountry("Alberta");
        Troop secondTroop = new Troop("Artillery", Alberta);
        alexsArmy.addTroopToArmy(secondTroop);
        arthursArmy.battleOfTroops(arthur, alex, Alaska, Alberta);
        System.out.println(arthursArmy.sizeOfArmy());
        System.out.println(alexsArmy.sizeOfArmy());
    }

}
