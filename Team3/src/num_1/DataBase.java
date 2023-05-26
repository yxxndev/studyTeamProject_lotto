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
	
}
