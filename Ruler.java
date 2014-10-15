/**
 * Ruler class for Rock-Paper-Scissors-Lizard-Spock
 * Determines the rules of the game
 * @author amartorajaram aar2160
 *
 */
public class Ruler 
{
	//static final constants to represent the different choices
	//will be used in modular arithmetic to determine winners
	public static final int ROCK = 0;
	public static final int LIZARD = 1;
	public static final int SPOCK = 2;
	public static final int SCISSORS = 3;
	public static final int PAPER = 4;
	
	/**
	 * getResult method
	 * Static because the Rules of a game do not need an instance of rules to be called
	 * Uses modular arithmetic (mod 5) to determine winner
	 * @param int playerNum, player's choice
	 * @param int compNum, computer's choice
	 * @return String result: win, loss, or tie
	 */
	public static String getResult(int playerNum, int computerNum)
	{
		if (playerNum == -1)
			return "chose to quit";
		
		//The below modular arithmetic accounts for the 
		//cycle of strengths and weaknesses seen at
		//http://www.samkass.com/theories/RPSSL.html
		//starting with Rock as 0 and going counterclockwise
		else if (computerNum == playerNum)
			return "tie!";
		
		else if (playerNum == ((computerNum - 1) % 5) || playerNum == 
				((computerNum + 2) % 5))
			return "win!";
		
		else
			return "lose!";
	}
	
	/**
	 * Converts the string to an int 
	 * for use in the above modular arithmetic routine
	 * @param choice
	 * @return int choiceNumber
	 */
	public static int stringToNumber(String choice)
	{
		int choiceNumber = -1;
	
		if (choice.equals("r"))
			choiceNumber = ROCK;
	
		else if (choice.equals("l"))
			choiceNumber = LIZARD;
		
		else if (choice.equals("k"))
			choiceNumber = SPOCK;

		else if (choice.equals("s"))
			choiceNumber = SCISSORS;
		
		else if (choice.equals("p"))
			choiceNumber = PAPER;

		return choiceNumber;	
	}
	
	/**
	 * converts a number to a string
	 * @param choiceNumber
	 * @return String the number represents
	 */
	public static String numberToString(int choiceNumber)
	{
		String choice = "";
		if (choiceNumber == ROCK)
			choice = "r";
		
		else if (choiceNumber == LIZARD)
			choice = "l";
		
		else if (choiceNumber == SPOCK)
			choice = "k";
		
		else if (choiceNumber == SCISSORS)
			choice = "s";
		
		else if (choiceNumber == PAPER)
			choice = "p";

		return choice;
	}
}
