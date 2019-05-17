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
		diceArray = new ArrayList<Integer>(numberOfDice);
		for(int i = 0; i < numberOfDice; i++) 
		{
			roll = (int) (Math.random() * 6) + 1;
			diceArray.add(roll);
		}
		Collections.sort(diceArray);
		Collections.reverse(Arrays.asList(diceArray));
		return diceArray;
    }
}
