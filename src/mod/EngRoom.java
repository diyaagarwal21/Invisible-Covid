package mod;

import java.util.ArrayList;

/**
 * This class represents the Engineering Room at TERRA, which extends the Classroom class.
 * It uses the methods from its parent class to create a maze for the player
 * to move through.
 * (Look at parent class [Classroom] to see the uses of Classroom and its classes)
 * 
 * The task of the Engineering Room is -> use the 3D printer.
 */
public class EngRoom extends Classroom {
	
	/**
	 * 0 = path
	 * 1 = wall/blockage
	 * 2 = invisible people
	 * 3 = task
	 * 4 = player has touched this spot (for movedMaze)
	 */
	
	private Player _p;
	private int[][] _maze = {
			{1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{1, 1, 1, 0, 0, 0, 0, 0, 0, 3, 0, 0},
			{1, 0, 0, 0, 2, 0, 1, 0, 0, 1, 0, 1},
			{0, 0, 0, 0, 0, 0, 1, 2, 0, 1, 0, 1},
			{3, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1},
			{2, 0, 0, 0, 0, 3, 1, 0, 0, 1, 2, 1},
			{1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1},
			{1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 5, 1},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0}
		};
	
	private int[][] _movedMaze = {
			{1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{1, 1, 1, 0, 0, 0, 0, 0, 0, 3, 0, 0},
			{1, 0, 0, 0, 2, 0, 1, 0, 0, 1, 0, 1},
			{0, 0, 0, 0, 0, 0, 1, 2, 0, 1, 0, 1},
			{3, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1},
			{2, 0, 0, 0, 0, 3, 1, 0, 0, 1, 2, 1},
			{1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1},
			{1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 5, 1},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0}
		};
	private int[] _startLoc = {10, 0};
	private ArrayList<String> task;
	private int[] _powerup = {7, 10};
	
	public int[] getPowerup() {
		return _powerup;
	}
	
	public EngRoom() {
		task = new ArrayList<String>();
	}
	
	public void addTask() {
		task.add("Engineering Room: Use 3D Printer");
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
	
	public void setMovedMaze() {
		_movedMaze[_p.getRow()][_p.getCol()] = 4;
	}
	
	public void setPath(int r, int c) {
		_maze[r][c] = 0;
	}
	
	
}
