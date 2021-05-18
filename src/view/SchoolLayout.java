package view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import mod.Classroom;
import mod.Courtyard;
import mod.EngRoom;
import mod.Lobby;
import mod.Player;

public class SchoolLayout {
	
	private JPanel _pan;
	private MapMaker _mm;
	private Classroom _c;
	private Player _p;
	
	private ArrayList<Classroom> _lst;
	
	public SchoolLayout() {
		_c = new Lobby();
		_p = new Player();
		_mm = new MapMaker(_c, _p);
		initPan();
		makeLayout();
	}
	
	public void initPan() {
		_pan = new JPanel(new GridLayout(1,1));
		_lst = new ArrayList<Classroom>();
		_lst.add(new Lobby());
		_lst.add(new Courtyard());
		_lst.add(new EngRoom());	
	}
	
	public void makeLayout() {
		//for(int i = 0; i < _lst.size(); i++) {
			_pan.add(new JButton(_lst.get(0).getImg()));
		//}
	}
	
	public JPanel getPan() { return _pan; }
	
	
}
