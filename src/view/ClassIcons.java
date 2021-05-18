package view;

import javax.swing.ImageIcon;

import mod.Player;

public enum ClassIcons {
	
	PERSON("person.png"), WALL("school-desk.png"),
	PATH("school-path.png"), TASK("task.png"),
	TRACE("trace.png"), POWERUP("powerup.png"),
	PLYPOWER("plypower.png");
	
	private ImageIcon _img;
	private String _name; 
	private static Player _ply = new Player();
	
	public ImageIcon getImage() { return _img; }
	
	public static ImageIcon getPerson() {return ClassIcons.PERSON.getImage(); }
	public static ImageIcon getPath() { return ClassIcons.PATH.getImage(); }
	public static ImageIcon getWall() { return ClassIcons.WALL.getImage(); }
	public static ImageIcon getTask() { return ClassIcons.TASK.getImage(); }
	public static ImageIcon getTrace() { return ClassIcons.TRACE.getImage(); }
	public static ImageIcon getPowerup() { return ClassIcons.POWERUP.getImage(); }
	public static ImageIcon getPlyPower() { return ClassIcons.PLYPOWER.getImage(); }
	
	private ClassIcons(String name) {
		_name = name;
		_img = new ImageIcon(getClass().getResource(_name));
	}
	
}
