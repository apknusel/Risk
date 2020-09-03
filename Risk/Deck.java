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
    private ArrayList<Card> discardPile;
    private ArrayList<Country> countries;
    private Card drawCard;

    /**
    * Creates all 42 cards, one for each territory. Each card has either a type of Infantry, Cavalry, or Artillery. The number of Infantry, Cavalry, and Artillery are the same
    **/
    public Deck (ArrayList<Country> countries)
    {       
        Collections.shuffle(countries);
        deck = new ArrayList<Card>();
        discardPile = new ArrayList<Card>();
        
        //Makes a card for all of the countries and then puts it into an arrayList
        for (i = 0; i < countries.size(); i++)
        {
            int cardType;
            String name = countries.get(i).getNameWithoutSpaces();
            if (name.equals("Ontario") || name.equals("Afghanistan") || name.equals("Siberia") || name.equals("SouthernEurope") || name.equals("WesternEurope") || name.equals("Yakutsk") || name.equals("Central Africa") || name.equals("Ural") || name.equals("NorthernEurope") || name.equals("Russia") || name.equals("Irkutsk") || name.equals("Mongolia")) 
            {
                Card card = new Card(2, countries.get(i));
                deck.add(card);
            }
            else
            {
                Card card = new Card(1, countries.get(i));
                deck.add(card);
            }
        }
        Collections.shuffle(deck);
    }
    
    public void startOfGame(Player player1, Player player2)
    {
        Army player1Army = player1.getArmy();
        Army player2Army = player2.getArmy();
        
        //Divides up the countries evenly and gives each player the troops for the countries and sets the occupant for each country
        for (int i = 0; i < 21; i++)
        {
            Card card1 = this.draw();
            Card card2 = this.draw();
            Country country1 = card1.getCountry();
            Country country2 = card2.getCountry();
            country1.setOccupant(player1);
            country2.setOccupant(player2);
            if (card1.getStars() == 2)
            {
                Troop troop1 = new Troop(country1);
                Troop troop2 = new Troop(country1);
                player1Army.addTroopToArmy(troop1);
                player1Army.addTroopToArmy(troop2);
            }
            else
            {
                Troop troop1 = new Troop(country1);
                player1Army.addTroopToArmy(troop1);
            }
            
            if (card2.getStars() == 2)
            {
                Troop troop1 = new Troop(country2);
                Troop troop2 = new Troop(country2);
                player2Army.addTroopToArmy(troop1);
                player2Army.addTroopToArmy(troop2);
            }
            else
            {
                Troop troop1 = new Troop(country2);
                player2Army.addTroopToArmy(troop1);
            }
        }
        this.shuffle();
        this.discardToDeck();
    }
    
    public Card draw()
    {
        //Makes sure the deck isn't empty and if it is it puts the discard pile back 
        if (deck.size() == 0)
            this.discardToDeck();
         
        Card drawCard = this.deck.get(0);
        
        //Puts the cards into the discard pile and then removes them from the deck
        discardPile.add(drawCard);
        deck.remove(0);
        return drawCard;
    }
    
    public void discardToDeck()
    {
        //Puts the discard pile into the deck
        for (int j = 0; j < discardPile.size(); i++)
        {
            deck.add(discardPile.get(0));
            discardPile.remove(0);
        }
        this.shuffle();
    }
    
    public void add(Card card)
    {
        //Adds a card to the deck
        deck.add(card);
    }
    
    public void shuffle()
    {
        //Shuffles the deck
        Collections.shuffle(deck);
    }
    
    public ArrayList<Card> getDeck()
    {
        //Returns the deck
        return deck;
    }
}
