public class Rules
{
    boolean gameOver = false;
    static Player currentPlayer;
    static Player nonCurrentPlayer;
    static Player tempPlayer;
    public Rules()
    {
    }
    
    
    
    public static void main(String[] args)
    {
        //Makes all of the countries and continents and then sets the adjacent ones and then puts all of them into an arrayList
        CountriesContinents cc = new CountriesContinents();
        cc.setAdjacentCountries();
        cc.setCountries();
        
        //Makes the continents from the countries
        Continent[] continents = cc.continents;
        
        //Makes the deck from the countries arrayList
        Deck deck = new Deck(cc.countries);
        
        //Gets the players names
        //User feedbcak on name1
        //User feedback on name2
        
        //Makes the armies and players, with the armies taking their names, and the players taking the armies
        Army player1Army = new Army("Arthur");//will be name1
        Army player2Army = new Army("Alex");//will be name2
        Player player1 = new Player(player1Army);
        Player player2 = new Player(player2Army);
        
        //Splits the countries evenly between the two players
        deck.startOfGame(player1, player2);
        
        //Sets the current and not-current players
        currentPlayer = player1;
        nonCurrentPlayer = player2;
        
        //The part that actually runs the game
        //Checks to see if there is a winner yet
        while (currentPlayer.isWinner() == false && nonCurrentPlayer.isWinner() == false)
        {
            //Changes whos turn it is
            tempPlayer = currentPlayer;
            currentPlayer = nonCurrentPlayer;
            nonCurrentPlayer = tempPlayer;
            
            //Finds out if the player wants to exchange cards for troops
            //User feedback on trading in cards (tradeInCards)
            
            //Finds out how many troops the player gets
            int troopsToReceive = currentPlayer.numTroopsToReceive(continents, false);//Will be tradeInCards
            //Need to work on this method and awardTroops in hand
            
            //Gets user feedback on where they want their troops and tells them how many troops they get
            //User feedback on all the countries they want their troops going to(countriesToPut, Country[]) ex. (Canada, Canada, Russia, China)
            currentPlayer.wherePutNewTroops(countriesToPut, troopsToReceive);
            
            //Find out if the user wants to attack
            //User feedback on attacking (goingToAttack)
            
            //Checks to make sure the user still wants to attack
            while (goingToAttack)
            {
                //Finds out what country they want to attack with and against
                //User feedback on the attacking country (String attackingCountry)
                //User feedback on the defending country (String defendingCountry)
                
                //Simulates a battle
                currentPlayer.getArmy().battleOfTroops(currentPlayer, nonCurrentPlayer, cc.getCountry(attackingCountry), cc.getCountry(defendingCountry));
            
                //The table will be updated, should be automatic though
                
                //Finds out if the user wants to attack again
                //User feedback on attacking again(goingToAttack)
            }
            
            //Checks to see if the user gets a card for capturing a country
            if (currentPlayer.getsCard())
            {
                //Draws a card from the deck and gives it to the player
                Card card = deck.draw();
                currentPlayer.addCard(card);
            }
            
            //Sees if the user wants to move troops
            //User feedback on moving troops (moveTroops)
            
            //Moves troops if user said yes
            if (moveTroops)
            {
                //Finds out where the user wants them moved from, to, and how many
                //User feedback on where moved from (String whereFrom)
                //User feedback on where moved to (String whereTo)
                //User feedback on how many (howMany)
                
                //Moves the troops
                currentPlayer.getArmy().moveTroops(cc.getCountry(whereFrom), cc.getCountry(whereTo), howMany);
            }
            
            //Updates the winners
            currentPlayer.updateWinner(nonCurrentPlayer);
            nonCurrentPlayer.updateWinner(currentPlayer);
            
            //Resets getting a card for capturing a country
            currentPlayer.resetBonusCard();
        }
        
        //Prints who the winner is
        if (currentPlayer.isWinner())
            System.out.println("The winner is " + currentPlayer.getArmy().getOwner());
        else 
            System.out.println("The winner is " + nonCurrentPlayer.getArmy().getOwner());
    }
}
