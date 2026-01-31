package baseball;

import org.junit.jupiter.api.Test;

class HintResultModelTest {
	// 0볼 0스트라이크
	@Test
	void testNoBallsNoStrikes() {
		HintResultModel hint = new HintResultModel(0, 0);
		assert hint.toString().equals("낫싱");
	}

	// 0볼 1스트라이크
	@Test
	void testNoBallsOneStrike() {
		HintResultModel hint = new HintResultModel(1, 0);
		assert hint.toString().equals("1스트라이크");
	}

	// 0볼 2스트라이크
	@Test
	void testNoBallsTwoStrikes() {
		HintResultModel hint = new HintResultModel(2, 0);
		assert hint.toString().equals("2스트라이크");
	}

	// 1볼 0스트라이크
	@Test
	void testOneBallNoStrikes() {
		HintResultModel hint = new HintResultModel(0, 1);
		assert hint.toString().equals("1볼");
	}

	// 1스트라이크 1볼 (스트라이크 먼저)
	@Test
	void testOneBallOneStrike() {
		HintResultModel hint = new HintResultModel(1, 1);
		assert hint.toString().equals("1스트라이크 1볼");
	}

	// 2볼 0스트라이크
	@Test
	void testTwoBallsNoStrikes() {
		HintResultModel hint = new HintResultModel(0, 2);
		assert hint.toString().equals("2볼");
	}

	// 1스트라이크 2볼 (스트라이크 먼저)
	@Test
	void testTwoBallsOneStrike() {
		HintResultModel hint = new HintResultModel(1, 2);
		assert hint.toString().equals("1스트라이크 2볼");
	}

	// 3볼 0스트라이크
	@Test
	void testThreeBallsNoStrikes() {
		HintResultModel hint = new HintResultModel(0, 3);
		assert hint.toString().equals("3볼");
	}

	// 0볼 3스트라이크
	@Test
	void testNoBallsThreeStrikes() {
		HintResultModel hint = new HintResultModel(3, 0);
		assert hint.toString().equals("3스트라이크");
	}
}