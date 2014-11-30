import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class War extends JFrame
{
   private JPanel panel;
   private JButton buttonNewGame,buttonNext;
   
   
   public War(String s)
   {  
      super(s);

      // set up a new panel in the frame
      panel = new JPanel();
      panel.setBackground(Color.green);
      buttonNewGame = new JButton("New Game");
      panel.add(buttonNewGame);

      buttonNext = new JButton("Next");
      panel.add(buttonNext);
   
      add(panel);
   }
   
   
   // main
   public static void main(String [] args)
   {
      JFrame frame = new War("War - The Card Game");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
      frame.setSize(700, 550);
      frame.setResizable(false);
  
   }
}