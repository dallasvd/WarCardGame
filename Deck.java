
import java.util.Random;
import java.util.ArrayList;

public class Deck
{
   private ArrayList<Card> cards;
   
   public Deck()
   {
      cards = new ArrayList<Card>();
      int index1, index2;
      Random generator = new Random();
      Card temp;
      
      for (int i = 0; i <= 3; i++)
      {
         for (int j = 0; j <= 12; j++)
         {
            cards.add(new Card(i, j));
         }
      }
      
      for (int a = 0; a < 200; a++)
      {
         index1 = generator.nextInt(cards.size() - 1);
         index2 = generator.nextInt(cards.size() - 1);
      }
   }
}