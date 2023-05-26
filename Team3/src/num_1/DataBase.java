package num_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class DataBase {
	Map<String, ArrayList<UserSelectNum>> map = new HashMap();
	
	public DataBase() {
		map.put("A", new ArrayList<UserSelectNum>());
		map.put("B", new ArrayList<UserSelectNum>());
		map.put("C", new ArrayList<UserSelectNum>());
		map.put("D", new ArrayList<UserSelectNum>());
		map.put("E", new ArrayList<UserSelectNum>());
		
		add();
	}

	public Map<String, ArrayList<UserSelectNum>> getMap() {
		return map;
	}
	
	
//	연습할려고 만든 추가
	public void add() {
		map.get("A").add(new UserSelectNum(15, true));
		map.get("B").add(new UserSelectNum(15, true));
		map.get("C").add(new UserSelectNum(15, true));
		map.get("D").add(new UserSelectNum(15, true));
		map.get("E").add(new UserSelectNum(15, true));
	}
}
