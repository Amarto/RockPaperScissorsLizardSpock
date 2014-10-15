/**
 * Talker Class for Rock-Paper-Scissors-Lizard-Spock
 * This is the class that handles communication with the user
 * Reads input and prints output
 * @author amartorajaram aar2160
 *
 */

import java.util.Scanner;

public class Talker 
{
	private Scanner sc;

	/**
	 * Initialize a new "Talker"
	 */
	public Talker()
	{
		sc = new Scanner(System.in);
	}
	
	/**
	 * Print the game's opening message and the rules
	 */
	public void printGreeting()
	{
		System.out.println("Welcome to Rock-Paper-Scissors-Lizard-Spock!");
		
		System.out.println("Here are the rules: \n Rock crushes Lizard "
				+ "\n Lizard poisons Spock "
				+ "\n Spock smashes Scissors \n Scissors cut Paper "
				+ "\n Paper covers Rock "
				+ "\n Rock smashes Scissors \n Scissors decapitate Lizard \n "
				+ "Lizard eats Paper \n "
				+ "Paper disproves Spock \n Spock vaporizes Rock "); 
	}
	
	/**
	 * Prompt a response from the user
	 * @return response, the user's move
	 */
	public String promptResponse()
	{
		System.out.println("Please enter your choice: ");
		System.out.println("r- rock, p-paper, s-scissors, l-lizard, k-spock z-quit");
		String response = sc.nextLine();
		while (!isValidChoice(response))   //catch user errors 
		{
			System.out.println("This is not a valid choice. Please try again!");
			response = sc.nextLine();
		}
		
		return response;
	}
	

	/**
	 * Print the results of a given round 
	 * @param playerChoice, the player's move
	 * @param compChoice, the computer's move
	 * @param result- win, loss, or tie
	 */
	public void printRound(String playerChoice, String compChoice, String result)
	{
		System.out.println("Your choice was: " + playerChoice);
		System.out.println("The computer's choice was: " + compChoice);
		System.out.println("You " + result + "!");
	}
	
	/**
	 * Prints the total game statistics:
	 * Wins, losses, ties, 
	 * Percentage wins, Percentage ties
	 */
	public void printStats()
	{
		System.out.println("Thank you for playing!");	
		System.out.println(Game.getStats());
	}

	/**
	 * Checks if the user's choice is valid
	 * @param choice, the user's choice
	 * @return true if valid, false if invalid
	 */
	public boolean isValidChoice(String choice)
	{
		String[] validChoices = {"r", "p", "s", "l", "k", "z"};
		
		for (int i = 0; i < validChoices.length; i++)
		{
			if (choice.equals(validChoices[i]))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Converts the one-letter string into a proper name for ease of reading
	 * @param s, the string
	 * @return String properName, the proper name of the selected object
	 */
	public static String readProperName(String s)
	{
		String properName = "";
		
		if (s.equals("r"))
			properName = "rock";
		else if (s.equals("p"))
			properName = "paper";
		else if (s.equals("s"))
			properName = "scissors";
		else if (s.equals("l"))
			properName = "lizard";
		else if (s.equals("k"))
			properName = "spock"; 
	
		return properName;
	}
}
