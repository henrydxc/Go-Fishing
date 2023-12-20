/**
 * @author wernerla An interface for a playing card
 * 
 */
public interface CardInterface {
	// Define the suit
	public static final int SPADES = 1;
	public static final int HEARTS = 2;
	public static final int CLUBS = 3;
	public static final int DIAMONDS = 4;
	// define the card rank
	public static final int TWO = 2;
	public static final int THREE = 3;
	public static final int FOUR = 4;
	public static final int FIVE = 5;
	public static final int SIX = 6;
	public static final int SEVEN = 7;
	public static final int EIGHT = 8;
	public static final int NINE = 9;
	public static final int TEN = 10;
	public static final int JACK = 11;
	public static final int QUEEN = 12;
	public static final int KING = 13;
	public static final int ACE = 14;

	/**
	 * get the rank value of the card
	 * @return the rank value of the card
	 */
	public int getRank();

	//
	/**
	 * get the suit value of the card
	 * @return the suit value
    */
	public int getSuit();

	//
	/**
	 * set the rank value to the card
	 * @param rank the rank value to be set to the card
    */
	public void setRank(int rank);

	//
	/**
	 * set the suit value of the card
	 * @param suit the suit value to be set to the card
    */
	public void setSuit(int suit);

	//
	/**
	 * 	determine whether two card have the same suit
	 * @param  other the card to be compared to
    */
	public boolean sameSuit(Card other);

	//
	/**
	 * get the difference of two cards
	 * @param other the card to be compared to
    */
	public int compareTo(Card other);

	/**
	 *  compare two cards
	 * @param other
    */

	public int compareTo(Object other);

	//
	/**
	 * get the name of the rank
	 * @return the english name of the rank
    */
	public String getRankAsString();

	//
	/**
	 * get the name of the suit
	 * @return the english name of the rank
    */
	public String getSuitAsString();

	//
	@Override
	/**
	 * print the card, cards in deck or cards in hand
    */
	public String toString();

}
