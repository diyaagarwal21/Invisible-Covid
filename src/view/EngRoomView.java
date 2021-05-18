package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import cont.Button3DPrint;
import cont.ButtonGetMask;
import cont.ButtonGetSani;
import cont.ButtonLunch;
import mod.Lobby;
import mod.Player;

public class EngRoomView extends ClassroomView {
	
	private Player _p;
	private Lobby _lob;
	private MapMaker _mm;
	private JPanel _pan;
	private JButton _3dprint;
	
	public EngRoomView(MapMaker m) {
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
		
		_3dprint = new JButton("Use 3D Printer!");
		
		_3dprint.addActionListener(new Button3DPrint(_3dprint, _mm));
		_3dprint.setFocusable(false);
		
		_pan.add(_3dprint);
		_pan.setVisible(true);
		validatePanel();
	}

	private void validatePanel() {
		_pan.repaint();
		_pan.validate();
		_pan.setVisible(true);
	}
}
