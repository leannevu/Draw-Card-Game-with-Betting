# Draw-Card-Game-with-Betting

A player from the list of players can draw two cards from a well-shuffled deck of cards without replacement and place a bet (0 to maximum amount of money they have). The player wins if both cards have the same numerical value (e.g., both cards are two queens, two fives, and so on) and is rewarded 20 times the amount of money they bet. If the two drawn cards are not the same, they lose the money they bet. 

For example, if a player bets $10 and two cards drawn randomly are an ace and a seven, then the player loses the $10. On the other hand if the two cards are both fours, then the player wins $200, twenty times the bet (plus the original $10 they bet). In other words, this is a 20-to-1 and not 20-for-1 type of payoff game. 

The player has the option of playing the game without betting any money but cannot bet more money than they have. The player can bet different amount for each game, quit at any time after completing a game, or after they run out of money. The deck of cards is reshuffled after the each game and the player has an option to continue playing or quit.

FEATURES:
- Use TreeSet datatype to save player objects 
- Deck of cards; check for numerical value, shuffle cards, and make cards non replaceable
- Print player information (name, age, balance)
- Print all players' information
- Save information of players (into text file)
- End current player's round
- Add, edit, delete, search, and view player's information
- View an about form of the GUI
- View results of selected player
- Splash screen
