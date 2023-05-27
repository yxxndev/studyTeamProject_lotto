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

//		resultTest();
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

	// Result 테스트용
	public void resultTest() {
		UserSelectNum a1 = new UserSelectNum(1, false);
		UserSelectNum a2 = new UserSelectNum(2, false);
		UserSelectNum a3 = new UserSelectNum(3, false);
		UserSelectNum a4 = new UserSelectNum(4, true);
		UserSelectNum a5 = new UserSelectNum(5, true);
		UserSelectNum a6 = new UserSelectNum(6, true);
		ArrayList<UserSelectNum> a = new ArrayList<UserSelectNum>();
		a.add(a1);
		a.add(a2);
		a.add(a3);
		a.add(a4);
		a.add(a5);
		a.add(a6);

		map.put("A", a);
	}
}
