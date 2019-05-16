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
            if (attackingCountryNeighbours[i].getName() == defending.getName())
                isNeighbour = true;
        }
        
        for (int i = 0; i < attackingArmy.troops.size(); i++)
        {
            Troop currentTroop = attackingArmy.troops.get(i);
            if (currentTroop.getWhereLocated().getName().equals(attacking.getName()))
                attackers.add(currentTroop);
        }
        
        if (isNeighbour == true && attackers.size() != 0)
        {
            for (int i = 0; i < defendingArmy.troops.size(); i++)
            {
                Troop currentTroop = defendingArmy.troops.get(i);
                if (currentTroop.getWhereLocated().getName() == defending.getName())
                    defenders.add(currentTroop);
            }
            
            if (defenders.size() >= 2)
                defenderDice = 2;
            else
                defenderDice = 1;
                
            if (attackers.size() >= 4)
                attackerDice = 3;
            else
                attackerDice = attackers.size() - 1;
                
            //works up to here
                
            Dice dice = new Dice();
            ArrayList<Integer> defenderNumbers = dice.roll(defenderDice);
            ArrayList<Integer> attackerNumbers = dice.roll(attackerDice);
            
            if (defenderDice > attackerDice)
                defenderNumbers.remove(0);
            else if (attackerDice - defenderDice == 2)
            {
                attackerNumbers.remove(0);
                attackerNumbers.remove(0);
            }
            else if (attackerDice - defenderDice == 1)
                attackerNumbers.remove(0);
            
            if (attackerNumbers.get(0) > defenderNumbers.get(0))
            {
                boolean found = false;
                for (int i = 0; i < defendingArmy.troops.size() || found; i++)
                {
                    if (defendingArmy.troops.get(i).getWhereLocated() == defending)
                    {
                        defendingArmy.troops.remove(i);
                        found = true;
                    }
                }
            }
            
            if (attackerNumbers.get(0) < defenderNumbers.get(0))
            {
                boolean found = false;
                for (int i = 0; i < attackingArmy.troops.size() || found; i++)
                {
                    if (attackingArmy.troops.get(i).getWhereLocated() == attacking)
                    {
                        attackingArmy.troops.remove(i);
                        found = true;
                    }
                }
            }
            
            if (attackerNumbers.size() == 2)
            {
                if (attackerNumbers.get(1) > defenderNumbers.get(1))
                {
                    boolean found = false;
                    for (int i = 0; i < defendingArmy.troops.size() || found; i++)
                    {
                        if (defendingArmy.troops.get(i).getWhereLocated() == defending)
                        {
                            defendingArmy.troops.remove(i);
                            found = true;
                        }
                    }
                }
                
                if (attackerNumbers.get(1) < defenderNumbers.get(1))
                {
                    boolean found = false;
                    for (int i = 0; i < attackingArmy.troops.size() || found; i++)
                    {
                        if (attackingArmy.troops.get(i).getWhereLocated() == attacking)
                        {
                            attackingArmy.troops.remove(i);
                            found = true;
                        }
                    }
                }
            }
        }
    }
}
