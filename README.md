# Go-Fishing
A college assignment project
* download all java files and run the PlayGame file (without GUI).
  
The PlayGame class represents a deck of cards with a funDeck object of the DeckList class. We'll use numPplayers to represent the number of people playing, and playerScores to keep track of player scores.
The core method in this class is playNow(), which uses the first do-while loop to determine whether to start the next game after the end of a game. Use a second do-while loop to ask the user for an option number again when they enter a number other than an option in the menu selection screen. Inside the second do-while loop is a third do-while loop (line 56).This loop allows the user to be asked again for the number of players after confirming that they have entered a number outside their range since starting the game. Each of these choices is judged using the switch structure.
For 2-player games and games with more than 2 players, I used different methods including round, roundMulti, and roundN methods. Because when there are more than two players, when a player gets the card he asks for, the program needs to reconfirm the next player he chooses to ask. This is the main difference between the two approaches.
I created the check4 method to check if a player has four cards of equal rank in his hand.When there are four cards of equal rank in a player's hand, it removes those four cards from his hand and adds one point to that player's score.
I created the winner method to determine the winner. In this method I create a HashMap with the player's number as the key and the player's score as the value, and return the winner's number to an ArrayList, which is the return value of this method. This method also prints the winners.
I also created the searchHand method to find the index of a card of a particular rank in the hand and return the index of the card if found and -1 otherwise.
Finally, run the playNow method inside the main method of the class. InvalidCardReference is thrown in the signature
