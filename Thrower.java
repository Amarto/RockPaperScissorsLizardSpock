/**
 * Thrower Class for Rock-Paper-Scissors-Lizard-Spock
 * This is the class that handles the computer's moves
 * Currently, chooses a random move 
 * @author amartorajaram aar2160
 *
 */
public class Thrower 
{
	private String compMove;
	private int[] userTracker;
	
	/**
	 * Initializes a new Thrower
	 */
	public Thrower()
	{
		compMove = "";
		userTracker = new int[5];
		
		for (int i = 0; i < userTracker.length; i++)
			userTracker[i] = 0;
	}
	
	/**
	 * Makes the computer's throw based on past user guesses
	 * [step 3] uses userTracker
	 * @return String compMove
	 */
	public String intelligentThrow()
	{
		int max = 0;
		int mostFreq = 0;
		for (int i = 0; i < userTracker.length; i++)
		{	
			if (userTracker[i] > max)
			{
				max = userTracker[i];
				mostFreq = i;
			}
		}
		
		//chooses corresponding move that 
		//beats most common player choice
		int compThrow = ((mostFreq + 2) % 5);   

		compMove = Ruler.numberToString(compThrow);
		
		return compMove;
	}
	
	/**
	 * Random throw method
	 * generates a random number to choose throw
	 * @return String compMove
	 */
	public String randomThrow()
	{
		int i = (int) (Math.random() * 5);
		
		compMove = Ruler.numberToString(i);
		
		return compMove;
	}

	
	/**
	 * Method to track user's choices
	 * Uses an array to count user's moves
	 * Justification for array data structure choice:
	 * low memory cost, constant time access
	 * @param userChoice
	 */
	public void trackUserMove(String userChoice)
	{		
		int i = Ruler.stringToNumber(userChoice);
		
		if (i != -1)
			userTracker[i]++;		
	}		
}
	
	
