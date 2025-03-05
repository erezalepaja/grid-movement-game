Console-based Grid Movement Game

Overview

This is a Java-based console game where a player navigates a dynamic grid while avoiding obstacles and collecting treasures. The game utilizes Object-Oriented Programming (OOP) principles, ensuring modularity and expandability. Players can define a custom board size, place the player at a chosen position, and move interactively using WASD controls. A scoring system rewards players for reaching treasure locations, and error handling ensures smooth gameplay.

Features

  Custom Board Size: Users can define the grid dimensions.

  Player Movement: Navigate the board using WASD controls.

  Obstacles and Treasures: Place obstacles and collect treasures.

  Scoring System: Gain points by collecting treasures.

  Error Handling: Prevents crashes and invalid moves.


How to Play

Initialize the Board:

Enter the board size as two space-separated integers (e.g., 5 5 for a 5x5 grid).

Set Player Position:

Enter the starting coordinates of the player.

Place Obstacles and Treasures:

Enter positions for obstacles (optional) and treasures.


Move the Player:

Use W (up), A (left), S (down), D (right) to move.

Press Q to quit the game.


Winning Condition:

Collect as many treasures as possible to maximize your score.


Code Structure

StartGame.java: Entry point of the game.

Game.java: Manages game flow and player input.

Board.java: Handles board creation and updates.

Box.java: Represents individual grid cells.

BoxType.java: Defines types of grid cells (empty, player, obstacle, treasure).

Display.java: Manages user interactions and console output.

Position.java: Represents player and object positions on the board.
