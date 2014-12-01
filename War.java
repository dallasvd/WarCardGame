import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class War extends JFrame
{
   private static final String BACK = "cardPics(1)/back.jpg";
   private WarGame game;
   private JPanel buttonPanel, playerDeckPanel, computerDeckPanel, cardsPanel, counterPanel;
   private ImageIcon playerCard;
   private ImageIcon computerCard;
   private ImageIcon backCardLeft;
   private ImageIcon backCardRight;
   private ImageIcon back;
   private JButton buttonFight;
   private JLabel backCardLabelLeft, backCardLabelRight, playerCardLabel, computerCardLabel;
   
   private JTextField playerCardsLeft, computerCardsLeft;
   private String war = "nope";
   
   
   public War() throws IOException
   {
      game = new WarGame();
      
      setLayout(new BorderLayout());
      setTitle("This. Is. War!");
      setSize(850, 400);
      setResizable(false);
      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      
      buildButtonPanel();
      add(buttonPanel, BorderLayout.PAGE_END);
      
      buildDecksPanel();
      add(playerDeckPanel, BorderLayout.LINE_START);
      add(computerDeckPanel, BorderLayout.LINE_END);
      
      buildCounterPanel();
      add(counterPanel, BorderLayout.PAGE_START);
      
      buildCardsPanel();
      add(cardsPanel, BorderLayout.CENTER);
      
      setVisible(true);
      
      JOptionPane.showMessageDialog(null, "Prepare for battle! \nYou have joined the card War! \n\nThe rules are the same as classic War. Aces however are low and there will be only one card placed facedown! \n\nHave fun!");
      
   }
   
   // build the button panel
   private void buildButtonPanel()
   {
      buttonFight = new JButton("Fight!");
      
      buttonFight.addActionListener(new PlayCardListener());
      
      buttonPanel = new JPanel();
      buttonPanel.add(buttonFight);
      buttonPanel.setBackground(new Color(128,0,128));
      
   }
   
   // build the decks panel
   private void buildDecksPanel()
   {
      backCardLeft = new ImageIcon(BACK);
      backCardRight = new ImageIcon(BACK);
      
      backCardLabelLeft = new JLabel();
      backCardLabelRight = new JLabel();
      backCardLabelLeft.setIcon(backCardLeft);
      backCardLabelRight.setIcon(backCardRight);
      
      playerDeckPanel = new JPanel();
      playerDeckPanel.add(backCardLabelLeft);
      computerDeckPanel = new JPanel();
      computerDeckPanel.add(backCardLabelRight);
      
      playerDeckPanel.setBackground(new Color(0,128,0));
      computerDeckPanel.setBackground(new Color(0,128,0));
   }
   
   // build the counter panel
   private void buildCounterPanel()
   {
        playerCardsLeft = new JTextField("Your Cards: 26", 26);
        computerCardsLeft = new JTextField("Computer's Cards: 26", 26);

        playerCardsLeft.setEditable(false);
        computerCardsLeft.setEditable(false);

        counterPanel = new JPanel();
        counterPanel.add(playerCardsLeft);
        counterPanel.add(computerCardsLeft);
    }
   
   // build the cards panel
   private void buildCardsPanel()
   {
      back = new ImageIcon();
      
      playerCardLabel = new JLabel(back);
      computerCardLabel = new JLabel(back);
      
      cardsPanel = new JPanel();
      cardsPanel.add(playerCardLabel);
      cardsPanel.add(computerCardLabel);
      cardsPanel.setBackground(new Color(0,128,0));
   }
   
   // card listener
   private class PlayCardListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (war.equals("last"))
         {
                playerCard = new ImageIcon(game.getPlayerCardPlayed());
                playerCardLabel.setIcon(playerCard);

                computerCard = new ImageIcon(game.getComputerCardPlayed());
                computerCardLabel.setIcon(computerCard);

                war = "final";
         }
         
         if (war.equals("true"))
         {
                playerCard = new ImageIcon(BACK);
                playerCardLabel.setIcon(playerCard);

                computerCard = new ImageIcon(BACK);
                computerCardLabel.setIcon(computerCard);

                war = "last";
         }
         
         if (war.equals("nope"))
         {
                // draw two cards
                Card playersCard = game.playerDraw();
                Card computersCard = game.computerDraw();

                // display the new images
                playerCard = new ImageIcon(playersCard.getCardImage());
                playerCardLabel.setIcon(playerCard);

                computerCard = new ImageIcon(computersCard.getCardImage());
                computerCardLabel.setIcon(computerCard);

                // time for war
                game.battling(playersCard, computersCard);

                if (playersCard.equals(computersCard))
                {
                    war = "true";
                    JOptionPane.showMessageDialog(null, "It's time for a war!");
                }

                if (!war.equals("true")){
                    playerCardsLeft.setText("Your Cards: " + (game.getPlayerCardsRemain() - 1));
                    computerCardsLeft.setText("Computer's Cards: " + (game.getComputerCardsRemain() - 1));

                }
         }
         
         if (war.equals("final"))
         {
                war = "nope";
                
                playerCardsLeft.setText("Your Cards: " + (game.getPlayerCardsRemain() - 1));
                computerCardsLeft.setText("Computer's Cards: " + (game.getComputerCardsRemain() - 1));
         }
      }
   }
   
   
   public static void main(String[] args)  throws IOException
   {
      War guiGame = new War();
   }
}