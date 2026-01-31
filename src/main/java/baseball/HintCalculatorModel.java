package baseball;

import java.util.List;

public class HintCalculatorModel {
	public HintResultModel calculate(List<Integer> secret, List<Integer> guess) {
		int strikes = 0;
		int balls = 0;
		for (int i = 0; i < 3; i++) {
			if (guess.get(i).equals(secret.get(i))) {
				strikes++;
			} else if (secret.contains(guess.get(i))) {
				balls++;
			}
		}
		return new HintResultModel(strikes, balls);
	}
}
