package baseball;

public class HintResultModel {
	private final int strikes;
	private final int balls;

	public HintResultModel(int strikes, int balls) {
		this.strikes = strikes;
		this.balls = balls;
	}

	public int getStrikes() {
		return strikes;
	}

	@Override
	public String toString() {
		if (strikes == 0 && balls == 0)
			return "낫싱";
		StringBuilder sb = new StringBuilder();
		if (balls > 0)
			sb.append(balls).append("볼");
		if (strikes > 0) {
			if (sb.length() > 0)
				sb.append(" ");
			sb.append(strikes).append("스트라이크");
		}
		return sb.toString();
	}
}
