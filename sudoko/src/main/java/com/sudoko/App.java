package com.sudoko;


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
