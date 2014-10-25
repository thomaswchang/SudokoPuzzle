SudokoPuzzle
============

This project is a Sudoko solver.  Sudoko is a popular board game where the objective is to fill a 9x9 grid in such a way that each row, each column, and each sub-grid have unique values from 1 to 9.  For more information, please read http://en.wikipedia.org/wiki/Sudoku.

This project is mvn compatible, and has the following directory structures:
	|-- README.md
	`-- sudoko
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
	    |   |               |   |-- Line.java
	    |   |               |   |-- Point.java
	    |   |               |   `-- SubGrid.java
	    |   |               `-- resource
	    |   |                   `-- input.csv
	    |   `-- test
	    |       `-- java
	    |           `-- com
	    |               `-- sudoko
	    |                   `-- AppTest.java


To run the program in Eclipse, please import the mvn project to Eclipse, and execute App.java.

If there are any questions, please contact thomas.w.chang@gmail.com.


