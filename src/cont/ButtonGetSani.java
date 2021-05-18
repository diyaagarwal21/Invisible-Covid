package cont;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import mod.Player;
import view.MapMaker;

public class ButtonGetSani implements ActionListener{

	private JButton _button;
	private Player _ply;
	private MapMaker _mm;
	
	public ButtonGetSani(JButton but, MapMaker m) {
		_button = but;
		_ply = new Player();
		_mm = m;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(_button == e.getSource()) {
			_mm.getPly().setHasSani(true);
			_mm.addSaniButton();
			JOP.msg("Now you can use sanitizer to protect yourself!"
					+ "\n\nYou can use the sanitizer 10 times maximum"
					+ "\nbefore the bottle finishes.");	
		}
		
	}
}
