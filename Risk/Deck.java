import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
	private int i;
	private String input;
	private String name;
	private String[] cardTypes;
	private ArrayList<Card> deck;
	private ArrayList<Country> countries;
	private Card drawCard;

	/**
	* Creates all 42 cards, one for each territory. Each card has either a type of Infantry, Cavalry, or Artillery. The number of Infantry, Cavalry, and Artillery are the same
	**/
	public Deck (ArrayList<Country> countries)
	{		
		Collections.shuffle(countries);
		deck = new ArrayList<Card>();
		for (i = 0; i < countries.size(); i++)
		{
		    int cardType;
		    if (countries.get(i).getName() == 
			deck.add(new Card(cardTypes[i / 14], countries.get(i)));
			System.out.println("Added new card to deck: " + deck.get(i).getName());
		}
		Collections.shuffle(deck);
	}
	public Card draw()
	{
		drawCard = deck.get(0);
		deck.remove(0);
		return drawCard;
	}
	public void add(Card card)
	{
		deck.add(card);
	}
	public void shuffle()
	{
		Collections.shuffle(deck);
	}
}
