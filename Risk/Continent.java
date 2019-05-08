import java.util.ArrayList;
public class Continent
{
    private String name;
    private int bArmies;
    private ArrayList<Country> countries;
    public Continent(String name, int bArmies, ArrayList<Country> memberCountries)
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
    public ArrayList<Country> getCountries()
    {
		return countries;
    }
}
