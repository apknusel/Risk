import java.util.ArrayList;

public class Player
{
    Army army;
    boolean winner;
    boolean turn;
    Hand cards = new Hand();
    boolean getsCard;
    public Player(Army playersArmy)
    {
        army = playersArmy;
        winner = false;
        turn = false;
        getsCard = false;
    }
    
    public Army getArmy()
    {
        return army;
    }
    
    public void addCard(Card card)
    {
        cards.add(card);
    }
    
    public Hand getHand()
    {
        return cards;
    }
    
    public void updateWinner(Player p)
    {
        if (p.getArmy().sizeOfArmy() == 0)
            winner = true;
    }
    
    public boolean isWinner()
    {
        return winner;
    }
    
    public boolean getsBonusCard()
    {
        return getsCard;
    }
    
    public void resetBonusCard()
    {
        getsCard = false;
    }
    
    public void bonusCard()
    {
        getsCard = true;
    }
    
    public boolean getTurn()
    {
        return turn;
    }
    
    public int numTroopsToReceive(Continent[] continents)
    {
        int troopsToReceive = 3;
        ArrayList<Country> controlled = new ArrayList<Country>();
        
        for (int i = 0; i < continents.length; i++)
        {
            if (continents[i].anOwner() != null && this.getArmy().getOwner().equals(continents[i].anOwner().getArmy().getOwner()))
                troopsToReceive += continents[i].getBonusArmies();
        }
        
        for (int i = 0; i < this.getArmy().troops.size(); i++)
        {
            boolean alreadyThere = false;
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
        
        for (int i = 0; i < continents.length; i++)
        {
            if (continents[i].anOwner() != null && this.getArmy().getOwner().equals(continents[i].anOwner().getArmy().getOwner()))
                troopsToReceive += continents[i].getBonusArmies();
        }
        
        for (int i = 0; i < this.getArmy().troops.size(); i++)
        {
            boolean alreadyThere = false;
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
        
        troopsToReceive += cards.awardTroops(cardsToTurnIn);
        
        return troopsToReceive;
    }

    public void wherePutNewTroops(Country[] wherePutting, int troopsToReceive)
    {
        for (int i = 0; i < troopsToReceive; i++)
        {
            Country countryWanted = wherePutting[i];
            Troop newTroop = new Troop(countryWanted);
            this.getArmy().addTroopToArmy(newTroop);
        }
    }
}
