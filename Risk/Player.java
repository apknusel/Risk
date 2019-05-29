import java.util.ArrayList;

public class Player
{
    Army army;
    boolean winner;
    Hand cards = new Hand();
    boolean getsCard;
    
    public Player(Army playersArmy)
    {
        //Sets all of the variables
        army = playersArmy;
        winner = false;
        getsCard = false;
    }
    
    public Army getArmy()
    {
        //Returns the players army
        return army;
    }
    
    public void addCard(Card card)
    {
        //Adds a card to the players hand
        cards.add(card);
    }
    
    public Hand getHand()
    {
        //Returns the players hand
        return cards;
    }
    
    public void updateWinner(Player p)
    {
        //Checks to see if the opposition has no troops and if they have won
        if (p.getArmy().troops.size() == 0)
            winner = true;
    }
    
    public boolean isWinner()
    {
        //Returns whether or not they have won
        return winner;
    }
    
    public boolean getsBonusCard()
    {
        //Checks to see if they get a card for conquering a country
        return getsCard;
    }
    
    public void resetBonusCard()
    {
        //Resets whether or not they get a bonus card
        getsCard = false;
    }
    
    public void bonusCard()
    {
        //Sets bonus card to true
        getsCard = true;
    }
    
    public int numTroopsToReceive(Continent[] continents)
    {
        int troopsToReceive = 3;
        ArrayList<Country> controlled = new ArrayList<Country>();
        
        //Checks to see if they own any continents and then gives them bonus troops if they do
        for (int i = 0; i < continents.length; i++)
        {
            if (continents[i].anOwner() != null && this.getArmy().getOwner().equals(continents[i].anOwner().getArmy().getOwner()))
                troopsToReceive += continents[i].getBonusArmies();
        }
        
        for (int i = 0; i < this.getArmy().troops.size(); i++)
        {
            boolean alreadyThere = false;
            
            //Puts all of the countries the player controls into an arrayList
            for (int j = 0; j < controlled.size(); j++)
            {
                if (controlled.get(j).getName().equals(this.getArmy().troops.get(i).getWhereLocated().getName()))
                {
                    alreadyThere = true;
                }
            }
            
            if (!alreadyThere)
                controlled.add(this.getArmy().troops.get(i).getWhereLocated());
        }
        
        int size = controlled.size();
        
        //Gives a player extra troops depending on how many troops they have
        if (size >= 12 && size <= 14)
            troopsToReceive += 1;
        else if (size <= 17)
            troopsToReceive += 2;
        else if (size <= 20)
            troopsToReceive += 3;
        else if (size <= 23)
            troopsToReceive += 4;
        else if (size <= 26)
            troopsToReceive += 5;
        else if (size <= 29)
            troopsToReceive += 6;
        else if (size <= 32)
            troopsToReceive += 7;
        else if (size <= 35)
            troopsToReceive += 8;
        else if (size <= 39)
            troopsToReceive += 9;
        else if (size <= 42)
            troopsToReceive += 10;

        return troopsToReceive;
    }
    
    
    public int numTroopsToReceive(Continent[] continents, ArrayList<Card> cardsToTurnIn)
    {
        int troopsToReceive = 3;
        ArrayList<Country> controlled = new ArrayList<Country>();
        
        //Checks to see if they own any continents and then gives them bonus troops if they do
        for (int i = 0; i < continents.length; i++)
        {
            if (continents[i].anOwner() != null && this.getArmy().getOwner().equals(continents[i].anOwner().getArmy().getOwner()))
                troopsToReceive += continents[i].getBonusArmies();
        }
        
        for (int i = 0; i < this.getArmy().troops.size(); i++)
        {
            boolean alreadyThere = false;
            
            //Puts all of the countries the player controls into an arrayList
            for (int j = 0; j < controlled.size(); j++)
            {
                if (controlled.get(j).getName().equals(this.getArmy().troops.get(i).getWhereLocated().getName()))
                {
                    alreadyThere = true;
                }
            }
            
            if (!alreadyThere)
                controlled.add(this.getArmy().troops.get(i).getWhereLocated());
        }
        
        int size = controlled.size();
        
        //Gives a player extra troops depending on how many troops they have
        if (size >= 12 && size <= 14)
            troopsToReceive += 1;
        else if (size <= 17)
            troopsToReceive += 2;
        else if (size <= 20)
            troopsToReceive += 3;
        else if (size <= 23)
            troopsToReceive += 4;
        else if (size <= 26)
            troopsToReceive += 5;
        else if (size <= 29)
            troopsToReceive += 6;
        else if (size <= 32)
            troopsToReceive += 7;
        else if (size <= 35)
            troopsToReceive += 8;
        else if (size <= 39)
            troopsToReceive += 9;
        else if (size <= 42)
            troopsToReceive += 10;
        
        //Gives the players troops when they turn in cards
        troopsToReceive += cards.awardTroops(cardsToTurnIn);
        
        return troopsToReceive;
    }

    public void wherePutNewTroops(Country[] wherePutting, int troopsToReceive)
    {
        //Puts a new troop where it should go
        for (int i = 0; i < troopsToReceive; i++)
        {
            Country countryWanted = wherePutting[i];
            Troop newTroop = new Troop(countryWanted);
            this.getArmy().addTroopToArmy(newTroop);
        }
    }
}
