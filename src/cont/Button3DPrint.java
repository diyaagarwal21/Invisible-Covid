package cont;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import mod.Player;
import view.MapMaker;

public class Button3DPrint implements ActionListener {
	
	private JButton _button;
	private Player _ply;
	private MapMaker _mm;
	
	public Button3DPrint(JButton but, MapMaker m) {
		_button = but;
		_ply = new Player();
		_mm = m;
		
	}
	
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
