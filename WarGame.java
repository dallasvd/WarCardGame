/*
Created by Dallas Daniel
Aces low
actual part of the game 
*/
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

public class WarGame implements WarGameInterface
{
   private ArrayList<Card> pot = new ArrayList<Card>();
   
   private Card playerCardPlayed;
   private Card computerCardPlayed;
   
   private QueueReferenceBased playerHand = new QueueReferenceBased();
   private QueueReferenceBased computerHand = new QueueReferenceBased();
   
   public WarGame() throws IOException
   {
      Deck deck = new Deck();
      
      dealHand(deck);
   }
   
   public void dealHand(Deck deck)
   {
      for(int i = 0; i < 26; i++)
      {
         playerHand.enqueue(deck.dealCard());
         computerHand.enqueue(deck.dealCard());      
      }
   }
   
   // during wars
   public void war(Card playerCard, Card computerCard)
   {
        Card faceDownPlayerCard = playerDraw();
        Card faceDownComputerCard = computerDraw();

        pot.add(playerCard);
        pot.add(computerCard);
        pot.add(faceDownPlayerCard);
        pot.add(faceDownComputerCard);

        playerCardPlayed = playerDraw();
        computerCardPlayed = computerDraw();

        //win or lose
        String results = battling(playerCardPlayed, computerCardPlayed);

        if (results == "win")
        {
            System.out.println("You win! <3");
        }

        if (results == "loss")
        {
            System.out.println("You lose! :(");
        }
   }
    
   //the crux of the game. comparing the two cards
   public String battling(Card playerCard, Card computerCard)
   {
      if (playerCard.getRank() > computerCard.getRank())
      {
         playerHand.enqueue(playerCard);
         playerHand.enqueue(computerCard);
         
         int loop = pot.size();
         for (int i = 0; i < loop; i++)
         {
            playerHand.enqueue(pot.remove(0));
         }
         
         return "win";
      }
      
      else if (computerCard.getRank() > playerCard.getRank())
      {
         computerHand.enqueue(computerCard);
         computerHand.enqueue(playerCard);
         
         int loop = pot.size();
         for (int i = 0; i < loop; i++)
         {
            computerHand.enqueue(pot.remove(0));
         }
         
         return "loss";
      }
      
      else
      {
         war(playerCard, computerCard);
      }
      
      return "0";
   }
   
   // draw a card
   public Card playerDraw()
   {
      if (playerHand.isEmpty())
      {
         gameOver("you");
      }
      return (Card)playerHand.dequeue();
   }
   
   // computer draws a card
   public Card computerDraw()
   {
      if (computerHand.isEmpty())
      {
         gameOver("opponent");
      }
      return (Card)computerHand.dequeue();
   }
   
   public Integer getPlayerCardsRemain()
   {
      return playerHand.getSize();   
   }
   
   public Integer getComputerCardsRemain()
   {
      return computerHand.getSize();
   }
   
   public String getPlayerCardPlayed()
   {
      return playerCardPlayed.getCardImage();
   }
   
   public String getComputerCardPlayed()
   {
      return computerCardPlayed.getCardImage();
   }
   
   public void gameOver(String s)
   {
      if (s.equals("you"))
      {
         JOptionPane.showMessageDialog(null, "You lose war! You are out of cards.");
      }
      else if (s.equals("opponent"))
      {
         JOptionPane.showMessageDialog(null, "Congratulations! You win! Your opponent is all out of cards!");
      }
      
      System.exit(0);
   }
   
}