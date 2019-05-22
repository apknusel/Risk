public class Troop
{
    String type;
    Country whereLocated;
    
    public Troop(String typeOfTroop, Country whereLocatedNow)
    {
        type = typeOfTroop;
        whereLocated = whereLocatedNow;
    }

    public Country getWhereLocated()
    {
        return whereLocated;
    }
    
    public void setWhereLocated(Country whereGoing)
    {
        whereLocated = whereGoing;
    }
    
    public String getType()
    {
        return type;
    }
}
