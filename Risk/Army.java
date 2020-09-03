import java.util.*;
import javax.swing.*;

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
        //Adds a troop to the army
        troops.add(newTroop);
    }
    
    public void troopDied(Troop deadTroop)
    {
        //Kills a troop
        deadTroop.getWhereLocated().removeTroops(1);
        troops.remove(deadTroop);
    }
    
    public String getOwner()
    {
        //Returns the player who owns the army
        return owner;
    }
    
    public String getDisplay()
    {
        String string = "";
        ArrayList <Country> alreadyFound = new ArrayList<Country>();
        
        //Returns a formatted version of the country's info
        for (int i = 0; i < troops.size(); i++)
        {
            boolean found = false;
            
            for (int j = 0; j < alreadyFound.size(); j++)
            {
                if (alreadyFound.get(j).getName() == troops.get(i).getWhereLocated().getName())
                    found = true;
            }
            
            if (found == false)
            {
                Country country = troops.get(i).getWhereLocated();
                int num = country.getTroops();
                String countryName = country.getName();
                String continent = country.getContinent();
                if (countryName.equals("Central Africa") || countryName.equals("Southeast Asia"))
                    string += country.getName() + "\t\t";
                else if (countryName.length() <= 13)
                    string += country.getName() + "\t\t";
                else
                    string += country.getName() + "\t";
                string += num + "\t";
                string += continent + "\n";
                alreadyFound.add(country);
            }
        }
        
        return string;
    }
    
    public void moveTroops(Country original, Country toGo, int amounts)
    {
        //Moves troops from one country to another
        for (int i = 0; i < troops.size(); i++)
        {
            if (troops.get(i).getWhereLocated().getName() == original.getName() && amounts > 0)
            {
                troops.get(i).setWhereLocated(toGo);
                amounts--;
            }
        }
    }
}
