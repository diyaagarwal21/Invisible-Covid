package cont;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import mod.Classroom;
import mod.Courtyard;
import mod.EngRoom;
import mod.Lobby;
import mod.Player;
import view.ClassroomView;
import view.CtydView;
import view.EngRoomView;
import view.LobbyView;
import view.MapMaker;

//This class controls the key actions (WASD) to move player North, South, East, and West.
public class LetterListener implements KeyListener {
	
	private MapMaker _mm;
	private Classroom _cls;
	private Player _ply;
	private ClassroomView _cview;
	
	private Lobby _lob;
	private Courtyard _ctyd;
	private EngRoom _eng;
	
	
	public LetterListener(MapMaker m, Classroom c, Player p) {
		_mm = m;
		_cls = c;
		_ply = p;
		_cview = new LobbyView(_mm);
		_lob = new Lobby();
		_ctyd = new Courtyard();
		_eng = new EngRoom();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Based on what key is released and the location (lobby, courtyard, or engineering room),
	 * the player's position will change
	 * W - North
	 * A - West
	 * S - South
	 * D - East
	 */
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		if(_mm.getCls().getTask().equals(_lob.getTask())) {
			_cls = new Lobby();
			_cview = new LobbyView(_mm);
		}
		else if(_mm.getCls().getTask().equals(_ctyd.getTask())) {
			_cls = new Courtyard();
			_cview = new CtydView(_mm);
		}
		else if(_mm.getCls().getTask().equals(_eng.getTask())) {
			_cls = new EngRoom();
			_cview = new EngRoomView(_mm);
		}
		
		int r = _ply.getRow();
		int c = _ply.getCol();
		int mRows = _cls.getMaze().length;
		int mCols = _cls.getMaze()[0].length;
		int[][] maze = _cls.getMaze();
		
		JPanel pan = _cview.getPan();
		
		if(arg0.getKeyCode() == KeyEvent.VK_W) {
			_ply.movePlyN(_cls, r, c); 
			_mm.changePlayerPos(_cls, r, c);
		}
		if(arg0.getKeyCode() == KeyEvent.VK_A) {
			_ply.movePlyW(_cls, r, c);
			_mm.changePlayerPos(_cls, r, c);
		}
		if(arg0.getKeyCode() == KeyEvent.VK_S) {
			_ply.movePlyS(_cls, r, c);
			_mm.changePlayerPos(_cls, r, c);
		}
		if(arg0.getKeyCode() == KeyEvent.VK_D) {
			_ply.movePlyE(_cls, r, c);
			_mm.changePlayerPos(_cls, r, c);
		}
		
		if(maze[r][c] == 3) {
			_mm.setPanE(pan);
		}
		
	}
}
