package mod;

import view.MapMaker;

/**
 * The Player class manages all the properties of a Player object, which include:
 *  - the row and column
 *  - the number of times the sanitizer was used
 *  - if the player has Covid
 *  - if the player has used the power-up
 *   
 * To keep track of what tasks are completed:
 *  - if player has mask
 *  - if player has sanitizer
 *  - if player has lunch
 *  - if player has used the 3D printer yet
 *  
 * The Player class also changes the player's position based on the maze 
 * (these methods are used in the LetterListener class).
 **/
public class Player {
	
	private int _row, _col; //ply row/col
	private int _numSani; //number of times sanitizer is used
	private boolean _hasCovid; //does ply have covid
	private boolean _hasPUp; //does ply have powerup
	
	//task 1
	private boolean _hasMask; //does ply have mask
	private boolean _hasSani; // does ply have sanitizer
	
	//task 2
	private boolean _hasLunch; 
	
	//task 3
	private boolean _3dprint;
	
	
	//gets positions
	public int getRow() { return _row; }
	public int getCol() { return _col; }
	 
	//sets positions
	public void setPos(int r, int c) { _row = r; _col = c; }
	
	//gets/sets num times sanitizer is used
	public int getNumSani() { return _numSani; }
	public void setNumSani(int n) { _numSani = n; }
	
	public boolean getLunch() { return _hasLunch; }
	public void setLunch(boolean n) { _hasLunch = n; }
	
	public boolean get3dprint() { return _3dprint; }
	public void set3dprint(boolean n) { _3dprint = n; }
	
	public boolean getSani() { return _hasSani; }
	public void setHasSani(boolean b) { _hasSani = b; }
	
	//gets/sets if ply has mask
	public boolean hasMask() { return _hasMask; }
	public void setHasMask(boolean b) { _hasMask = b; }
	
	//gets/sets if ply has covid
	public boolean hasCovid() { return _hasCovid; }
	public void setHasCovid(boolean b) { _hasCovid = b; }
	
	public boolean getPUp() { return _hasPUp; }
	public void setPUp(boolean b) { _hasPUp = b; }
	
	//creates PLayer object with parameters of row and column
	public Player(int startRow, int startCol) {
		_row = startRow;
		_col = startCol;
		_numSani = 0;
		_hasMask = false;
		_hasCovid = false;
		_hasSani = false;
		_hasPUp = false;
	}
	
	//creates Player object with no parameters
	public Player() {
		_row = getRow();
		_col = getCol();
		_numSani = 0;
		_hasCovid = false;
		_hasMask = false;
		_hasSani = false;
		_hasPUp = false;
	}
	
	//checks if all tasks are completed
	public boolean checkDone() {
		return (hasMask() && getSani() && get3dprint() && getLunch());	
	}
	
	//moves player north (controlled by LetterListener class)
	public void movePlyN(Classroom cr, int i, int j) { //moves ply North for "W"
		int r = i;
		int c = j;
		int[][] maze = cr.getMaze();
		
		if (r-1 >= 0 && maze[r - 1][c] != 1) {  
			setPos(r - 1, c); // move player's position
		} 
	}
	
	//moves player west (controlled by LetterListener class)
	public void movePlyW(Classroom cr, int i, int j) { //moves ply South for "S"
		int r = i;
		int c = j;
		int[][] maze = cr.getMaze();
		if (c - 1 >= 0 && maze[r][c - 1] != 1) {
			setPos(r, c-1);
		}
	}
	
	//moves player south (controlled by LetterListener class)
	public void movePlyS(Classroom cr, int i, int j) {  //moves ply South for "S"
		int r = i;
		int c = j;
		int[][] maze = cr.getMaze();
		int mRows = maze.length;
				
		if ((r + 1) < mRows && maze[r + 1][c] != 1) {
			setPos(r+1, c);
		}
	}
	
	//moves player east (controlled by LetterListener class)
	public void movePlyE(Classroom cr, int i, int j) { //moves ply East for "D"
		int r = i;
		int c = j;
		int[][] maze = cr.getMaze();
		int mCols = maze[0].length;
		
		if ((c + 1) < mCols && maze[r][c + 1] != 1) {
			setPos(r, c+1);
		}
	}
	
}
