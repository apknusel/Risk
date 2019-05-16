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
    
    public String getType()
    {
        return type;
    }
}
