
public class Country
{
    String name;
    String occupant;
    String continent;
    int troops;
    Country[] adjacentCountries;
    
    public Country(String name, String continent, int troops)
    {
        name = name;
        troops = troops;
        continent = continent;
        occupant = "None";
    }
    
    public void setAdjacentCountries(Country[] adjacentCountries)
    {
        adjacentCountries = adjacentCountries;
    }
    
    public void setOccupant(String player)
    {
        occupant = player;
    }
    
    public String getOccupant()
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
}
