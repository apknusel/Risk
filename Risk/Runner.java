public class Runner 
{
    public Runner()
    {
    }
    
    
    public static void main(String[] args)
    {
        Army arthursArmy = new Army("Arthur");
        Army alexsArmy = new Army("Alex");
        Player arthur = new Player(arthursArmy);
        Player alex = new Player(alexsArmy);
        Troop firstTroop = new Troop("Artillery", Alaska);
        System.out.println(arthur.getArmy().sizeOfArmy());
    }

}
