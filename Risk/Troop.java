public class Troop
{
    Country whereLocated;
    
    public Troop(Country whereLocatedNow)
    {
        //Sets where the troop is and adds one to the country
        whereLocated = whereLocatedNow;
        whereLocatedNow.addTroops(1);
    }

    public Country getWhereLocated()
    {
        //Returns the country where the troop is
        return whereLocated;
    }
    
    public void setWhereLocated(Country whereGoing)
    {
        //Changes where the troop is and takes a troop from the previous country and gives it to the new country
        whereLocated.removeTroops(1);
        whereLocated = whereGoing;
        whereLocated.addTroops(1);
    }
}
