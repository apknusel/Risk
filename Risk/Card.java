public final class Card
{
    private final int stars;
    private final Country country;
    public Card(int bTroops, Country countryName)
    {
		stars = bTroops;
		country = countryName;
    }
    
	public String getName()
	{
	    //Returns the country's name
		return country.getName();
	}
	
    public int getStars()
    {
        //Returns how many stars you get for turning in the country card
		return stars;
    }
    
    public Country getCountry()
    {
        //Returns the country object
		return country;
    }
}
