/**
 * This is an Automated Game Class for RPSLK
 * It extends the preexisting Game class
 * I chose to make a new class because,
 * upon reaching the last part of step 4, I realized
 * that I would not be able to produce the desired output from my
 * old framework without drastically modifying my code.
 * This way, I preserve the old code and functionality, and can 
 * have a separate type of game to play between two computers.
 * 
 * @author amartorajaram aar2160
 *
 */
public class AutomatedGame extends Game
{
	private Thrower random; //adds a random computer
	
	
	public AutomatedGame()
	{
		random = new Thrower();
	}
	
	/**
	 * Play method for two computers, one random, one intelligent.
	 */
	public void playTwoComps()
	{
		for (int i = 0; i < 30; i++)    //30 iterations of the game
		{
			String intelligentMove = th.intelligentThrow();
			String randomMove = random.randomThrow();
			th.trackUserMove(randomMove);
			
			if (Ruler.getResult(Ruler.stringToNumber(intelligentMove), 
					Ruler.stringToNumber(intelligentMove)).equals("win!"))
				winCounter++;	
			else if (Ruler.getResult(Ruler.stringToNumber(intelligentMove), 
					Ruler.stringToNumber(randomMove)).equals("lose!"))
				lossCounter++;
			else if (Ruler.getResult(Ruler.stringToNumber(intelligentMove), 
					Ruler.stringToNumber(randomMove)).equals("tie!"))
				tiesCounter++;
			
			
		}
		t.printStats();
	}
	
	

}