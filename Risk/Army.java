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
    
    public String getOwner()
    {
        return owner;
    }
    
    public String getDisplay()
    {
        String string = "";
        ArrayList <Country> alreadyFound = new ArrayList<Country>();
        
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
                if (countryName.length() <= 13)
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
