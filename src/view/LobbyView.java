package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.EventListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cont.ButtonGetMask;
import cont.ButtonGetSani;
import mod.Lobby;
import mod.Player;

public class LobbyView extends ClassroomView {

	private Player _p;
	private Lobby _lob;
	private MapMaker _mm;
	private JPanel _pan;
	private JButton _getMask, _getSani;
	
	public LobbyView(MapMaker m) {
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
		
		_getMask = new JButton("Get a Mask");
		_getSani = new JButton("Get Sanitizer");
		
		_getMask.addActionListener(new ButtonGetMask(_getMask, _mm));
		_getSani.addActionListener(new ButtonGetSani(_getSani, _mm));
		_getMask.setFocusable(false);
		_getSani.setFocusable(false);
		
		_pan.add(_getMask);
		_pan.add(_getSani);
		_pan.setVisible(true);
		validatePanel();
	}

	private void validatePanel() {
		_pan.repaint();
		_pan.validate();
		_pan.setVisible(true);
	}
	
}
