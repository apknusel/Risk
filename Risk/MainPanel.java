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
   int click = 0;
   boolean gameOver = false;
   Player currentPlayer;
   Player nonCurrentPlayer;
   Player tempPlayer;
   CountriesContinents cc;
   Continent[] continents;
   Deck deck;
   String name1, name2;
   Army player1Army, player2Army;
   Player player1, player2;


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

       button = new JButton("Press for next move");
       button.setPreferredSize(new Dimension(200, 20));
       button.addActionListener(this);
       buttonBar.add(button);

       content.setBorder(BorderFactory.createLineBorder(Color.GRAY,3));

       //Map
       BufferedImage image1 = null;

       try
       {
           image1 = ImageIO.read(new File("map 10.jpg"));
       }
       catch(Exception e){}

       JLabel label = new JLabel(new ImageIcon(image1));
       JPanel card2 = new JPanel();
       content.add(label);

       //Makes all of the countries and continents and then sets the adjacent ones and then puts all of them into an arrayList
       cc = new CountriesContinents();
       cc.setAdjacentCountries();
       cc.setCountries();

       //Makes the continents from the countries
       continents = cc.continents;

       //Makes the deck from the countries arrayList
       deck = new Deck(cc.countries);

       //Gets the players names
       name1 = JOptionPane.showInputDialog(null, "What is the name of player 1?");
       name2 = JOptionPane.showInputDialog(null, "What is the name of player 2?");

       //Makes the armies and players
       player1Army = new Army(name1);
       player2Army = new Army(name2);
       player1 = new Player(player1Army);
       player2 = new Player(player2Army);

       //Splits the countries evenly between the two players
       deck.startOfGame(player1, player2);

       //Sets the current and not-current players
       currentPlayer = player1;
       nonCurrentPlayer = player2;
       click += 2;
   }


   /**
    * Respond to a button click by showing a dialog and setting the
    * message label to describe the user's response.
    */
   public void actionPerformed(ActionEvent evt)
   {
      //Not sure what this does
      String command = evt.getActionCommand();

      //The part that actually runs the game
      //Checks to see if there is a winner yet
      if (currentPlayer.isWinner() == false && nonCurrentPlayer.isWinner() == false)
      {
          if (click == 1)
          {
              //Changes whos turn it is
              tempPlayer = currentPlayer;
              currentPlayer = nonCurrentPlayer;
              nonCurrentPlayer = tempPlayer;
          }

          if (click == 2)
          {
              //Gets a string for each player of their countries and troops
              JFrame frame1 = new JFrame();
              JFrame frame2 = new JFrame();
              frame1.setPreferredSize(new Dimension(400, 450));
              frame2.setPreferredSize(new Dimension(400, 450));
              String player1Info = player1.getArmy().getOwner() + "\n" + player1Army.getDisplay();
              String player2Info = player2.getArmy().getOwner() + "\n" + player2Army.getDisplay();
              JTextArea player1Stuff = new JTextArea(3, 21);
              JTextArea player2Stuff = new JTextArea(3, 21);
              JScrollPane scrollPane1 = new JScrollPane(player1Stuff);
              JScrollPane scrollPane2 = new JScrollPane(player2Stuff);
              player1Stuff.setEditable(false);
              player2Stuff.setEditable(false);
              player1Stuff.append(player1Info);
              player2Stuff.append(player2Info);
              frame1.add(scrollPane1);
              frame2.add(scrollPane2);
              frame1.pack();
              frame2.pack();
              frame1.setVisible(true);
              frame2.setVisible(true);

              //Says who's turn it is
              String name = currentPlayer.getArmy().getOwner();
              String useless = JOptionPane.showInputDialog(null, "It is " + name + "'s turn (Type a letter and enter)");

              //Displays their cards
              JFrame frame3 = new JFrame();
              String playerHand = currentPlayer.getArmy().getOwner() + "'s Hand\n" + currentPlayer.getHand().forDisplay();
              JTextArea playerHand1 = new JTextArea(3, 20);
              JScrollPane scrollPane3 = new JScrollPane(playerHand1);
              playerHand1.setEditable(false);
              playerHand1.append(playerHand);
              frame3.add(scrollPane3);
              frame3.pack();
              frame3.setVisible(true);
          }

          if (click == 3)
          {
              int troopsToReceive;
              String tradeInCards;

              //Finds out if the player has any cards
              int cards = currentPlayer.getHand().getCards().size();

              //Finds out if the player wants to exchange cards for troops if they have cards
              if (cards > 0)
                  tradeInCards = JOptionPane.showInputDialog(null, "Would you like to trade in your cards for troops? (Y/N)");
              else
                  tradeInCards = "N";

              //Gets the cards to trade in if neccesary
              if (tradeInCards.equals("Y"))
              {
                  String countryCardsToTradeIn = JOptionPane.showInputDialog(null, "What country cards would you like to turn in? (No spaces in countries names)(NewGuinea)");
                  String[] countryCards = countryCardsToTradeIn.split(" ");
                  ArrayList<Card> cardsToTradeIn = new ArrayList<Card>();

                  //Goes through the players cards
                  for (int i = 0; i < currentPlayer.getHand().getCards().size(); i++)
                  {
                      Card card = currentPlayer.getHand().getCards().get(i);
                      String cardCountryName = card.getCountry().getNameWithoutSpaces();

                      //Goes through the countries the user gave
                      for (int j = 0; j < countryCards.length; j++)
                      {
                          if (cardCountryName.equals(countryCards[j]))
                          {
                              cardsToTradeIn.add(card);
                              currentPlayer.getHand().getCards().remove(card);
                          }
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

              String whereAndHowManyToPlaceTroops = JOptionPane.showInputDialog(null, "Where would like to place your " + troopsToReceive + " troops and how many at each spot? (Country # Country #)(No spaces in country names)");

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


          }

          if (click == 4)
          {
              //Find out if the user wants to attack
              String attack = JOptionPane.showInputDialog(null, "Do you want to attack? (Y/N)");
              boolean goingToAttack;
              String result = "";

              //Changes attack to a boolean
              if (attack.equals("Y"))
                  goingToAttack = true;
              else
                  goingToAttack = false;

              //Checks to make sure the user still wants to attack
              while (goingToAttack)
              {
                  //Finds out what country they want to attack with and against
                  String attacking = JOptionPane.showInputDialog(null, "What country do you want to attack from? (No spaces)");
                  String defending = JOptionPane.showInputDialog(null, "What country do you want to attack? (No spaces)");

                  Country attackingCountry = cc.getCountry(attacking);
                  Country defendingCountry = cc.getCountry(defending);

                  System.out.println(attacking);

                  String name = attackingCountry.getOccupant().getArmy().getOwner();
                  System.out.println("Hey");

                  //int size = attackingCountry.getTroops();
                  if (true)

                    message.setText(attacking);
                  ///message.setText(size);
                  Country[] attackingCountryNeighbours = attackingCountry.getAdjacentCountries();
                  ArrayList<Troop> attackers = new ArrayList<> ();
                  ArrayList<Troop> defenders = new ArrayList<> ();
                  boolean isNeighbour = false;
                  Army defendingArmy = nonCurrentPlayer.getArmy();
                  Army attackingArmy = currentPlayer.getArmy();
                  int defenderDice;
                  int attackerDice;
                  int[] attackingNumbers = new int[2];
                  int[] defendingNumbers = new int[2];
                  boolean[] results = new boolean[3];

                  //Simulates the battle
                  for (int i = 0; i < attackingCountryNeighbours.length; i++)
                  {
                      if (attackingCountryNeighbours[i].getNameWithoutSpaces() == defendingCountry.getNameWithoutSpaces())
                          isNeighbour = true;
                  }

                  for (int i = 0; i < attackingArmy.troops.size(); i++)
                  {
                      Troop currentTroop = attackingArmy.troops.get(i);
                      if (currentTroop.getWhereLocated().getNameWithoutSpaces().equals(attackingCountry.getNameWithoutSpaces()))
                          attackers.add(currentTroop);
                  }
                  attackers.remove(0);

                  if (isNeighbour == true && attackers.size() != 0)
                  {
                      for (int i = 0; i < defendingArmy.troops.size(); i++)
                      {
                          Troop currentTroop = defendingArmy.troops.get(i);
                          if (currentTroop.getWhereLocated().getName().equals(defendingCountry.getName()))
                              defenders.add(currentTroop);
                      }

                      if (defenders.size() >= 2)
                          defenderDice = 2;
                      else
                          defenderDice = 1;

                      if (attackers.size() >= 4)
                          attackerDice = 3;
                      else
                          attackerDice = attackers.size();

                      Dice dice = new Dice();
                      ArrayList<Integer> defenderNumbers = dice.roll(defenderDice);
                      ArrayList<Integer> attackerNumbers = dice.roll(attackerDice);



                      if (defenderDice > attackerDice)
                          defenderNumbers.remove(0);
                      else if (attackerDice - defenderDice == 2)
                      {
                          attackerNumbers.remove(0);
                          attackerNumbers.remove(0);
                      }
                      else if (attackerDice - defenderDice == 1)
                          attackerNumbers.remove(0);



                      if (attackerNumbers.get(0) > defenderNumbers.get(0))
                      {
                          boolean found = false;
                          for (int i = 0; i < defendingArmy.troops.size() && !found; i++)
                          {
                              if (defendingArmy.troops.get(i).getWhereLocated().getName() == defendingCountry.getName())
                              {
                                  defenders.remove(0);
                                  defendingArmy.troops.remove(i);
                                  found = true;
                                  defendingCountry.removeTroops(1);
                                  results[0] = true;
                              }
                          }
                      }

                      if (attackerNumbers.get(0) <= defenderNumbers.get(0))
                      {
                          boolean found = false;
                          for (int i = 0; i < attackingArmy.troops.size() && !found; i++)
                          {
                              if (attackingArmy.troops.get(i).getWhereLocated().getName() == attackingCountry.getName())
                              {
                                  attackers.remove(0);
                                  attackingArmy.troops.remove(i);
                                  found = true;
                                  attackingCountry.removeTroops(1);
                                  results[0] = false;
                              }
                          }
                      }

                      if (attackerNumbers.size() == 2)
                      {
                          if (attackerNumbers.get(1) > defenderNumbers.get(1))
                          {
                              boolean found = false;
                              for (int i = 0; i < defendingArmy.troops.size() && !found; i++)
                              {
                                  if (defendingArmy.troops.get(i).getWhereLocated().getName() == defendingCountry.getName())
                                  {
                                      defenders.remove(0);
                                      defendingArmy.troops.remove(i);
                                      found = true;
                                      defendingCountry.removeTroops(1);
                                      results[1] = true;
                                  }
                              }
                          }

                          if (attackerNumbers.get(1) <= defenderNumbers.get(1))
                          {
                              boolean found = false;
                              for (int i = 0; i < attackingArmy.troops.size() && !found; i++)
                              {
                                  if (attackingArmy.troops.get(i).getWhereLocated().getName() == attackingCountry.getName())
                                  {
                                      attackers.remove(0);
                                      attackingArmy.troops.remove(i);
                                      found = true;
                                      attackingCountry.removeTroops(1);
                                      results[1] = false;
                                  }
                              }
                          }
                      }
                  }

                  if (defenders.size() == 0)
                  {
                      defendingCountry.setOccupant(currentPlayer);
                      for (int i = 0; i < attackers.size(); i++)
                      {
                          attackers.get(i).setWhereLocated(defendingCountry);
                          defendingCountry.addTroops(1);
                      }
                      currentPlayer.bonusCard();
                      results[2] = true;
                  }
                  else
                      results[2] = false;

                  //Gives the results of the battles
                  if (results[0] == true && results[1] == true)
                      result = "Two opponent troops were killed";
                  else if (results[0] == true && results[1] == false || results[0] == false && results[1] == true)
                      result = "One of your troops were killed and one of the opponents troops were killed";
                  else if (results[0] == false && results[1] == false)
                      result = "Two of your troops were killed";
                  else if (results[0] == true)
                      result = "One opponent troop was killed";
                  else if (results[0] == false)
                      result = "One of your troops was killed";

                  if (results[2] == true)
                      result += " and you captured " + defendingCountry;

                  message.setText(result);

                  //Gets a string for each player of their countries and troops
                  JFrame frame1 = new JFrame();
                  JFrame frame2 = new JFrame();
                  String player1Info = player1.getArmy().getOwner() + "\n" + player1Army.getDisplay();
                  String player2Info = player2.getArmy().getOwner() + "\n" + player2Army.getDisplay();
                  JTextArea player1Stuff = new JTextArea(3, 21);
                  JTextArea player2Stuff = new JTextArea(3, 21);
                  JScrollPane scrollPane1 = new JScrollPane(player1Stuff);
                  JScrollPane scrollPane2 = new JScrollPane(player2Stuff);
                  player1Stuff.setEditable(false);
                  player2Stuff.setEditable(false);
                  player1Stuff.append(player1Info);
                  player2Stuff.append(player2Info);
                  frame1.add(scrollPane1);
                  frame2.add(scrollPane2);
                  frame1.pack();
                  frame2.pack();
                  frame1.setVisible(true);
                  frame2.setVisible(true);

                  //Finds out if the user wants to attack again
                  attack = JOptionPane.showInputDialog(null, "Do you want to attack again? (Y/N)");
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
          }

          if (click == 5)
          {
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
                  String whereFrom = JOptionPane.showInputDialog(null, "Where are you taking the troops from? (No spaces)");
                  String whereTo = JOptionPane.showInputDialog(null, "Where are you taking the troops to? (No spaces)");
                  String howManyToMove = JOptionPane.showInputDialog(null, "How many of the " + cc.getCountry(whereTo).getTroops() + " troops are you moving?");
                  int howMany = Integer.parseInt(howManyToMove);

                  //Moves the troops
                  currentPlayer.getArmy().moveTroops(cc.getCountry(whereFrom), cc.getCountry(whereTo), howMany);
              }
          }

          if (click == 6)
          {
              //Updates the winners
              currentPlayer.updateWinner(nonCurrentPlayer);
              nonCurrentPlayer.updateWinner(currentPlayer);

              //Resets getting a card for capturing a country
              currentPlayer.resetBonusCard();
          }
      }
      else
      {
          //Prints who the winner is
          if (currentPlayer.isWinner())
              System.out.println("The winner is " + currentPlayer.getArmy().getOwner());
              else
              System.out.println("The winner is " + nonCurrentPlayer.getArmy().getOwner());
      }

      if (click < 6)
          click += 1;
      else
          click = 1;
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