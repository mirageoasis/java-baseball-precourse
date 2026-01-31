package baseball;

import java.util.List;

public class HintCalculatorModel {
	public HintResult calculate(List<Integer> secret, List<Integer> guess) {
		int strikes = 0;
		int balls = 0;
		for (int i = 0; i < 3; i++) {
			if (guess.get(i).equals(secret.get(i))) {
				strikes++;
			} else if (secret.contains(guess.get(i))) {
				balls++;
			}
		}
		return new HintResult(strikes, balls);
	}
}
