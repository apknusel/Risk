 
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class Clicktoimage extends JFrame {
 
   private JLabel label;
   private ImageIcon image;
   private JButton button;
    
   public Clicktoimage (){
   setLayout (new FlowLayout());
    
   button = new JButton ("Click for image");
   add (button);
    
    image = new ImageIcon (getClass().getResource(""));
    label = new JLabel(image);
    add (label);
    
    event click = new event();
    button.addActionListener(click);
   }
     public class event implements ActionListener {
        public void actionPerformed(ActionEvent click){
        image = new ImageIcon (getClass().getResource("S1.png"));
       
        }
     }
     
    public static void main(String[] args) {
      Clicktoimage gui = new Clicktoimage();
      gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      gui.setVisible(true);
      gui.setSize(300,150);
      gui.setTitle("Image Events");   
    }
}