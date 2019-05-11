import java.util.*;

public class Dice
{
	private int roll;
	private ArrayList<Integer> diceArray;
    private Random die;
    public Dice()
    {
    }
    public ArrayList<Integer> roll(int numberOfDice) 
    {
		diceArray = new ArrayList<Integer>();
		for(int i = 0; i < diceArray.size(); i++) 
		{
			die = new Random();
			roll = die.nextInt(5) + 1;
			diceArray.set(i, roll);
		}
		Collections.sort(diceArray);
		Collections.reverse(Arrays.asList(diceArray));
		return diceArray;
    }
}
