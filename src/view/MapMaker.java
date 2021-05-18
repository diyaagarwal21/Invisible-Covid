package view;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import cont.ButtonGetSani;
import cont.JOP;
import cont.LetterListener;
import mod.Classroom;
import mod.Courtyard;
import mod.EngRoom;
import mod.Lobby;
import mod.Player;

public class MapMaker extends TimerTask implements ActionListener  {
	
	private JButton _restart, _help, _seelayout, _exit, _sani, _ctest, _move,
			_lBut, _cBut, _eBut; //buttons for three classes
	private JFrame _fra;
	private JPanel _pan, _subPanN, _subPanS, _subPanC, 
					_subPanW, _subPanE, _school;
	private BorderLayout _lay;
	private JLabel[][] _view, _moved;
	private JLabel _tasks;
	private Player _ply;
	private Classroom _class;
	
	private Lobby _lobby;
	private Courtyard _ctyd;
	private EngRoom _eng;

	private LetterListener _letLis;
	private Timer _timer;
	private int _totalTouch; //total invisible covid the person touched
	private int _saniAmount; //total amount of sanitizer pumps the person has
	
	private Instructions _ins;

	public MapMaker(Classroom c, Player p) {
		_class = c;
		_ply = p;
		_lay = new BorderLayout();
		_lobby = new Lobby();
		_ctyd = new Courtyard();
		_eng = new EngRoom();
		_letLis = new LetterListener(this, _class, _ply);
		_timer = new Timer();
		_totalTouch = 0;
		_saniAmount = 10;
		
		
		//_ins = new Instructions();
		initPan();
		initButtons();
		initLabel();
		addToPan();
		initFrame();
	}

	private void initFrame() {
		_fra = new JFrame("Invisible COVID");
		_fra.setLayout(new BorderLayout());
		_fra.setResizable(false);
		_fra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_fra.setSize(_pan.getSize());
		_fra.setLocationRelativeTo(null);
		_fra.add(_pan);
		_fra.addKeyListener(_letLis);
		validateFrame();
	}
	
	public void initLabel() {
		_subPanC.removeAll();
		_view = new JLabel[12][12];
		for(int row = 0; row < _view.length; row++) {
			for(int col = 0; col < _view[0].length; col++) {
				_view[row][col] = new JLabel();
				if(_class.getMaze()[row][col] == 0 
						|| _class.getMaze()[row][col] == 2) {
					_view[row][col].setIcon(ClassIcons.getPath());
				}
				else if (_class.getMaze()[row][col] == 1) {
					_view[row][col].setIcon(ClassIcons.getWall());
				}
				else if (_class.getMaze()[row][col] == 3){
					_view[row][col].setIcon(ClassIcons.getTask());
				}
				else if((_class.getMaze()[row][col] == 5)) {
					_view[row][col].setIcon(ClassIcons.getPowerup());
				}
				validateLabel(row, col);
				_subPanC.add(_view[row][col]);	
			}
		}
		if(_ply.getPUp()) {
			int r = _ply.getRow();
			int c = _ply.getCol();
			_view[r][c].setIcon(ClassIcons.getPerson());
			validateLabel(r,c);
		}
		else {
			int r = _class.getStartLoc()[0];
			int c = _class.getStartLoc()[1];
			_view[r][c].setIcon(ClassIcons.getPerson());
			validateLabel(r,c);
		}
		validatePanel();
	}
	
	public void initLabel2() {
		_subPanC.removeAll();
		_view = new JLabel[12][12];
		for(int row = 0; row < _view.length; row++) {
			for(int col = 0; col < _view[0].length; col++) {
				_view[row][col] = new JLabel();
				if(_class.getMaze()[row][col] == 0 || 
						_class.getMaze()[row][col] == 5) {
					_view[row][col].setIcon(ClassIcons.getPath());
				}
				else if(_class.getMaze()[row][col] == 2) {
					_view[row][col].setIcon(ClassIcons.getTrace());
				}
				else if (_class.getMaze()[row][col] == 1) {
					_view[row][col].setIcon(ClassIcons.getWall());
				}
				else if (_class.getMaze()[row][col] == 3){
					_view[row][col].setIcon(ClassIcons.getTask());
				}
				
				validateLabel(row, col);
				_subPanC.add(_view[row][col]);	
			}
		}
		int r = _class.getStartLoc()[0];
		int c = _class.getStartLoc()[1];
		validateLabel(r,c);
		_tasks = new JLabel("You have 5 seconds to see the invisible COVID!");
		_subPanC.add(_tasks);
		validatePanel();
	}
	

	private void initPan() {
		_pan = new JPanel(_lay);
		_subPanN = new JPanel(); //panel for north
		_subPanS = new JPanel(); //panel for south
		_subPanC = new JPanel(new FlowLayout()); //panel for center
		_subPanW = new JPanel(); //panel for west
		_subPanE = new JPanel(); //panel for east
		_subPanC.setPreferredSize(new Dimension(500, 500));
		_subPanW.setPreferredSize(new Dimension(110, 700));
		_pan.setSize(800, 700);
		_pan.addKeyListener(new LetterListener(this, _class, _ply));
		validatePanel();
	}
	
	private void addToPan() {
		setN();
		setS();
		setW();
		setC();
		_subPanE.setPreferredSize(new Dimension(110, 700));
		_pan.setFocusable(true);
	}
	
	public void setPanE(JPanel pan) {
		_subPanE.removeAll();
		_subPanE.setPreferredSize(new Dimension(110, 700));
		_subPanE = pan;
		_subPanE.setVisible(true);
		_pan.add(_subPanE, BorderLayout.EAST);
		validatePanel();
	}
	
	public JPanel getPanS() { return _subPanS; }
	
	private void setN() {
		JLabel title = new JLabel();
		ImageIcon img = new ImageIcon(getClass().getResource("title.png"));
		title.setIcon(img);
		_subPanN.add(title);
		_pan.add(_subPanN, BorderLayout.NORTH);
	}
	
	private void setS() {
		_lBut = new JButton(_lobby.getTask());
		_cBut = new JButton(_ctyd.getTask());
		_eBut = new JButton(_eng.getTask());
		
		_lBut.addActionListener(this);
		_cBut.addActionListener(this);
		_eBut.addActionListener(this);
		
		_lBut.setFocusable(false);
		_cBut.setFocusable(false);
		_eBut.setFocusable(false);
		
		_lBut.setBackground(Color.GREEN);
		_cBut.setBackground(Color.LIGHT_GRAY);
		_eBut.setBackground(Color.LIGHT_GRAY);
		
		_subPanS.add(_lBut);
		_subPanS.add(_cBut);
		_subPanS.add(_eBut);
		_pan.add(_subPanS, BorderLayout.SOUTH);
		_pan.add(_subPanE, BorderLayout.EAST);
	}
	
	
	public void addSaniButton() {
		_subPanW.add(_sani);
	}
	
	private void setW() {
		_subPanW.setLayout(new GridLayout(6,1));
		_subPanW.add(_seelayout);
		_subPanW.add(_help);
		_subPanW.add(_restart); 
		_subPanW.add(_exit);
		
//		_move = new JButton("moved maze");
//		_move.setFocusable(false);
//		_move.addActionListener(this);
//		//_subPanW.add(_move);	
		
		_subPanW.add(_ctest);
		_pan.add(_subPanW, BorderLayout.WEST);
	}
	
	private void setC() {
		_pan.add(_subPanC, BorderLayout.CENTER);
	}
	
	private void initButtons() {
		_restart = new JButton("Restart");
		_help = new JButton("Help");
		_seelayout = new JButton("<html>School<br />Tasks</html>");
		_exit = new JButton("Exit");
		_sani = new JButton("<html>Sanitizer<br />" + _saniAmount + "/10 </html><br />");
		_ctest = new JButton("<html>Take A<br />COVID Test</html>");
		
		_restart.setFocusable(false);
		_help.setFocusable(false);
		_seelayout.setFocusable(false);
		_exit.setFocusable(false);
		_sani.setFocusable(false);
		_ctest.setFocusable(false);
		
		_restart.addActionListener(this);
		_seelayout.addActionListener(this);
		_sani.addActionListener(this);
		_exit.addActionListener(this);
		_ctest.addActionListener(this);
		_help.addActionListener(this);
	}
	
	public void validatePanel() {
		_pan.repaint();
		_pan.validate();
		_pan.setVisible(true);
		
		_subPanN.repaint();
		_subPanN.validate();
		_subPanN.setVisible(true);
		
		_subPanS.repaint();
		_subPanS.validate();
		_subPanS.setVisible(true);
		
		_subPanC.repaint();
		_subPanC.validate();
		_subPanC.setVisible(true);
	}
	
	private void validateFrame() {
		_fra.repaint();
		_fra.validate();
		_fra.setVisible(true);
	}
	
	private void validateLabel(int row, int col) {
		_view[row][col].repaint();
		_view[row][col].validate();
		_view[row][col].setVisible(true);
	}
	
	public void setTextL(String s) { _tasks.setText(s); }
	
	public void changePlayerPos(Classroom cl, int r, int c) {
		int row = _ply.getRow();
		int col = _ply.getCol();
		int[][] arr = cl.getMaze();
		
		if(cl.getMaze()[r][c] == 5) {
			_view[row][col].setIcon(ClassIcons.getPlyPower());
		}
		if(cl.getMaze()[r][c] == 0 
				||  cl.getMaze()[r][c] == 5) {
			_view[r][c].setIcon(ClassIcons.getPath());
		}
		else if(cl.getMaze()[r][c] == 2) {
			_view[r][c].setIcon(ClassIcons.getPath());
			_totalTouch++;
		}
		else if(cl.getMaze()[r][c] == 3) {
			_view[r][c].setIcon(ClassIcons.getTask());
		}
		if(_ply.getPUp() && 
				cl.getMaze()[cl.getPowerup()[0]][cl.getPowerup()[1]] == 5) { 
			_view[row][col].setIcon(ClassIcons.getPlyPower()); 
		}
		else { 	
			_view[row][col].setIcon(ClassIcons.getPerson());
		}
		if(cl.getMaze()[r][c] == 5 && !_ply.getPUp()) {
			_ply.setPUp(true); 
			JOP.ok("With this powerup, you can see the invisible COVID"
					+ "\nfor 5 seconds only!");
			clearPanC();
			initLabel2();
			_timer.schedule(this, 5000);
			_class.setPath(r, c);
			
		}
		else if(cl.getMaze()[r][c] == 6) {
			_view[r][c].setIcon(ClassIcons.getTrace());
		}
		validateLabel(r,c);
		validateLabel(row,col);
		validatePanel();
	
		_class.setMovedMaze(row, col);
	}
	
	public void clearPanC() { _subPanC.removeAll(); }
	
	public void changePlayerPos(Classroom cl) {
		int r = _ply.getRow();
		int c = _ply.getCol();
		
		int row = cl.getStartLoc()[0];
		int col = cl.getStartLoc()[1];
		
		_ply.setPos(row, col);
		
		if(cl.getMaze()[r][c] == 0) {
			_view[r][c].setIcon(ClassIcons.getPath());
		}
		else if(cl.getMaze()[r][c] == 2) {
			_view[r][c].setIcon(ClassIcons.getPath());
			_totalTouch++;
		}
		else if(cl.getMaze()[r][c] == 1) {
			_view[r][c].setIcon(ClassIcons.getWall());
		}
		else if(cl.getMaze()[r][c] == 3) {
			_view[r][c].setIcon(ClassIcons.getTask());
		}
		
		_view[row][col].setIcon(ClassIcons.getPerson());
		validateLabel(r,c);
		validateLabel(row,col);
		validatePanel();
	
		_class.setMovedMaze(row, col);
	}
	
	public Classroom getCls() {
		return _class;
	}
	public Player getPly() { return _ply; }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		if(e.getSource() == _move) {
//			movedMaze();
//		}
		if(e.getSource() == _help) {
			
			JOP.msg("Try to complete all your tasks at TERRA without testing "
					+ "\nCOVID Positive at the end of the day!"
					+ "\n\n"
					+ "- There will be invisible COVID in different parts of each location!"
					+ "\n- Use your mask and sanitizer to prevent getting COVID"
					+ "\n- Complete the tasks in each room by walking over the blue task marks "
					+ "\nand hovering/clicking over the buttons on the right."
					+ "\n- Use one power-up across three locations to see the position "
					+ "\nof the invisible COVID for 5 seconds"
					+ "\n- Finally, take a COVID test to see if you’ve tested positive (+) "
					+ "\nor negative (-)."
					+ "");
					
			//Instructions x = new Instructions();
		}
		
		if(e.getSource() == _restart) {
			String res = JOP.in("Are you sure you want to restart the program?"
					+ "\nAll your progress will be lost."
					+ "\nType in Yes (Y) or No (n)");
			if(res.equalsIgnoreCase("y") || res.equalsIgnoreCase("yes")){
				_fra.dispose();
				MapMaker mm = new MapMaker(new Lobby(), new Player());
			}
		}
		if(e.getSource() == _exit) {
			JOP.exit("Are you sure you want to exit the program?"
					+ "\nAll your progress will be lost.");
		}
		if(e.getSource() == _seelayout) {
			JOP.msg("Tasks for each location of TERRA: "
					+ "\n" + _lobby.getTask()
					+ "\n" + _ctyd.getTask()
					+ "\n" + _eng.getTask());
		}
		if(e.getSource() == _lBut) {
			_class = new Lobby();
			initLabel();
			_letLis = new LetterListener(this, _class, _ply);
			_fra.addKeyListener(_letLis);
			_subPanE.removeAll();
			_subPanE.setPreferredSize(new Dimension(100,700));
			changePlayerPos(_class);
			_lBut.setBackground(Color.GREEN);
			_cBut.setBackground(Color.LIGHT_GRAY);
			_eBut.setBackground(Color.LIGHT_GRAY);
		}
		if(e.getSource() == _cBut) {
			_class = new Courtyard();
			initLabel();
			_letLis = new LetterListener(this, _class, _ply);
			_subPanE.removeAll();
			_subPanE.setPreferredSize(new Dimension(100,700));
			_fra.addKeyListener(_letLis);
			changePlayerPos(_class);
			_cBut.setBackground(Color.GREEN);
			_lBut.setBackground(Color.LIGHT_GRAY);
			_eBut.setBackground(Color.LIGHT_GRAY);
		}
		if(e.getSource() == _eBut) {
			_class = new EngRoom();
			initLabel();
			_letLis = new LetterListener(this, _class, _ply);
			_subPanE.removeAll();
			_subPanE.setPreferredSize(new Dimension(100,700));
			_fra.addKeyListener(_letLis);
			_eBut.setBackground(Color.GREEN);
			_cBut.setBackground(Color.LIGHT_GRAY);
			_lBut.setBackground(Color.LIGHT_GRAY);
			
			changePlayerPos(_class);
		}
		if(e.getSource() == _ctest) {
			String res = JOP.in("Are you sure you want to take a covid test?"
					+ "\nType in Yes (Y) or No (n)");
			if(res.equalsIgnoreCase("y") || res.equalsIgnoreCase("yes")){
				if(calculateCovid()) {
					JOP.msg("You are .... COVID POSITIVE (+)! "
							+ "\n\nTry to be more safe by using sanitizer and the powerup"
							+ "\nwhen you play next time!"
							+"\n\nSTATISTICS:"
							+"\nTotal Invisible Covid touched: " + _totalTouch
							+ "\nTotal Sanitizer Uses: " + (10-_saniAmount)
							+ "\nPicked up a mask? --> " + _ply.hasMask());
	
				}
				else {
					JOP.msg("Congrats! You are .... COVID NEGATIVE (-) !"
							+ "\n\nYou were really safe (by using your sanitizer, mask, "
							+ "\nand the powerups) while playing the game!"
							+"\n\nSTATISTICS:"
							+"\nTotal Invisible Covid touched: " + _totalTouch
							+ "\nTotal Sanitizer Uses: " + (10-_saniAmount)
							+ "\nPicked up a mask? --> " + _ply.hasMask());
				}
				
			}
		}
		if(e.getSource() == _sani) {
			_saniAmount--;
			if(_saniAmount < 0) {
				JOP.msg("Sorry, the sanitizer bottle is empty!");
			}
			else {
			_sani.setText("<html>Sanitizer<br />" + _saniAmount + "/10 </html><br />");
		}}
	}

	
	private void movedMaze() {
		_subPanC.removeAll();
		_moved = new JLabel[12][12];
		for(int row = 0; row < _moved.length; row++) {
			for(int col = 0; col < _moved[0].length; col++) {
				_moved[row][col] = new JLabel();
				if(_class.getMovedMaze()[row][col] == 0 
						|| _class.getMovedMaze()[row][col] == 2) {
					_moved[row][col].setIcon(ClassIcons.getPath());
				}
				else if (_class.getMovedMaze()[row][col] == 1) {
					_moved[row][col].setIcon(ClassIcons.getWall());
				}
				else if (_class.getMovedMaze()[row][col] == 4) {
					_moved[row][col].setIcon(ClassIcons.getTrace());
				}
				else {
					_moved[row][col].setIcon(ClassIcons.getTask());
				}
				validateLabel(row, col);
				_subPanC.add(_moved[row][col]);
			}
		}
		int r = _ply.getRow();
		int c = _ply.getCol();
		_moved[r][c].setIcon(ClassIcons.getTrace());
		validateLabel(r,c);
		validatePanel();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		_timer.cancel();
		_timer.purge();
		_timer = new Timer();  
		clearPanC();
		initLabel();
	}
	
	public boolean calculateCovid() {
		int numTouched = _totalTouch;
		double numSani = 10 - _saniAmount;
		boolean hasMask = _ply.hasMask();
		
		if(hasMask) {
			if(numSani == 0 && numTouched < 4) {
				return false;
			}
			if(_totalTouch > numSani*1.5) {
				return true;
			}
		}
		else {
			if(_totalTouch > numSani) {
				return true;
			}
		}
		
		return false;
	}
	


}
