import java.util.ArrayList;
public class Continent
{
    private String name;
    private int bArmies;
    private Country[] countries;
    public Continent(String name, int bArmies, Country[] memberCountries)
    {
		this.name = name;
		this.bArmies = bArmies;
		countries = memberCountries;
		System.out.println("Created continent: " + name + "\nBonus armies: " + bArmies);
    }
    
    public String getName()
    {
		return name;
    }
    
    public int getBonusArmies()
    {
		return bArmies;
    }
    
    public Country[] getCountries()
    {
		return countries;
    }
    
    public Player anOwner()
    {
        boolean anOwner = true;
        Player occupantOfFirst = null;
        for (int i = 0; i < this.countries.length; i++)
        {
            if (i == 0)
                occupantOfFirst = countries[i].getOccupant();
            else
            {
                if (countries[i].getOccupant() != occupantOfFirst)
                {
                    anOwner = false;
                    return null;
                }
            }
        }
        return occupantOfFirst;
    }
}
