Positional Game

Consider a game played on a grid-shaped board. A grid is a two-dimensional structure of intersecting lines, the lines are evenly spaced, intersecting at right angles.
At the beginning of the game, there will be randomly placed small line-shaped tokens (sticks) that connect two adjacent intersections of the grid, along a line of the grid.

An intersection that is adjacent with at least one stick, is called a node.
The first player selects any node of the grid and places a circular-shaped token (stone) on it. Next, the players must alternatively choose a new unselected node that is adjacent (is connected by a stick) to the previously selected one and place a stone on it. They use stones of different colors. The player who cannot choose another node, loses the game.

In order to create a graphical user interface for the game, you may use either Swing or JavaFX.

Example of a board with randomly placed sticks and stones.


![image](https://user-images.githubusercontent.com/79132498/160984609-7544fabe-d211-4b6d-ba42-c20e7f55813d.png)


Compulsory (1p)

Create the following components:

-The main frame of the application.

-A configuration panel for introducing parameters regarding the grid size and a button for creating a new game. The panel must be placed at the top part of the frame. 

-The panel must contain at least one label and one input component.

-A canvas (drawing panel) for drawing the board. Draw the grid lines according to the values specified in the config panel. This panel must be placed in the center part of the frame.

-A control panel for managing the game. This panel will contain the buttons: Load, Save, Exit ,etc. and it will be placed at the bottom part of the frame.

In ConfigurationPanel every time the state of the spinner is changed I am calling the draw method to change de grid layout.

In MainPannel I am also calling the draw method so that the start will be with 10 rows and 10 columns.

It look like this :

![image](https://user-images.githubusercontent.com/79132498/160987737-d55257b3-a574-41de-9209-97b2ba60916c.png)

