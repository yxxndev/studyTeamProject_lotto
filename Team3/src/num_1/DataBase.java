package num_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;

public class DataBase {
	Map<String, ArrayList<UserSelectNum>> map = new HashMap();
	Map<String, JLabel[]> mapLbls = new HashMap();
	Map<String, JButton> mapCopy = new HashMap();

	public DataBase() {
		map.put("A", new ArrayList<UserSelectNum>());
		map.put("B", new ArrayList<UserSelectNum>());
		map.put("C", new ArrayList<UserSelectNum>());
		map.put("D", new ArrayList<UserSelectNum>());
		map.put("E", new ArrayList<UserSelectNum>());
		
		mapLbls.put("A", new JLabel[45]);
		mapLbls.put("B", new JLabel[45]);
		mapLbls.put("C", new JLabel[45]);
		mapLbls.put("D", new JLabel[45]);
		mapLbls.put("E", new JLabel[45]);

		mapCopy.put("A", new JButton());
		mapCopy.put("B", new JButton());
		mapCopy.put("C", new JButton());
		mapCopy.put("D", new JButton());
		mapCopy.put("E", new JButton());
	}

	public Map<String, ArrayList<UserSelectNum>> getMap() {
		return map;
	}
	
	public boolean allMarkingCheck() {
		boolean sizeCheck = true;
		for (ArrayList<UserSelectNum> list : map.values()) {
		    if (list.size() != 6) {
		    	sizeCheck = false;
		    }
		}
		return sizeCheck;
	}
}