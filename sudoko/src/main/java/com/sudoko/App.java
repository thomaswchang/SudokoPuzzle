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
			game.play();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
