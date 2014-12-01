// Creating a new deck of cards for each game of war
// Each new Deck is shuffled
import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;

public class Deck
{
   private ArrayList<Card> cards;
   
   public Deck() throws IOException
   {
      // Initialize variables and create an array list that will have 52 cards
      cards = new ArrayList<Card>();
      int index1, index2;
      Random generator = new Random();
      Card temp;
      
      // add 52 unique cards
      for (int i = 0; i <= 3; i++)
      {
         for (int j = 1; j <= 13; j++)
         {
            cards.add(new Card(i, j));
         }
      }
      
      // create 200 pairs and switch them in order to shuffle the cards
      for (int a = 0; a < 200; a++)
      {
         index1 = generator.nextInt(cards.size() - 1);
         index2 = generator.nextInt(cards.size() - 1);
         temp = (Card)cards.get(index2);
         cards.set(index2 , cards.get(index1));
         cards.set(index1, temp);
      }
   }
   
   // get the total number of cards. may be used in the GUI itself as a "total" button
   public int getTotal()
   {
      return cards.size();
   }
   
   public Card dealCard()
   {
      Card c = cards.remove(0);
      return c;
   }
   
   public boolean isEmpty()
   {
      return (cards.size() == 0);
   }
}