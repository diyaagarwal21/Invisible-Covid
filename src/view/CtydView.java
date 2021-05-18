package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import cont.ButtonGetMask;
import cont.ButtonGetSani;
import cont.ButtonLunch;
import mod.Lobby;
import mod.Player;

public class CtydView extends ClassroomView {
	
	private Player _p;
	private Lobby _lob;
	private MapMaker _mm;
	private JPanel _pan;
	private JButton _lunch;
	
	public CtydView(MapMaker m) {
		_p = new Player();
		_lob = new Lobby();
		_mm = m;
	}
		
	public JPanel getPan() {
		makeView();
		return _pan;
	}
	
	public void makeView() {
		_pan = new JPanel();
		_pan.setLayout(new GridLayout(3,1));
		
		_lunch = new JButton("Pick Up Lunch");
		
		_lunch.addActionListener(new ButtonLunch(_lunch, _mm));
		_lunch.setFocusable(false);
		
		_pan.add(_lunch);
		_pan.setVisible(true);
		validatePanel();
	}

	private void validatePanel() {
		_pan.repaint();
		_pan.validate();
		_pan.setVisible(true);
	}
	
}
