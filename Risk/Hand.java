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
        //Adds a card to a players hand
        hand.add(card);
    }
    
    public String forDisplay()
    {
        String string = "";
        
        //Formats the cards info and then returns it
        for (int i = 0; i < hand.size(); i++)
        {
            Card card = hand.get(i);
            string += card.getName() + " ";
            string += card.getStars() + "\n";
        }
        
        return string;
    }
    
    public int awardTroops(ArrayList<Card> cards)
    {
        int totalStars = 0;
        int troopsToGive = 0;
        
        //Counts the total stars of the cards being turned in
        for (int i = 0; i < cards.size(); i++)
        {
            totalStars += cards.get(i).getStars();
        }
        
        //Figures how many troops are being given out based on the stars being turned in
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

    public ArrayList<Card> getCards()
    {
        //Returns the players hand
        return hand;
    }
}