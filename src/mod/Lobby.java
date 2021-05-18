package mod;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;

public class Lobby extends Classroom{

	/**
	 * 0 = path
	 * 1 = wall/blockage
	 * 2 = invisible people
	 * 3 = task
	 * 4 = player has touched this spot (for movedMaze)
	 * 5 = powerup
	 */
	
	private Player _p;
	private int[][] _maze = {	
			{0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 1, 1, 1, 2, 0, 3, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{2, 0, 0, 0, 2, 0, 0, 0, 0, 1, 3, 2},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
			{0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
			{3, 0, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
			{0, 1, 1, 1, 1, 5, 0, 0, 0, 1, 1, 0},
			{0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0}
		};
	
	private int[][] _movedMaze = 
		{	{0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 1, 1, 1, 2, 0, 3, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{2, 0, 0, 0, 2, 0, 0, 0, 0, 1, 3, 2},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
			{0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
			{3, 0, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
			{0, 1, 1, 1, 1, 5, 0, 0, 0, 1, 1, 0},
			{0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0}
		};
	private int[] _startLoc = {1, 0};
	private ArrayList<String> task;
	private ImageIcon _img;
	private int[] _powerup = {9, 5};
	
	public Lobby() {
		task = new ArrayList<String>();
	}
	
	public int[] getPowerup() {
		return _powerup;
	}
	
	public void addTask() {
		task.add("Lobby: Pick a mask and sanitizer.");
	}
	
	public String getTask() {
		addTask();
		return task.get(0);
	}
	
	@Override
	public int[][] getMaze() {
		return _maze;
	}

	@Override
	public int[] getStartLoc() {
		return _startLoc;
	}
	
	public int[][] getMovedMaze(){
		return _movedMaze;
	}
	
	public void setMovedMaze(int row, int col) {
		_movedMaze[row][col] = 4;
	}
	
	public ImageIcon getImg() {
		_img = new ImageIcon(getClass().getResource("lobby.png"));
		return _img;
	}
	
	public void setPath(int r, int c) {
		_maze[r][c] = 0;
	}
	

}
