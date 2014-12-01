/* Individual Cards for the game of war */
import java.io.File;
import java.io.IOException;

public class Card
{
   private int rank, suit;
   
   // Suit Value Constants
   public static final int SPADES = 0;
   public static final int HEARTS = 1;
   public static final int CLUBS = 2; 
   public static final int DIAMONDS = 3;
   
   // Face value constants
   public static final int ACE = 1;
   public static final int JACK = 11;
   public static final int QUEEN = 12;
   public static final int KING = 13;
   
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
   
   private String cardImage;
   
   public Card(int suit, int rank)
   {
      this.suit = suit;
      this.rank = rank;
      cardImage = "cardPics(1)/" + rank + "-" + suit + ".jpg";
   }
   
   public int getSuit()
   {
      return suit;
   }
   
   public int getRank()
   {
      return rank;
   }
   
   public String getCardImage()
   {
      return cardImage;
   }
   
   public boolean equals(Card otherCard)
   {
      return rank == otherCard.rank;
   }
   
   public String toString()
   {
      return rankNames[rank] + " of " + suitNames[suit];
   }
}