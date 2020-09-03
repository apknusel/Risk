
public class Country
{
    String name, nameWithoutSpaces;
    Player occupant;
    String continent;
    int troops;
    Country[] adjacentCountries;
    
    public Country(String nameOfCountry, String nameWOSpace, String continentIn)
    {
        name = nameOfCountry;
        nameWithoutSpaces = nameWOSpace;
        continent = continentIn;
    }
    
    public void setAdjacentCountries(Country[] adjacentCountries1)
    {
        //Sets the neighbours of the country
        adjacentCountries = adjacentCountries1;
    }
    
    public void setOccupant(Player player)
    {
        //Sets a new occupant of the country
        occupant = player;
    }
    
    public Player getOccupant()
    {
        //Returns the current occupant of the country
        return occupant;
    }

    public void addTroops(int soldiers)
    {
        //Adds troops to the country's total
        troops += soldiers;
    }
    
    public void removeTroops(int soldiers)
    {
        //Removes troops from the country's total
        troops -= soldiers;
    }
    
    public int getTroops()
    {
        //Gets the total number of troops in the country
        return troops;
    }
    
    public String getName()
    {
        //Returns the name of the country
        return name;
    }
    
    public String getNameWithoutSpaces()
    {
        //Returns the name of the country without spaces
        return nameWithoutSpaces;
    }
    
    public Country[] getAdjacentCountries()
    {
        //Gets the neighbours of the country
        return adjacentCountries;
    }
    
    public String getContinent()
    {
        //Returns what continent the country is in
        return continent;
    }
}
