SudokoPuzzle
============

This project is a Sudoko solver.  Sudoko is a popular board game where the objective is to fill a 9x9 grid in such a way that each row, each column, and each sub-grid have unique values from 1 to 9.  For more information, please read http://en.wikipedia.org/wiki/Sudoku.

This project is maven compatible, and has the following directory structures:
	|-- pom.xml
	|-- src
	|   |-- main
	|   |   `-- java
	|   |       `-- com
	|   |           `-- sudoko
	|   |               |-- App.java
	|   |               |-- Game.java
	|   |               |-- components
	|   |               |   |-- Board.java
	|   |               |   |-- Element.java
	|   |               |   |-- Line.java
	|   |               |   |-- Point.java
	|   |               |   `-- SubGrid.java
	|   |               `-- resource
	|   |                   `-- input.csv
	|   `-- test
	|       `-- java
	|           `-- com
	|               `-- sudoko
	|                   `-- components
	|                       |-- BoardIT.java
	|                       `-- ElementIT.java
	
To run the program in Eclipse, please import the mvn project to an Eclipse project, and execute App.java.

If there are any questions, please contact thomas.w.chang@gmail.com.


