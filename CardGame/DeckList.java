import java.util.LinkedList;
import java.util.Random;

public class DeckList extends Card {
	public static final int DECKSIZE = 52;
	private LinkedList<Card> deck;
	private int cardsDealt = 0;

	/**
	 * construct a deck of 52 cards
	 */
	public DeckList() {
		deck = new LinkedList<Card>();
		this.initializeDeck();
		this.cardsDealt = 0;
	}
	public LinkedList<Card> getDeck(){
		return deck;
	}

	/**
	 * initialize the deck to be a standard deck of cards with 52 cards
	 * which have 4 types of suit, each suit have rank 2 to ace
	 */

	private void initializeDeck() {
		for (int suit = Card.SPADES; suit <= Card.DIAMONDS; suit++) {
			for (int rank = Card.TWO; rank <= Card.ACE; rank++) {
				Card e = new Card(suit, rank);
				deck.addLast(e);

			}
		}
	}

	/**
	 * clear the counter of the deck and add a new deck to the original deck
	 */
	@SuppressWarnings("unused")
	public void reset() {
		cardsDealt = 0;
		this.initializeDeck();
	}

	/**
	 *  get the number of the cards left
	 * @return the number of the cards left
	 */
	public int getCardsLeft() {
		return this.DECKSIZE - cardsDealt;
	}

	/**
	 * get the number of the cards have been dealt
	 * @return the number of the cards have been dealt
    */
	public int getCardsDealt() {
		return cardsDealt;
	}

	/**
	 * deal a card form the deck
	 * @return the card that have been dealt
	 */

	public Card getCard() {
		if (this.getCardsLeft() <= 0 || this.deck.isEmpty()) {
			return null;
		}
		this.cardsDealt++;
		Card deal = (Card) deck.getFirst();
		deck.removeFirst();
		return deal;
	}

	/**
	 *  get the first card of the deck
	 * @return the first card of the deck
	 */
	public Card peek() {
		if (this.deck.isEmpty())
			return null;// no card to see
		else {
			return new Card(deck.getFirst());// use copy constructor
		}
	}

	/**
	 * shuffle the deck
	 */

	public void shuffle() {
		Random random = new Random(System.nanoTime());
		for (int i = 0; i < deck.size(); i++) {
			int pos1 = random.nextInt(deck.size());

			// swap two Cards in deck
			// get and remove a random card
			Card temp1 = (Card) this.deck.get(pos1);
			this.deck.remove(pos1);
			// get and remove another random card
			int pos2 = random.nextInt(deck.size());
			// make sure you are not swapping the same two
			while (pos2 == pos1)
				pos2 = random.nextInt(deck.size());
			Card temp2 = (Card) this.deck.get(pos2);
			this.deck.remove(pos2);
			// replace pos2 card with pos1 card
			deck.add(pos2, temp1);
			// replace pos1 card with pos2 card
			deck.add(pos1, temp2);
		}
	}

	/**
	 * display the deck
	 */

	public void showDeck() {
		for (int i = 0; i < deck.size(); i++) {
			System.out.print(this.deck.get(i) + ", ");
			if ((i + 1) % 5 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}
	/**
	 * display the deck with lines contain particular number of cards
	 * @param numPerLine the number of cards each line shows
	 */

	public void showDeck(int numPerLine) {
		for (int i = 0; i < deck.size(); i++) {
			System.out.print(this.deck.get(i) + ", ");
			if ((i + 1) % numPerLine == 0 && i != 0) {
				System.out.println();
			}
		}
		System.out.println();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DeckList [deck=" + deck + ", cardsDealt=" + cardsDealt + "]";
	}

}
