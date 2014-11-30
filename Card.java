/* Individual Cards for the game of war */

public class Card
{
   // Suit Value Constants
   public static final int SPADES = 1;
   public static final int HEARTS = 2;
   public static final int CLUBS = 3; 
   public static final int DIAMONDS = 4;
   
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
   private final String [] faceNames = new String[]
   {
      "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"
   };
   
   // Values
   private final int faceValue; // 1-13
   private final int suitValue; // 1-4
   private final int deckValue; // 1-52
   
   // Creating a card with Deck Value
   public Card(int deckValue)
   {
      if ((deckValue < 1) || (deckValue > 52))
      {
         throw new IllegalArgumentException();
      }
         
      this.deckValue = deckValue;
      faceValue = toFaceValue(deckValue);
      suitValue = toSuitValue(deckValue);
   }
   
   // Creating a card with the face value and suit value
   public Card(int faceValue, int suitValue)
   {
      if ((faceValue < 1) || (faceValue > 13))
      {
         throw new IllegalArgumentException();
      }
      
      if ((suitValue < 1) || (suitValue > 4))
      {
         throw new IllegalArgumentException();
      }
      
      this.deckValue = toDeckValue(faceValue, suitValue);
      this.faceValue = faceValue;
      this.suitValue = suitValue;
   }
   
   public boolean equals(Object other)
   {
      if (! (other instanceof Card))
      {
         return false;
      }
      Card cardOther = (Card)other;
      if (deckValue != cardOther.deckValue)
      {
         return false;
      }
      return true;
   }
   
   // Getters
   public int getDeckValue()
   {
      return deckValue;
   }
   
   public int getFaceValue()
   {
      return faceValue;
   }
   
   public int getSuitValue()
   {
      return suitValue;
   }
   
   public String getFaceName()
   {
      return faceNames[faceValue - 1];
   }
   
   public String getSuitName()
   {
      return suitNames[suitValue - 1];
   }
   
}