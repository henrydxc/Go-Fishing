/**
 * 
 * This class represents a single Card. The card is a traditional playing card -
 * A, 2, 3, ... K with suits clubs, diamonds, spades, or hearts. Jokers are not
 * represented.
 * 
 * Face values are represented by the numbers 2 through 14 where 11 is a jack,
 * 12 is a queen, 13 is a king, and 14 is an ace. Suits are represented by 1 for
 * spades, 2 for hearts, 3 for clubs, and 4 for diamonds. Ordinal value is such
 * that number cards are worth their face value, picture cards are worth 10 and
 * Ace is worth 11.
 */

public class Card implements CardInterface, Comparable {

	// instance variables
	private int suit;
	private int rank;

	/**
	 * construct a card with random rank value and random suit value
	 */
	public Card() {
		rank = (int) (Math.random() * 13) + 2;
		suit = (int) (Math.random() * 4) + 1;
	}

	/**
	 * construct a card that is copy from other card
	 *
    */

	public Card(Object other) {
		if (other != null && other instanceof Card) {
			this.setRank((((Card) other).getRank()));
			this.setSuit(((Card) other).getSuit());
		}

	}

	/**
	 * construct a card with rank and suit value
    */
	public Card(int suit, int rank) {
		this.setSuit(suit);
		this.setRank(rank);

	}

	/**
	 * get the rank value of the card
	 * @return the rank value of the card
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * get the suit value of the card
	 * @return the suit value of the card
	 */
	public int getSuit() {
		return suit;
	}

	/**
	 * set the rank to the intended value
	 * @param rank the rank this card is setting to
	 */
	public void setRank(int rank) {
		if (rank >= TWO && rank <= ACE)
			this.rank = rank;
		else
			throw new InvalidCardException("Attempt to set a card to an invalid rank");
	}

	/**
	 * set the suit to the intended value
	 * @param suit the suit value to be set to the card
	 */
	public void setSuit(int suit) {
		if (suit >= SPADES && suit <= DIAMONDS)
			this.suit = suit;
		else
			throw new InvalidCardException("Attempt to set card to an invalid suit");
	}

	/**
	 * determine if two cards have the same suit
	 * @param other another Card object
	 * @return the true value of if two cards have the same suit
	 */

	public boolean sameSuit(Card other) {
		if (other != null) {
			if (other.getSuit() == this.getSuit())
				return true;
			else
				return false;
		} else
			return false;
	}

	/**
	 * determine how much rank value two cards different from each other
	 * @param other the another card to compare with
	 * @return the difference between two cards
	 */

	public int compareTo(Object other) {
		if (other == null || !(other instanceof Card)) {
			return Integer.MAX_VALUE;
		} else {
			return this.rank - ((Card) other).rank;
		}
	}

	/**
	 * get the card rank name
	 * @return what the card rank called
	 */

	public String getRankAsString() {
		switch (rank) {
		case TWO:
			return "Two";
		case THREE:
			return "Three";
		case FOUR:
			return "Four";
		case FIVE:
			return "Five";
		case SIX:
			return "Six";
		case SEVEN:
			return "Seven";
		case EIGHT:
			return "Eight";
		case NINE:
			return "Nine";
		case TEN:
			return "Ten";
		case ACE:
			return "Ace";
		case KING:
			return "King";
		case QUEEN:
			return "Queen";
		case JACK:
			return "Jack";
		default:
			return Integer.toString(rank);
		}
	}

	/**
	 * get the card's suit name
	 * @return the name of the suit of the card
	 */
	public String getSuitAsString() {
		switch (suit) {
		case CLUBS:
			return "Clubs";
		case DIAMONDS:
			return "Diamonds";
		case HEARTS:
			return "Hearts";
		default:
			return "Spades";

		}
	}

	/**
	 * get the representation value of rank and suit
	 * @return the information of the suit and rank pof the card
	 */
	public String toString() {
		String retString = "rank: " + this.getRank() + " suit: " + this.getSuit();
		return retString;
	}

	@Override
	public int compareTo(Card other) {
		// TODO Auto-generated method stub
		return 0;
	}
}
