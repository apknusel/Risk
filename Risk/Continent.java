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
		return name;
    }
    
    public int getBonusArmies()
    {
		return bonusArmies;
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
            {
                for (int j = 0; i < this.countries.length; i++)
                {
                    System.out.println(this.countries[j].getName());
                }
                occupantOfFirst = countries[i].getOccupant();
                System.out.println(occupantOfFirst);
            }
            else
            {
                if (countries[i].getOccupant() != occupantOfFirst)
                {
                    System.out.println(countries[i].getOccupant());
                    anOwner = false;
                    return null;
                }
            }
        }
        return occupantOfFirst;
    }
}
