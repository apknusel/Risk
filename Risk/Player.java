public class Player
{
    Army army;
    boolean winner;
    boolean turn;
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
}
