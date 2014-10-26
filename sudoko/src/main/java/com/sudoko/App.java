package com.sudoko;

/**
 * Class is the entry point to the Sudoko game simulator.
 */
public class App 
{
    public static void main( String[] args )
    {
    	Game game = new Game();
    	try {
			game.startGame();
		} catch (Exception e) {
			System.out.println("The sudo application failed with this stack trace:" + e.getMessage());
		}
    }
}