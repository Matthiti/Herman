# Herman

This is an implementation of the game "Herman". Currently, this game can be played with two, three or four players, but can be easily extended to support more players. 

## Rules

The rules of "Herman" are simple:

- All cards are divided over all players. In case of three players, the first players gets an extra card.
- The cards cannot be seen by the players. They should be piled up with the back upwards.
- All players draw the top card and throw them on the table
- The cards are compared. The order is as follows: 2..10, Jack, Queen, King, Ace. The suit is not important.
- If there is one winner, that players gathers all thrown cards and place them on his "won cards"-pile.
- If there are multiple winners, a second round is played between the winners. These players first draw a card and place them bottoms-up on the table. Then, they draw another card. These second cards are compared with each other. If there is one winner, the winner collects all cards and puts them on his "won cards"-pile. Otherwise, the described sequence is done again.
- If a player does not have any cards left in his deck, his "won cards"-pile is shuffled and replaces the deck, provided that his "won-cards"-pile is not empty. 
- If a player does not have any cards left in both his deck and his "won cards"-pile at the start of a round, that player is out of the game.
- If a player does not have any cards left in both his deck and his "won cards"-pile in the middle of a round, then the last card it threw is rethrown.
- The winner is the player that played away the other players and has all the cards.

## Contributors

- [Matthiti_13](https://github.com/Matthiti)
- Nikki Zandbergen
