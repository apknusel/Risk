import java.util.*;

public class Army
{
    String owner;
    ArrayList<Troop> troops = new ArrayList<> ();
    
    public Army(String player)
    {
        owner = player;
    }

    public void addTroopToArmy(Troop newTroop)
    {
        troops.add(newTroop);
    }
    
    public void troopDied(Troop deadTroop)
    {
        troops.remove(deadTroop);
    }
    
    public int sizeOfArmy()
    {
        return this.troops.size();
    }
    
    public void battleOfTroops(Player attacker, Player defender, Country attacking, Country defending)
    {
        Country[] attackingCountryNeighbours = attacking.getAdjacentCountries();
        ArrayList<Troop> attackers = new ArrayList<> ();
        ArrayList<Troop> defenders = new ArrayList<> ();
        boolean isNeighbour = false;
        Army defendingArmy = defender.getArmy();
        Army attackingArmy = attacker.getArmy();
        int defenderDice;
        int attackerDice;
        int[] attackingNumbers = new int[2];
        int[] defendingNumbers = new int[2];
        
        for (int i = 0; i < attackingCountryNeighbours.length; i++)
        {
            if (attackingCountryNeighbours[i] == defending)
                isNeighbour = true;
        }
        
        if (isNeighbour == true)
        {
            for (int i = 0; i < defendingArmy.troops.size(); i++)
            {
                Troop currentTroop = defendingArmy.troops.get(i);
                if (currentTroop.getWhereLocated() == defending)
                    defenders.add(currentTroop);
            }
            
            for (int i = 0; i < attackingArmy.troops.size(); i++)
            {
                Troop currentTroop = attackingArmy.troops.get(i);
                if (currentTroop.getWhereLocated() == attacking)
                    attackers.add(currentTroop);
            }
            
            if (defenders.size() >= 3)
                defenderDice = 2;
            else
                defenderDice = defenders.size();
                
            if (attackers.size() >= 4)
                attackerDice = 2;
            else
                attackerDice = attackers.size();
                
            Dice dice = new Dice();
            
        }
    }
}
