import java.awt.*;  
import javax.swing.*;

public class RiskMainPanel
{
     RiskMainPanel()  
     {
        JFrame f= new JFrame("Risk");    
        JPanel panel=new JPanel();  
        panel.setBounds(40,80,200,200);    
        panel.setBackground(Color.blue);  
        JButton b1=new JButton("New Game");     
        b1.setBounds(50,100,80,30);    
        b1.setBackground(Color.yellow);   
        JButton b2=new JButton("Load Game");   
        b2.setBounds(100,100,80,30);    
        b2.setBackground(Color.green);
        JButton b3=new JButton("Quit");   
        b3.setBounds(100,100,80,30);    
        b3.setBackground(Color.green);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        f.add(panel);  
        f.setSize(400,400);    
        f.setLayout(null);    
        f.setVisible(true);    
     }  
     public static void main(String args[])  
     {  
        new RiskMainPanel();  
     }
}  