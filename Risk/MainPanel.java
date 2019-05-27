import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

// http://math.hws.edu/eck/cs124/javanotes6/source/SimpleDialogDemo.java

public class MainPanel extends JApplet implements ActionListener
{
   JLabel message;
   public void init()
   {
      JPanel content = new JPanel();
      setContentPane(content);
      
       content.setBackground(Color.GRAY);
       content.setBackground(Color.GRAY);
       content.setLayout( new FlowLayout() );
       message = new JLabel("Click a button to open a dialog", JLabel.CENTER);
       message.setForeground(new Color(180,0,0));
       message.setBackground(Color.WHITE);
       message.setOpaque(true);
       getContentPane().add(message);
      
       
       JPanel buttonBar;
       JButton button;
       buttonBar = new JPanel();
       buttonBar.setLayout(new GridLayout(1,3));
       buttonBar.setBackground(Color.GRAY);
       content.add(buttonBar);

       button = new JButton("Game");
       button.setPreferredSize(new Dimension(100, 20));
       button.addActionListener(this);
       buttonBar.add(button);

       content.setBorder(BorderFactory.createLineBorder(Color.GRAY,3));
       
       // Map
       BufferedImage image1 = null;

        try {
            image1 = ImageIO.read(new File("map 10.jpg"));
        }
        catch(Exception e){}

        JLabel label = new JLabel(new ImageIcon(image1));
        JPanel card2 = new JPanel();
        content.add(label);
   }


   /**
    * Respond to a button click by showing a dialog and setting the
    * message label to describe the user's response.
    */
   public void actionPerformed(ActionEvent evt)
   {
      boolean gameOver = false;
      Player currentPlayer;
      Player nonCurrentPlayer;
      Player tempPlayer;
       
      //Not sure what this does
      String command = evt.getActionCommand();
      
      //Makes all of the countries and continents and then sets the adjacent ones and then puts all of them into an arrayList
      CountriesContinents cc = new CountriesContinents();
      cc.setAdjacentCountries();
      cc.setCountries();
        
      //Makes the continents from the countries
      Continent[] continents = cc.continents;
        
      //Makes the deck from the countries arrayList
      Deck deck = new Deck(cc.countries);
        
      //Gets the players names
      String name1 = JOptionPane.showInputDialog(null, "What is the name of player 1?");
      String name2 = JOptionPane.showInputDialog(null, "What is the name of player 2?");
      
      //Makes the armies and players, with the armies taking their names, and the players taking the armies
      Army player1Army = new Army(name1);
      Army player2Army = new Army(name2);
      Player player1 = new Player(player1Army);
      Player player2 = new Player(player2Army);
        
      //Splits the countries evenly between the two players
      deck.startOfGame(player1, player2);
        
      //Sets the current and not-current players
      currentPlayer = player1;
      nonCurrentPlayer = player2;
      
      for (int i = 0; i < player1Army.sizeOfArmy(); i++)
      {
          System.out.println(player1Army.troops.get(i).getWhereLocated().getName());
      }
      
      //The part that actually runs the game
      //Checks to see if there is a winner yet
      while (currentPlayer.isWinner() == false && nonCurrentPlayer.isWinner() == false)
      {
          //Changes whos turn it is
          tempPlayer = currentPlayer;
          currentPlayer = nonCurrentPlayer;
          nonCurrentPlayer = tempPlayer;
          
          //Display whose turn it is
            
          //Finds out if the player wants to exchange cards for troops
          String tradeInCards = JOptionPane.showInputDialog(null, "Would you like to trade in your cards for troops? (Y/N)");
          
          int troopsToReceive;
          
          //Gets the cards to trade in if neccesary
          if (tradeInCards.equals("Y"))
          {
              String countryCardsToTradeIn = JOptionPane.showInputDialog(null, "What country cards would you like to turn in?");
              String[] countryCards = countryCardsToTradeIn.split(" ");
              ArrayList<Card> cardsToTradeIn = new ArrayList<Card>();
              
              //Goes through the deck
              for (int i = 0; i < deck.getDeck().size(); i++)
              {
                  Card card = deck.getDeck().get(i);
                  String cardCountryName = card.getCountry().getName();
                  
                  //Goes through the countries the user gave
                  for (int j = 0; j < countryCards.length; j++)
                  {
                      if (cardCountryName.equals(countryCards[j]))
                          cardsToTradeIn.add(card);
                  }
              }
              
              //Finds out how many troops the player gets
              troopsToReceive = currentPlayer.numTroopsToReceive(continents, cardsToTradeIn);
          }
          else
          {
              //Finds out how many troops the player gets
              troopsToReceive = currentPlayer.numTroopsToReceive(continents);
          }
          
          String whereAndHowManyToPlaceTroops = JOptionPane.showInputDialog(null, "Where would like to place your " + troopsToReceive + " troops and how many at each spot? (Country # Country #)");
          int numberToAdd;
          Country countryToAdd;
          ArrayList<String> words = new ArrayList<String>();
          String[] whereAndHowManyToPlaceTroops1 = whereAndHowManyToPlaceTroops.split(" ");
          for (int i = 0; i < whereAndHowManyToPlaceTroops1.length; i++)
          {
              words.add(whereAndHowManyToPlaceTroops1[i]);
          }
          
          for (int i = 0; i < words.size(); i+=2)
          {
              countryToAdd = cc.getCountry(words.get(i));
              numberToAdd = Integer.parseInt(words.get(i + 1));
              for (int x = 0; x < numberToAdd; x++)
              {
                  Troop troop = new Troop(countryToAdd);
                  player1.getArmy().addTroopToArmy(troop);
              }
          }
          
          //Find out if the user wants to attack
          String attack = JOptionPane.showInputDialog(null, "Do you want to attack? (Y/N)");
          boolean goingToAttack;
          
          //Changes attack to a boolean
          if (attack.equals("Y"))
              goingToAttack = true;
          else
              goingToAttack = false;
            
          //Checks to make sure the user still wants to attack
          while (goingToAttack)
          {
              //Finds out what country they want to attack with and against
              String attackingCountry = JOptionPane.showInputDialog(null, "What country do you want to attack from?");
              String defendingCountry = JOptionPane.showInputDialog(null, "What country do you attack?");  
              
              //Simulates a battle
              currentPlayer.getArmy().battleOfTroops(currentPlayer, nonCurrentPlayer, cc.getCountry(attackingCountry), cc.getCountry(defendingCountry));
            
              //The table will be updated, should be automatic though
                
              //Finds out if the user wants to attack again
              attack = JOptionPane.showInputDialog(null, "Do you want to attack? (Y/N)");
              if (attack.equals("Y"))
                  goingToAttack = true;
              else
                  goingToAttack = false;
          }
            
          //Checks to see if the user gets a card for capturing a country
          if (currentPlayer.getsBonusCard())
          {
              //Draws a card from the deck and gives it to the player
              Card card = deck.draw();
              currentPlayer.addCard(card);
          }
            
          //Sees if the user wants to move troops
          String wantToMoveTroops = JOptionPane.showInputDialog(null, "Do you want to move troops? (Y/N)");
          boolean moveTroops;
          if (wantToMoveTroops.equals("Y"))
              moveTroops = true;
          else
              moveTroops = false;
          
          //Moves troops if user said yes
          if (moveTroops)
          {
              //Finds out where the user wants them moved from, to, and how many
              String whereFrom = JOptionPane.showInputDialog(null, "Where are you taking the troops from?");
              String whereTo = JOptionPane.showInputDialog(null, "Where are you taking the troops to?");
              String howManyToMove = JOptionPane.showInputDialog(null, "How many of the " + cc.getCountry(whereTo).getTroops() + " troops are you moving?");
              int howMany = Integer.parseInt(howManyToMove);
                
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

// if (command.equals("Player 1:"))
//       {
//          message.setText("Displaying input dialog.");
//          String response = JOptionPane.showInputDialog(null,"Enter your command.");
//          if (response == null)
//          {
//             message.setText("You canceled the input.");
//          }
//          else if (response.trim().length() == 0)
//          {
//             message.setText("You left the input box empty.");
//          }
//          else if (response.substring(0,11).equals("placetroops"))
//          {
//              int numberToAdd;
//              Country countryToAdd;
//              String test = "";
//              ArrayList<String> words = new ArrayList<String>();
//              String[] response1 = response.split(" ");
//              message.setText(test);
//              for (int i = 0; i < response1.length; i++)
//              {
//                  words.add(response1[i]);
//                 }
//              for (int i = 0; i < words.size(); i+=2)
//              {
//                  countryToAdd = cc.getCountry(words.get(i+1));
//                  numberToAdd = Integer.parseInt(words.get(i));
//                  for (int x = 0; x < numberToAdd; x++)
//                  {
//                      Troop troop = new Troop(countryToAdd);
//                      player1.getArmy().addTroopToArmy(troop);
//                  }
//              }
//              for (int i = 0; i < words.size(); i++)
//              {
//                  test += " "+words.get(i);
//              }
//              message.setText(test);
//          }
//          else
//          {
//             message.setText("You entered an invalid command.");
//          }
//       }
//       String command1 = evt.getActionCommand();
//       if (command1.equals("Player 2:"))
//       {
//          message.setText("Displaying input dialog.");
//          String response = JOptionPane.showInputDialog(null,"Enter your command.");
//          if (response == null)
//             message.setText("You canceled the input.");
//          else if (response.trim().length() == 0)
//             message.setText("You left the input box empty.");
//          else
//             message.setText("You entered \"" + response + "\".");
//       }