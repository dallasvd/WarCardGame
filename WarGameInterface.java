public interface WarGameInterface
{
   public void dealHand(Deck deck);
   
   public void war(Card playerCard, Card computerCard);
   
   public String battling(Card playerCard, Card computerCard);
   
   public Card playerDraw();
   
   public Card computerDraw();
   
   public Integer getPlayerCardsRemain();
   
   public Integer getComputerCardsRemain();
   
   public String getPlayerCardPlayed();
   
   public String getComputerCardPlayed();
   
   public void gameOver(String s);
   
   
}