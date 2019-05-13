import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;

// http://math.hws.edu/eck/cs124/javanotes6/source/SimpleDialogDemo.java

public class MainPanel extends JApplet implements ActionListener
{
   JLabel message;  // A label for giving some feedback to the user.
                    // It appears at the top of the applet.
   public void init()
   {
          // Set up the applet with a message label and four buttons.
          // Each button will open a different type of dialog.

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
       
       button = new JButton("Player 1:");
       button.setPreferredSize(new Dimension(100, 20));
       button.addActionListener(this);
       buttonBar.add(button);
       
       button = new JButton("Player 2:");
       button.setPreferredSize(new Dimension(100, 20));
       button.addActionListener(this);
       buttonBar.add(button);
       
       content.setBorder(BorderFactory.createLineBorder(Color.GRAY,3));
       
       
       // Map
       BufferedImage image1 = null;

        try {
            image1 = ImageIO.read(new File("map3.jpg"));
        }
        catch(Exception e){}
        
        JLabel label = new JLabel(new ImageIcon(image1));
        JPanel card2 = new JPanel();
        content.add(label);
   } // end init()
   
 
   /**
    * Respond to a button click by showing a dialog and setting the 
    * message label to describe the user's response.
    */
   public void actionPerformed(ActionEvent evt)
   {
      String command = evt.getActionCommand();
      if (command.equals("Player 1:"))
      {
         message.setText("Displaying input dialog.");
         String response = JOptionPane.showInputDialog(null,"Enter your command.");
         if (response == null)
            message.setText("You canceled the input.");
         else if (response.trim().length() == 0)
            message.setText("You left the input box empty.");
         else
            message.setText("You entered \"" + response + "\".");
      }
      
      String command1 = evt.getActionCommand();
      if (command1.equals("Player 2:"))
      {
         message.setText("Displaying input dialog.");
         String response = JOptionPane.showInputDialog(null,"Enter your command.");
         if (response == null)
            message.setText("You canceled the input.");
         else if (response.trim().length() == 0)
            message.setText("You left the input box empty.");
         else
            message.setText("You entered \"" + response + "\".");
      }
   } // end actionPerformed()
} // end class SimpleDialogDemo