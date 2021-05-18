package mod;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.ImageIcon;

public class Classroom {
	
	/* total number of inherited classes */
	private int _totalCls = 0;
	
	private Player _p;
	private int[][] _maze; 
	private int[][] _movedMaze;
	private int[] _startLoc;
	private ArrayList<String> task; //arrayList for future tasks (to be added)
	private ImageIcon _img;
	private int[] _powerup;
	
	public int[] getPowerup() {
		return _powerup;
	}
	
	public String getTask() { return task.get(0); }
	public int[][] getMaze(){ return _maze; }
	public int[] getStartLoc() {  return _startLoc; }
	public int[][] getMovedMaze() { return _movedMaze; }
	public void setMovedMaze(int row, int col) { /*_movedMaze[row][col] = 4;*/ }
	public void setPath(int r, int c) {}
	

	public ImageIcon getImg() {
		_img = new ImageIcon();
		return _img;
	}
}
