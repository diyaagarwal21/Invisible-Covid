package cont;

import javax.swing.JOptionPane;
import mod.Lobby;
import mod.Player;
import view.MapMaker;

public class JOP {
	
	public static void msg(Object msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	
	public static String in(Object msg){
		return JOptionPane.showInputDialog(msg);
	}
	
	public static void ok(Object msg) {
	    String title = "SHOW INVISIBLE COVID!";
	    int optionType = JOptionPane.OK_CANCEL_OPTION;
	    int result = JOptionPane.showConfirmDialog(null, msg, title, optionType);
	}
	
	public static void exit(Object msg) {
		int rep = JOptionPane.showConfirmDialog(null, msg, "EXIT", JOptionPane.YES_NO_OPTION);
		if (rep == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public static void option(Object msg) {
		int rep = JOptionPane.showConfirmDialog(null, msg, "EXIT", JOptionPane.YES_NO_OPTION);
		if (rep == JOptionPane.YES_OPTION) {
			MapMaker mm = new MapMaker(new Lobby(), new Player());
		}
	}
	
}
