public class Troop
{
    String type;
    Country whereLocated;
    
    public Troop(String type, Country whereLocated)
    {
        type = type;
        whereLocated = whereLocated;
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
