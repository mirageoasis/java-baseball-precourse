package baseball;

import java.util.List;

import org.junit.jupiter.api.Test;

class HintCalculatorModelTest {
	/*
	* public HintResultModel calculate(List<Integer> secret, List<Integer> guess) {
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
	* */

	private final HintCalculatorModel hintCalculator = new HintCalculatorModel();

	// 1. 모든 숫자가 일치하는 경우 (3 스트라이크, 0 볼)
	@Test
	void calculate_all_match() {
		HintResultModel result = hintCalculator.calculate(
			List.of(1, 2, 3),
			List.of(1, 2, 3)
		);
		assert result.getStrikes() == 3;
		assert result.toString().equals("3스트라이크");
	}

	// 2. 일부 숫자가 위치까지 일치하는 경우 (예: 2 스트라이크, 0 볼)
	@Test
	void calculate_partial_strike_match() {
		HintResultModel result = hintCalculator.calculate(
			List.of(1, 2, 3),
			List.of(1, 2, 4)
		);
		assert result.getStrikes() == 2;
		assert result.toString().equals("2스트라이크");
	}

	@Test
	void calculate_partial_strike_match_2() {
		HintResultModel result = hintCalculator.calculate(
			List.of(4, 5, 6),
			List.of(4, 7, 6)
		);
		assert result.getStrikes() == 2;
		assert result.toString().equals("2스트라이크");
	}

	@Test
	void calculate_partial_strike_match_3() {
		HintResultModel result = hintCalculator.calculate(
			List.of(7, 8, 9),
			List.of(0, 8, 9)
		);
		assert result.getStrikes() == 2;
		assert result.toString().equals("2스트라이크");
	}

	// 3. 일부 숫자가 위치는 다르지만 포함되는 경우 (예: 0 스트라이크, 2 볼)
	@Test
	void calculate_partial_ball_match() {
		HintResultModel result = hintCalculator.calculate(
			List.of(1, 2, 3),
			List.of(3, 1, 4)
		);
		assert result.getStrikes() == 0;
		assert result.toString().equals("2볼");
	}

	@Test
	void calculate_partial_ball_match_2() {
		HintResultModel result = hintCalculator.calculate(
			List.of(4, 5, 6),
			List.of(6, 4, 7)
		);
		assert result.getStrikes() == 0;
		assert result.toString().equals("2볼");
	}

	// 4. 숫자가 전혀 일치하지 않는 경우 (0 스트라이크, 0 볼)
	@Test
	void calculate_no_match() {
		HintResultModel result = hintCalculator.calculate(
			List.of(1, 2, 3),
			List.of(4, 5, 6)
		);
		assert result.getStrikes() == 0;
		assert result.toString().equals("낫싱");
	}

	@Test
	void calculate_no_match_2() {
		HintResultModel result = hintCalculator.calculate(
			List.of(7, 8, 9),
			List.of(1, 2, 3)
		);
		assert result.getStrikes() == 0;
		assert result.toString().equals("낫싱");
	}

}