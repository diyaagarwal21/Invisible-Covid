package mod;

import java.util.ArrayList;
import java.util.Collections;

public class Courtyard extends Classroom {

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
			{0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
			{0, 2, 0, 0, 3, 0, 0, 0, 0, 2, 0, 0},
			{0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1},
			{0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1},
			{0, 0, 2, 1, 1, 0, 0, 1, 0, 0, 0, 1},
			{0, 3, 0, 1, 1, 0, 0, 1, 3, 0, 0, 1},
			{0, 0, 0, 0, 0, 0, 2, 1, 0, 0, 0, 1},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{0, 2, 5, 1, 1, 0, 0, 0, 0, 0, 0, 1},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
		};
	
	private int[][] _movedMaze = {
			{0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
			{0, 2, 0, 0, 3, 0, 0, 0, 0, 2, 0, 0},
			{0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1},
			{0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1},
			{0, 0, 2, 1, 1, 0, 0, 1, 0, 0, 0, 1},
			{0, 3, 0, 1, 1, 0, 0, 1, 3, 0, 0, 1},
			{0, 0, 0, 0, 0, 0, 2, 1, 0, 0, 0, 1},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{0, 2, 5, 1, 1, 0, 0, 0, 0, 0, 0, 1},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
		};
	
	private int[] _startLoc = {11, 0};
	private ArrayList<String> task;
	private int[] _powerup = {9, 2};
	
	public int[] getPowerup() {
		return _powerup;
	}
	
	public Courtyard() {
		task = new ArrayList<String>();
	}
	
	public void addTask() {
		task.add("Courtyard: Pick up lunch.");
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
	public void setPath(int r, int c) {
		_maze[r][c] = 0;
	}
	
	
}
