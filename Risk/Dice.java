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
        //Rolls the number of dice inserted and puts the results into an arrayList
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
