import java.util.ArrayList;

public class Hand
{
    private boolean condition;
    private ArrayList<Card> hand;
    public Hand()
    {
        hand = new ArrayList<Card>();
    }
    
    public void add(Card card)
    {
        hand.add(card);
    }
    
    public int awardTroops(ArrayList<Card> cards)
    {
        int totalStars = 0;
        int troopsToGive = 0;
        for (int i = 0; i < cards.size(); i++)
        {
            totalStars += cards.get(i).getStars();
        }
        
        if (totalStars  == 1)
            troopsToGive = 1;
        else if (totalStars == 2)
            troopsToGive = 2;
        else if (totalStars == 3)
            troopsToGive = 4;
        else if (totalStars == 4)
            troopsToGive = 7;
        else if (totalStars == 5)
            troopsToGive = 10;
        else if (totalStars == 6)
            troopsToGive = 13;
        else if (totalStars == 7)
            troopsToGive = 17;
        else if (totalStars == 8)
            troopsToGive = 21;
        else if (totalStars == 9)
            troopsToGive = 25;
        else if (totalStars == 10)
            troopsToGive = 30;
        else
            troopsToGive = 30 + ((totalStars - 10) * 5);
        
        return troopsToGive;
    }

//  public void removeCardsFromHand(int in1, int in2, int in3)
//  {
//      if (canTurnInCards(in1, in2, in3) == true)
//      {
//          hand.remove(in3);
//          hand.remove(in2);
//          hand.remove(in1);
//      }
//      else
//          System.out.println("You must trade in three cards of the same type or one of each type.");
//  }
//  public boolean canTurnInCards(int in1, int in2, int in3)
//  {
//      condition = false;
//      if (hand.size() >= 3)
//          if (hand.get(in1).getType().equals(hand.get(in2).getType()) && hand.get(in1).getType().equals(hand.get(in3).getType()))
//              condition = true;
//          else if (!hand.get(in1).getType().equals(hand.get(in2).getType()) && !hand.get(in1).getType().equals(hand.get(in3).getType()) && !hand.get(in2).getType().equals(hand.get(in3).getType()))
//              condition = true;
// 
//      return condition;
//  }
//  public boolean mustTurnInCards()
//  {
//      condition = false;
//      if (hand.size() >= 5)
//          condition = true;
//          
//      return condition;
//  }
    public ArrayList<Card> getCards()
    {
        return hand;
    }
}