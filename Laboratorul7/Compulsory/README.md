Lab 7

Concurrency

Write a program that simulates a word game between a given number of players.

At the beginning of the game there is a bag containing a number of tiles. Each tile represents a letter and has a number of points. The application will also use a dictionary that contains a list of acceptable words. Each player extracts 7 tiles from the bag and must create a word from the dictionary with them. When a player creates a word, it submits it to the board and receives a number of points (the value of tile points multiplied by the length of the word). After submitting a word of length k, the player will immediately request other tiles k from the bag(if this is possible). If the player cannot create a word, it will discard all the tiles and extract others (and passes its turn). The game ends when the bag becomes empty. The winner is the player with the highest score.

The players might take turns (or not...) and a time limit might be imposed (or not...).

The main specifications of the application are:

Compulsory (1p)

- [x] Create an object oriented model of the problem. You may assume that there are 10 tiles for each letter in the alphabet and each letter is worth a random number of points (between 1 and 10).

- [x] Each player will have a name and they must perform in a concurrent manner, extracting repeatedly tokens from the board.

- [x] Simulate the game using a thread for each player.

- [x] Pay attention to the synchronization of the threads when extracting tokens from the bag and when putting words on the board.


![image](https://user-images.githubusercontent.com/79132498/162586746-3ea3b11a-3921-426e-9e56-b62de91a0e0c.png)


In this project the players are extracting from the bag a set of letters (in this case 7 letters) and then they are sending to the board the word made from that letters.This goes on as long as there still enough letters in the bag .For each player I am making a new thread and then the Player class implements Runnable ,therefore it has a run method in wich i am making the runnable true or not,depending on the submitWord method .

I used logger for exceptions.
