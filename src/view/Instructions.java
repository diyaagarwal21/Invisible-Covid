package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mod.Lobby;
import mod.Player;


/**
 * This class creates the introduction slides, where the instructions
 * of the game are shown. 
 */
public class Instructions implements ActionListener {
	
	private JFrame _fra;
	private JPanel _pan;
	private JButton _next, _start;
	private JLabel _lab;
	private ImageIcon _img, _img2;
	private MapMaker _mm;
	
	
	public Instructions() {
		makePan();
		makeComp();
		addToPan();
		makeFrame();
	}
	
	//creates JFrame to add instructions
	public void makeFrame() {
		_fra = new JFrame("GET COVID TEST");
		_fra.setLayout(new BorderLayout());
		_fra.setResizable(false);
		_fra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_fra.setSize(_pan.getSize());
		_fra.setLocationRelativeTo(null);
		_fra.add(_pan);
		_fra.revalidate();
		_fra.validate();
		_fra.setVisible(true);
	}
	
	//makes panel 
	public void makePan() {
		_pan = new JPanel(new FlowLayout());
		_pan.setSize(650, 600);
		_pan.setBackground(Color.LIGHT_GRAY);
		_pan.revalidate();
		_pan.validate();
		_pan.setVisible(true);
	}
	
	//creates the images with the instructions
	public void makeComp() {
		_lab = new JLabel();
		_img = new ImageIcon(getClass().getResource("Help1.PNG"));
		_img2 = new ImageIcon(getClass().getResource("help2.png"));
		_lab.setIcon(_img);
		
		_next = new JButton("Next");
		_start = new JButton("Start Game!");
		_next.addActionListener(this);
		_start.addActionListener(this);
		
	}
	
	//adds the images with instructions to the JPanel
	public void addToPan() {
		_pan.add(_lab);
		_pan.add(_next);
	}

	/**
	 * When the end of the instructions is reached, the JFrame is 
	 * replaced with the JFrame of actual game.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == _next) {
			_pan.removeAll();
			_lab.removeAll();
			_lab.setIcon(_img2);
			_pan.add(_lab);
			_pan.add(_start);
			_pan.repaint();
			_pan.validate();
		}
		if(e.getSource() == _start) {
			_fra.dispose();
			//_mm = new MapMaker(new Lobby(), new Player());
			
		}
	
	
	
	}
	
}
