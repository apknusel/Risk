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
		return country.getName();
	}
	
    public int getStars()
    {
		return stars;
    }
    
    public Country getCountry()
    {
		return country;
    }
}
