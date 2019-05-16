
public class Country
{
    String name;
    Player occupant;
    String continent;
    int troops;
    Country[] adjacentCountries;
    
    public Country(String nameOfCountry, String continentIn, int troopsThere)
    {
        name = nameOfCountry;
        continent = continentIn;
        troops = troopsThere;
    }
    
    public void setAdjacentCountries(Country[] adjacentCountries1)
    {
        adjacentCountries = adjacentCountries1;
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
}
