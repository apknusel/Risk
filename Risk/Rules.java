public class Rules
{
    boolean gameOver = false;
    Player currentPlayer;
    Player nonCurrentPlayer;
    Player tempPlayer;
    public Rules()
    {
    }
    
    
    
    public static void main(String[] args)
    {
        CountriesContinents cc = new CountriesContinents();
        cc.setAdjacentCountries();
        cc.setCountries();
        Continent[] continents = cc.continents;
        Deck deck = new Deck(cc.countries);
        Army arthursArmy = new Army("Arthur");
        Army alexsArmy = new Army("Alex");
        Player arthur = new Player(arthursArmy);
        Player alex = new Player(alexsArmy);
        deck.startOfGame(arthur, alex);
        System.out.println(cc.getCountry("Northern Europe").getOccupant().getArmy().getOwner());
        arthursArmy.battleOfTroops(arthur, alex, cc.getCountry("Northern Europe"), cc.getCountry("Scandinavia"));
//         for (int i = 0; i < arthursArmy.troops.size(); i++)
//         {
//             System.out.println(arthursArmy.troops.get(i).getWhereLocated().getName());
//         }
//         //arthursArmy.moveTroops(cc.getCountry("Egypt"), cc.getCountry("Peru"), 1);
//         Country[] countries = {cc.getCountry("Alaska"), cc.getCountry("Alaska"), cc.getCountry("Alaska")};
//         arthur.wherePutNewTroops(countries, 3);
//         for (int i = 0; i < arthursArmy.troops.size(); i++)
//         {
//             System.out.println(arthursArmy.troops.get(i).getWhereLocated().getName());
//         }
        
        //while (gameOver != false)
        //{
        //   tempPlayer = currentTroop 
        //}
    }

    //     Army army1 = new Army("Arthur");
    //     Army army2 = new Army("Alex");
    //     Player player1 = new Player(army1);
    //     Player player2 = new Player(army2);
    //     CountriesContinents cc = new CountriesContinents();
    //     cc.setAdjacentCountries();
    //     Country Alaska = cc.getCountry("Alaska");
    //     Country Congo = cc.getCountry("Congo");
    //     Troop firstTroop = new Troop("Artillery", Alaska);
    //     Troop secondTroop = new Troop("Artillery", Alaska);
    //     Troop thirdTroop = new Troop("Artillery", Alaska);
    //     Troop fourthTroop = new Troop("Artillery", Alaska);
    //     arthursArmy.addTroopToArmy(firstTroop);
    //     arthursArmy.addTroopToArmy(secondTroop);
    //     arthursArmy.addTroopToArmy(thirdTroop);
    //     arthursArmy.addTroopToArmy(fourthTroop);
    //     Country Alberta = cc.getCountry("Alberta");
    //     Troop fifthTroop = new Troop("Artillery", Alberta);
    //     alexsArmy.addTroopToArmy(fifthTroop);
    //     System.out.println(arthursArmy.sizeOfArmy());
    //     System.out.println(alexsArmy.sizeOfArmy());
    //     arthursArmy.battleOfTroops(arthur, alex, Alaska, Alberta);
    //     System.out.println(arthursArmy.sizeOfArmy());
    //     System.out.println(alexsArmy.sizeOfArmy());
    
}
