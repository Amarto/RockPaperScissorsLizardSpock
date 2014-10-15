/**
 * Game class for Rock-Paper-Scissors-Lizard-Spock
 * Describes a game, which consists of a Thrower, a Talker, and some stats
 * Contains play method, which plays the game
 * and getStats method to return statistics about gameplay
 * @author amartorajaram aar2160
 *
 */
public class Game 
{
	protected Talker t;					
	protected Thrower th;				//protected because used in subclass AutomatedGame
	protected static int tiesCounter;
	protected static int winCounter;
	protected static int lossCounter;
	protected static int totalRounds;
	protected static double winPct;
	protected static double tiePct;
	
	/**
	 * Constructs a new game
	 */
	public Game()
	{
		t = new Talker();
		th = new Thrower();
		tiesCounter = 0; 
		winCounter = 0;
		lossCounter = 0;
		totalRounds = 0;
		winPct = 0;
		tiePct = 0;
	}
	

	
	/**
	 * Plays the game
	 * Continues to play rounds while the user's response is not "z"
	 * At the end, prints statistics about the game
	 */
	public void play()
	{
	
		String playerMove = "";
		String compMove = "";
		t.printGreeting();
		do
		{	
			//computer must begin tracking user's moves AFTER it makes its move
			//would be cheating if it "knew" about user move before choosing its own. 
			//the point of the AI is that it recognizes patterns, 
			//not that it is omniscient
			playerMove = (t.promptResponse());
			compMove = (th.intelligentThrow());
			th.trackUserMove(playerMove); 			
			
			//print the results of the round
			t.printRound(Talker.readProperName(playerMove), 
					Talker.readProperName(compMove),
					Ruler.getResult(Ruler.stringToNumber(playerMove), 
							Ruler.stringToNumber(compMove)));
			
			//increment the appropriate stats counters
			if (Ruler.getResult(Ruler.stringToNumber(playerMove), 
					Ruler.stringToNumber(compMove)).equals("win!"))
				winCounter++;	
			else if (Ruler.getResult(Ruler.stringToNumber(playerMove), 
					Ruler.stringToNumber(compMove)).equals("lose!"))
				lossCounter++;
			else if (Ruler.getResult(Ruler.stringToNumber(playerMove), 
					Ruler.stringToNumber(compMove)).equals("tie!"))
				tiesCounter++;
			
		} while (!playerMove.equals("z"));
		
		t.printStats();
	}
	
	
	
	
	/**
	 * Returns the counters for wins, losses and ties
	 * @return a string with game stats
	 */
	public static String getStats()
	{
		//calculate percentages
		totalRounds = winCounter + lossCounter + tiesCounter;
		winPct = ((double) winCounter / totalRounds) * 100;
		tiePct = ((double) tiesCounter / totalRounds)*100;
	
		return "\tWins: " + winCounter + "\n\tLosses: " + lossCounter + 
				"\n\tTies: " + tiesCounter + "\n\tWins: " + winCounter + 
				" out of " +totalRounds + 
				"\n\tTies: " + tiesCounter + " out of " + totalRounds
				+ "\n\tWin Pct: " + winPct + "%" + "\n\tTiePct: " 
				+ tiePct + "%";
	}


}
