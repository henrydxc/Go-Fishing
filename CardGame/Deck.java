import java.util.*;


/**
 * Represents a deck of cards
 * Has two shuffle methods
 * 
 *
 */
public class Deck{
  
  public static final int DECKSIZE = 52;
  private Card[] deck;
  private int cardsDealt = 0;
  
  public Deck() {
    this.initializeDeck();
    cardsDealt=0;
  }

  /**
   * set the number of counter of dealt cards to 0
   */

  private void reset() {
    cardsDealt = 0;
  }

  /**
   * get the number of the cards that have not been dealt
   * @return the number of the cards that have not been dealt
   */

  public int getCardsLeft() {
    return deck.length - cardsDealt;
  }

  /**
   *  get the number of the cards that have been dealt
   * @return the number of the cards that have been dealt
   */

  public int getCardsDealt() {
    return cardsDealt;
  }

  /**
   *deal a card from the deck
   * @return the deck after dealing a card
   */

  public Card dealCard() {
    if ( getCardsLeft() <= 0 ) {
      return null;
    }
    return deck[cardsDealt++];
  }
  /**
   * Create a full deck of 52 playing cards
   * initializes an array of the cards, unshuffled, with unique cards
   * Called only in Constructor
   */
  private void initializeDeck() {
    deck = new Card[DECKSIZE];
    int pos = 0;
    
    for( int suit = Card.SPADES; suit <= Card.DIAMONDS; suit++ ) {
      for( int rank = 2; rank <= Card.ACE; rank++ ) {
        deck[pos++] = new Card( suit, rank );
      }
    }
  }

  /**
   * shuffle the deck
   */

  public void randomShuffle() {
    Card[] other = deck;
    deck = new Card[deck.length];
    Random random = new Random(System.nanoTime());
    
    for( int i = 0; i < deck.length; i++ ) {
      int pos = random.nextInt(DECKSIZE);
      while( other[pos] == null ) {
        pos = random.nextInt(DECKSIZE);
      }
      deck[i] = other[pos];
      other[pos] = null;
    }
    reset();
  }
  /**
	 * swap the order of cards in the deck
    */

  public void randomShuffleSwap() {
    
    Random random = new Random(System.nanoTime());
    
    for( int i = 0; i < deck.length; i++ ) {
      int pos = random.nextInt(DECKSIZE);
      Card holder = new Card(deck[i]);
      deck[i] = deck[pos];
      deck[pos] = holder;
    }
    reset();
  }

  /**
   * print the deck
   * @return the list of the cards in the deck
   */

  public String toString(){
    String retString="";
    
    for (int i = 0; i<deck.length;i++){
      retString = retString + deck[i]+"\n";
      
      
    }
    return retString;
  }
}
