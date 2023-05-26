package num_1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class DataBase {
	Map<String, HashSet<UserSelectNum>> map = new HashMap();
	
	public DataBase() {
		map.put("A", new HashSet<UserSelectNum>());
		map.put("B", new HashSet<UserSelectNum>());
		map.put("C", new HashSet<UserSelectNum>());
		map.put("D", new HashSet<UserSelectNum>());
		map.put("E", new HashSet<UserSelectNum>());
	}

	public Map<String, HashSet<UserSelectNum>> getMap() {
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
