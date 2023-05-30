package num_1;

// 유저가 선택한 넘버 객체
public class UserSelectNum {
	private int lotteryNum;
	private boolean auto;
	private boolean win;

	// 테스트 확인용 생성자
	public UserSelectNum(int lotteryNum, boolean auto) {
		this.lotteryNum = lotteryNum;
		this.auto = auto;
	}
	
	public UserSelectNum(int lotteryNum, boolean auto, boolean win) {
		this.lotteryNum = lotteryNum;
		this.auto = auto;
		this.win = win;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (auto ? 1231 : 1237);
		result = prime * result + lotteryNum;
		result = prime * result + (win ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserSelectNum other = (UserSelectNum) obj;
		if (lotteryNum != other.lotteryNum)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserSelectNum [lotteryNum=" + lotteryNum + ", auto=" + auto + ", win=" + win + "]";
	}

	public int getLotteryNum() {
		return lotteryNum;
	}

	public void setLotteryNum(int lotteryNum) {
		this.lotteryNum = lotteryNum;
	}

	public boolean isAuto() {
		return auto;
	}

	public void setAuto(boolean auto) {
		this.auto = auto;
	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}
	
	

}