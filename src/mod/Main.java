package mod;

import view.Instructions;
import view.MapMaker;

//This is the main class that causes the program to run.
public class Main {
	 
	public static void main(String[] args) {
		Lobby l = new Lobby();
		Player p = new Player();
		MapMaker mp = new MapMaker(l, p);	
		
		//Instructions i = new Instructions();
	}
	
}


