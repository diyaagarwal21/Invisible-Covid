package cont;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import mod.Player;
import view.MapMaker;

//This class controls the actions/clicks of the 'Get Lunch" button in the Courtyard class.
public class ButtonLunch implements ActionListener {
	
	private JButton _button;
	private Player _ply;
	private MapMaker _mm;
	
	public ButtonLunch(JButton but, MapMaker m) {
		_button = but;
		_ply = new Player();
		_mm = m;
	}
	
	
	/**
	 * When you click the getLunch button, a JOptionPane pops up, saying that you 
	 * have completed one of your tasks. It also reminds you that you can take a COVID
	 * test at any time. 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(_button == e.getSource()) {
			_mm.getPly().setLunch(true);
			
			JOP.msg("Congrats! You picked up your lunch!"
					+ "\n\nYou can get COVID tested now to end the game,"
					+ "\nor you can wait to finish all your tasks!");
		}
	}
}
