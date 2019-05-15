
public class Country
{
    String name;
    Player occupant;
    String continent;
    int troops;
    Country[] adjacentCountries;
    
    public Country(String name, String continent, int troops)
    {
        name = name;
        troops = troops;
        continent = continent;
    }
    
    public void setAdjacentCountries(Country[] adjacentCountries)
    {
        adjacentCountries = adjacentCountries;
    }
    
    public void setOccupant(Player player)
    {
        occupant = player;
    }
    
    public Player getOccupant()
    {
        return occupant;
    }

    public void addTroops(int soldiers)
    {
        troops += soldiers;
    }
    
    public void removeTroops(int soldiers)
    {
        troops -= soldiers;
    }
    
    public int getTroops()
    {
        return troops;
    }
    
    public String getName()
    {
        return name;
    }
    
    public Country[] getAdjacentCountries()
    {
        return adjacentCountries;
    }
    
    public String getContinent(String continent)
    {
        return continent;
    }
    
    public String toString()
    {
        String newString = "";
        newString += name;
        newString += troops;
        return newString;
    }
}
