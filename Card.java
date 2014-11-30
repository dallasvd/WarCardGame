/* Individual Cards for the game of war */
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Card
{
   private int rank, suit;
   private final BufferedImage image;
   
   // Suit Value Constants
   public static final int SPADES = 0;
   public static final int HEARTS = 1;
   public static final int CLUBS = 2; 
   public static final int DIAMONDS = 3;
   
   // Face value constants
   public static final int ACE = 0;
   public static final int JACK = 10;
   public static final int QUEEN = 11;
   public static final int KING = 12;
   
   // Suit Names
   private final String [] suitNames = new String[]
   {
      "spades", "hearts", "clubs", "diamonds"
   };
   
   // Face name constants
   private final String [] rankNames = new String[]
   {
      "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"
   };
   
   public Card(int suit, int rank) throws IOException
   {
      this.suit = suit;
      this.rank = rank;
      File imageFile = new File("/Users/dallasdaniel/Desktop/cardPics(1)", rank + "-" + suit + ".jpg");
      this.image = ImageIO.read(imageFile);
   }
   
   public int getSuit()
   {
      return suit;
   }
   
   public int getRank()
   {
      return rank;
   }
   
   public String toString()
   {
      return rankNames[rank] + " of " + suitNames[suit];
   }
}