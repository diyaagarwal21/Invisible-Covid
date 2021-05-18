package cont;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import mod.Player;
import view.MapMaker;

public class ButtonGetMask implements ActionListener{

	private JButton _button;
	private Player _ply;
	private MapMaker _mm;
	
	public ButtonGetMask(JButton but, MapMaker m) {
		_button = but;
		_ply = new Player();
		_mm = m;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(_button == e.getSource()) {
			_mm.getPly().setHasMask(true);
			
			JOP.msg("Congrats! You picked up a mask!"
					+ "\nA mask will protect you against a few accidental "
					+ "\nInvisible COVID contacts."
					+ "\n\nYou can get COVID tested now to end the game,"
					+ "\nor you can wait to finish all your tasks!");

			
	}

}}
