readMe for 1007 Assignment 1
Rock Paper Scissors Lizard Spock
Amarto Rajaram
aar2160
-------------------

My program for this assignment consists of six classes (including the Test class.)
------
Test: 

I designed my program such that the test class would be of minimal size and complexity, in keeping with style conventions. My Test class consists of a main method that creates an instance of Game, and calls its Play method.

Commented out, below this code, is the code that creates an instance of AutomatedGame (a class which extends Game and inherits its methods--- I will justify this later on) and calls its play method to play a game between an AI computer and a random computer. 
------
Game:

This class describes a Game object, which consists of a Talker object (which handles user interaction) and a Thrower object, which chooses the computer's throw. It also has certain statistics about the game, such as the number of wins, losses and ties, and the percentages. The stats are static because they are called from Game's static getStats method, which is called from Game's own play method. These fields are protected because they need to be inherited by the subclass AutomatedGame (discussed later).

The constructor initializes all these instance variables, meaning that whenever a new Game is created, it starts with these values.
The Game's play method plays a game between a user and an AI computer. The talker prints the greeting and prompts a response from the player. Then the computer make's it's first throw and begins tracking the player's moves. It is important that this happens after the computer makes its move, so that the computer is not cheating. 

At the end of each round, the play method prints the choices made by each party in the round, and calls the Ruler's getResult method to determine the winner. This entire process is enclosed in a do-while loop and terminates when the user enters "z". I chose a do-while loop because I want the actions within to happen at least once, and more times if the player does not choose to quit. 

At the end of the play method, the stats for the game are printed and the Game ends. 

Finally, the Game's getStats method returns the number of wins, losses, ties, and percentages. It passes this to the Talker class, where it is printed out and displayed to the user. 
-------
AutomatedGame:

This class extends Game, and describes a specific type of Game called an AutomatedGame that occurs between two computers- a random computer and an AI computer. It inherits all of the (protected) fields from Game, and adds a new field, which is a new Thrower object. So in this case the AutomatedGame's Talker object only serves to print out the results of the game- it takes no user input. The AutomatedGame's constructor inherits everything from the Game constructor, except it also initializes the new Thrower.

The playTwoComps method, which I named as such to distinguish from Game's play method (simply for distinction/ease of use, even though I could have given it the same name and had it override the other method) plays 30 iterations of the game between the two computers. The intelligent computer throws, then the random computer throws, then the intelligent thrower begins tracking. So in this structure the intelligent thrower takes the role of the user in Game's play method, meaning the stats will be printed from the point of view of the intelligent computer. 

The rest of the playTwoComps method is similar to the play method from Game in terms of how it determines a winner, and at the end of the game the Game's Talker prints the stats about the game. 
------
Ruler:

This is the class that determines the rules of the game. 
Its fields are the static final constants that are used by Thrower and Game, so they are public. 

To determine the rules and the winner, I used a system of modular arithmetic. On the website where RPSLK's creator explains the game, he shows a diagram of the five choices laid out in a pentagon, with the different connections between them. I noticed that each choice beats the choice that comes after it in the circle, and is beaten by the choice that is 2 choices after it. 

I translated this into a system of arithmetic mod 5. So I assigned Rock 0, Lizard 1, etc up to Paper = 4. Then, to determine a winner, you convert the two Strings that represent the players' choices into these ints, and if they are the same then it is a tie, else if the first is 1 greater than the second (mod 5), then the first choice wins, and vice versa. Also, if the first is 2 less than the second (mod 5), then the first wins. 

The getResult method is static because I do not instantiate a Ruler in the game. My logic was that the rules of the game are constant and unchanging, and so it would not be accurate to instantiate a "ruler" upon the creation of a Game. 

The other two methods in this class convert between Strings (user/computer input) and numbers (what the game uses to decide a winner). These are used across different classes to convert between the two where necessary. 
---------
Talker:

This is the class that handles communication with the user. Its field is a scanner, private because it is not used anywhere else and no one else needs to have access to it. The constructor initializes a new Talker object and sets the Scanner to be a console input scanner.

The printGreeting method prints a welcome message and the rules of the game. 

The promptResponse method prompts the user to enter a choice, then reads it from console input.
I included a loop to catch user errors, to make sure that users only enter valid choices (using the method isValidChoice, which is discussed later on.) If the user enters an invalid choice they are prompted to try again. The promptResponse method returns the user's response as a String.

The printRound method prints the results of a given round, informing the user of their own choice, the computer's choice, and whether they won or lost. It takes as parameters the playerChoice, compChoice, and result, which are passed in when the printRound method is called in the Game class. 

The printStats method informs the user of the statistics at the end of the game. It is called after the user chooses to exit the game and it simply bids farewell to the user and prints out the String returned by the getStats method from Game.
----------
Thrower 

This is the class that handles the computer's moves. 
It is designed to use a rudimentary AI by tracking the opponent's past moves and choosing the move that counters the opponent's favorite or most common move. 

Its fields are a String compMove, and an integer array userTracker. 

In the constructor compMove is initialized to an empty string and userTracker is initialized to a new array of size 5 (since there are 5 choices and each index counts the number of choices at that value) and filled with zeroes.

The method intelligentThrow makes use of the tracking of the opponent's moves to make a move. It starts out by checking the array for the most common throw the opponent makes. Once it has found this, it uses the same modular arithmetic from Ruler to find the choice that will beat it. Then it converts this number to a String using the routine found in Ruler, and returns this string. 

Below this is the randomThrow method. This method generates a random number between 0 and 4 (inclusive), converts it to a string using the routine in Ruler, and returns the string. 

Below this is the trackUserChoice method. It uses an array to track the user's moves. Each index of the array (0-4) represents the value from Ruler's static final constants. Each time, this method reads the user choice, converts it to a number, and increments the array at that index, so that it keeps track of how many times the user has made each choice.
