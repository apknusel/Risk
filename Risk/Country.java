
public class Country
{
    String name, nameWithoutSpaces;
    Player occupant;
    String continent;
    int troops;
    Country[] adjacentCountries;
    
    public Country(String nameOfCountry, String nameWOSpace, String continentIn, int troopsThere)
    {
        name = nameOfCountry;
        nameWithoutSpaces = nameWOSpace;
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
    
    public String getNameWithoutSpaces()
    {
        return nameWithoutSpaces;
    }
    
    public Country[] getAdjacentCountries()
    {
        return adjacentCountries;
    }
    
    public String getContinent()
    {
        return continent;
    }
}
