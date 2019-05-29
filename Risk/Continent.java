import java.util.ArrayList;
public class Continent
{
    private String name;
    private int bonusArmies;
    private Country[] countries;
    
    public Continent(String nameOfContinent, int bArmies, Country[] memberCountries)
    {
		name = nameOfContinent;
		bonusArmies = bArmies;
		countries = memberCountries;
    }
    
    public String getName()
    {
        //Returns the continents name
		return name;
    }
    
    public int getBonusArmies()
    {
        //Returns the number of armies given for controlling the continent
		return bonusArmies;
    }
    
    public Country[] getCountries()
    {
        //Returns the countries in the continent
		return countries;
    }
    
    public Player anOwner()
    {
        boolean anOwner = true;
        Player occupantOfFirst = null;
        
        //Determines if a player owns all of the territories in the continent and then returns them
        for (int i = 0; i < this.countries.length; i++)
        {
            if (i == 0)
            {
                occupantOfFirst = countries[i].getOccupant();
                System.out.println(occupantOfFirst.getArmy().getOwner());
            }
            else
            {
                if (countries[i].getOccupant() != occupantOfFirst)
                {
                    System.out.println(countries[i].getOccupant().getArmy().getOwner());
                    anOwner = false;
                    return null;
                }
            }
        }
        return occupantOfFirst;
    }
}
