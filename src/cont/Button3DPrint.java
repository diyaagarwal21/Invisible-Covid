package cont;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import mod.Player;
import view.MapMaker;

//This class controls the actions/clicks of the 'Use 3D Printer" button in the Engineering room class.

public class Button3DPrint implements ActionListener {

	private JButton _button;
	private Player _ply;
	private MapMaker _mm;
	
	public Button3DPrint(JButton but, MapMaker m) {
		_button = but;
		_ply = new Player();
		_mm = m;
		
	}
	
	/**
	 * When you click the 3D printer button, a JOptionPane pops up, saying that you 
	 * have completed one of your tasks. It also reminds you that you can take a COVID
	 * test at any time. 
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(_button == e.getSource()) {
			_mm.getPly().set3dprint(true);
			
			JOP.msg("Congrats! You 3D printed a part for the first time!"
					+ "\n\nYou can get COVID tested now to end the game,"
					+ "\nor you can wait to finish all your tasks!");
			
		}
	}
	
}
