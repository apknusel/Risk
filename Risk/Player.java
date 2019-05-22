public class Player
{
    Army army;
    boolean winner;
    boolean turn;
    Hand cards;
    public Player(Army playersArmy, String n)
    {
        army = playersArmy;
        winner = false;
        turn = false;
    }
    public Army getArmy()
    {
        return army;
    }
    public void updateWinner(Player p)
    {
        if (army.sizeOfArmy() == 0 && p.getArmy().sizeOfArmy() == 0)
        {
            winner = false;;
        }
        else if (p.getArmy().sizeOfArmy() == 0)
        {
            winner = true;
        }
    }
    public boolean isWinner()
    {
        return winner;
    }
    public void switchTurn()
    {
        turn = !turn;
    }
    public boolean getTurn()
    {
        return turn;
    }
    public int numTroopsToReceive(Continent[] continents)
    {
        int troopsToReceive = 3;
        for (int i = 0; i < continents.length; i++)
        {
            if (this.getArmy().getOwner().equals(continents[i].anOwner().getArmy().getOwner()))
            {
                troopsToReceive += continents[i].getBonusArmies();
            }
        }
        
        return troopsToReceive;
    }

    public void wherePutNewTroops(Country[] wherePutting, int troopsToReceive)
    {
        for (int i = 0; i < troopsToReceive; i++)
        {
            Country countryWanted = wherePutting[i];
            Troop newTroop = new Troop("Artillery", countryWanted);
            this.getArmy().addTroopToArmy(newTroop);
        }
    }
}
