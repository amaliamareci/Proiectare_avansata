Positional Game

Consider a game played on a grid-shaped board. A grid is a two-dimensional structure of intersecting lines, the lines are evenly spaced, intersecting at right angles.

At the beginning of the game, there will be randomly placed small line-shaped tokens (sticks) that connect two adjacent intersections of the grid, along a line of the grid.

An intersection that is adjacent with at least one stick, is called a node.

The first player selects any node of the grid and places a circular-shaped token (stone) on it. Next, the players must alternatively choose a new unselected node that is adjacent (is connected by a stick) to the previously selected one and place a stone on it. They use stones of different colors. The player who cannot choose another node, loses the game.

In order to create a graphical user interface for the game, you may use either Swing or JavaFX.

Example of a board with randomly placed sticks and stones.

![image](https://user-images.githubusercontent.com/79132498/162204883-b8d33a8c-10cf-4acc-b345-ea0381f99855.png)


Homework (2p)

Create the object oriented model.

Initialize the game by generating random sticks and place them on the board. Implement either direct or retained mode for drawing the game board.

Implement the logic of the game. When the player execute a mouse pressed operation, a stone must be drawn at the mouse location: red or blue depending on whose turn it is. Validate the move, according to the game rules. Determine the winner of the game.

(+0.5p) Export the current image of the game board into a PNG file.

(+0.5p) Use object serialization in order to save and restore the current status of the game.

I implemented all of the above.In main package i have Main class and MainFrame class , and in package panels i have DrawingPanel class,ConfigPanel class , ControlPanel class . In ControlPanel i have four buttons : exit for ending the game ,save for saving the status of the game ,load for reloading the game from the serializated object(doesn't work) and ss for making a screenshot of the current game and saving into a png file.

This is how my game looks like:

![image](https://user-images.githubusercontent.com/79132498/162205786-b7555c1b-6eba-422b-8077-6c38233384f8.png)
