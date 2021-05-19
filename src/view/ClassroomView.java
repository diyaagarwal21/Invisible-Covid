package view;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class is the parent class for all the locations of TERRA (for the GUI). 
 * It creates the JPanels with the maze for each classroom location. 
 */
public class ClassroomView {
	
	private JPanel _pan;
	private JLabel _task;
	private JButton _one, _two, _three;
	
	public JPanel getPan() {
		return _pan;
	}
	
	public JLabel getTask() {
		return _task;
	}
	
	
	
}
