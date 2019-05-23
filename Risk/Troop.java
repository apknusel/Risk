public class Troop
{
    Country whereLocated;
    
    public Troop(Country whereLocatedNow)
    {
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
}
