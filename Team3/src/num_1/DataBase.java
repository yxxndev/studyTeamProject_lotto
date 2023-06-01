package num_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;

public class DataBase {
	Map<String, ArrayList<UserSelectNum>> map = new HashMap();
	Map<String, JLabel[]> mapCMR = new HashMap();

	public DataBase() {
		map.put("A", new ArrayList<UserSelectNum>());
		map.put("B", new ArrayList<UserSelectNum>());
		map.put("C", new ArrayList<UserSelectNum>());
		map.put("D", new ArrayList<UserSelectNum>());
		map.put("E", new ArrayList<UserSelectNum>());

		mapCMR.put("A", new JLabel[45]);
		mapCMR.put("B", new JLabel[45]);
		mapCMR.put("C", new JLabel[45]);
		mapCMR.put("D", new JLabel[45]);
		mapCMR.put("E", new JLabel[45]);
		
//		add();

//		resultTest();
	}

	public Map<String, ArrayList<UserSelectNum>> getMap() {
		return map;
	}

////	연습할려고 만든 추가
//	public void add() {
//		map.get("A").add(new UserSelectNum(15, true));
//		map.get("B").add(new UserSelectNum(15, true));
//		map.get("C").add(new UserSelectNum(15, true));
//		map.get("D").add(new UserSelectNum(15, true));
//		map.get("E").add(new UserSelectNum(15, true));
//	}
//
//	// Result 테스트용
//	public void resultTest() {
//		UserSelectNum a1 = new UserSelectNum(1, false);
//		UserSelectNum a2 = new UserSelectNum(2, false);
//		UserSelectNum a3 = new UserSelectNum(3, false);
//		UserSelectNum a4 = new UserSelectNum(4, true);
//		UserSelectNum a5 = new UserSelectNum(5, true);
//		UserSelectNum a6 = new UserSelectNum(6, true);
//		ArrayList<UserSelectNum> a = new ArrayList<UserSelectNum>();
//		a.add(a1);
//		a.add(a2);
//		a.add(a3);
//		a.add(a4);
//		a.add(a5);
//		a.add(a6);
//
//		map.put("A", a);
//	}
	
	// LotteryConfirmation 클래스 테스트용
	public void printNumTest() {
//		map.get("A").add(new UserSelectNum(1, true, false));
//		map.get("A").add(new UserSelectNum(11, true, true));
//		map.get("A").add(new UserSelectNum(21, true, false));
//		map.get("A").add(new UserSelectNum(31, true, true));
//		map.get("A").add(new UserSelectNum(33, false, true));
//		map.get("A").add(new UserSelectNum(41, true, false));
		map.get("B").add(new UserSelectNum(2, true, false));
		map.get("B").add(new UserSelectNum(12, true, true));
		map.get("B").add(new UserSelectNum(22, true, false));
		map.get("B").add(new UserSelectNum(33, true, true));
		map.get("B").add(new UserSelectNum(34, false, true));
		map.get("B").add(new UserSelectNum(42, true, false));
		map.get("C").add(new UserSelectNum(3, true, false));
		map.get("C").add(new UserSelectNum(13, true, true));
		map.get("C").add(new UserSelectNum(23, true, false));
		map.get("C").add(new UserSelectNum(33, true, true));
		map.get("C").add(new UserSelectNum(34, false, true));
		map.get("C").add(new UserSelectNum(43, true, false));
		map.get("D").add(new UserSelectNum(4, true, false));
		map.get("D").add(new UserSelectNum(14, true, true));
		map.get("D").add(new UserSelectNum(24, true, false));
		map.get("D").add(new UserSelectNum(34, true, true));
		map.get("D").add(new UserSelectNum(37, false, true));
		map.get("D").add(new UserSelectNum(44, true, false));
		map.get("E").add(new UserSelectNum(5, true, false));
		map.get("E").add(new UserSelectNum(15, true, true));
		map.get("E").add(new UserSelectNum(25, true, false));
		map.get("E").add(new UserSelectNum(35, true, true));
		map.get("E").add(new UserSelectNum(37, false, true));
		map.get("E").add(new UserSelectNum(45, true, false));
	}
}
