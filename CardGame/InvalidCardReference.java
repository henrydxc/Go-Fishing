/**
 * 
 */

/**
 * @author wernerla
 *
 */
public class InvalidCardReference extends Exception{

	/**
	 * set the exception message to the message that is adapt to this particular project
	 */
	public InvalidCardReference() {
		// TODO Auto-generated constructor stub
		super("No such card in the hand");
	}
	
	 public InvalidCardReference(String msg)
	 {
	     super(msg);
	 }

	}

