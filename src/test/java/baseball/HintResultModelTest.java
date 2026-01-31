package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class HintResultModelTest {
	// 0볼 0스트라이크
	@Test
	void testNoBallsNoStrikes() {
		HintResultModel hint = new HintResultModel(0, 0);
		assertEquals("낫싱", hint.toString());
	}

	// 0볼 1스트라이크
	@Test
	void testNoBallsOneStrike() {
		HintResultModel hint = new HintResultModel(1, 0);
		assertEquals("1스트라이크", hint.toString());
	}

	// 0볼 2스트라이크
	@Test
	void testNoBallsTwoStrikes() {
		HintResultModel hint = new HintResultModel(2, 0);
		assertEquals("2스트라이크", hint.toString());
	}

	// 1볼 0스트라이크
	@Test
	void testOneBallNoStrikes() {
		HintResultModel hint = new HintResultModel(0, 1);
		assertEquals("1볼", hint.toString());
	}

	// 1스트라이크 1볼 (스트라이크 먼저)
	@Test
	void testOneBallOneStrike() {
		HintResultModel hint = new HintResultModel(1, 1);
		assertEquals("1스트라이크 1볼", hint.toString());
	}

	// 2볼 0스트라이크
	@Test
	void testTwoBallsNoStrikes() {
		HintResultModel hint = new HintResultModel(0, 2);
		assertEquals("2볼", hint.toString());
	}

	// 1스트라이크 2볼 (스트라이크 먼저)
	@Test
	void testTwoBallsOneStrike() {
		HintResultModel hint = new HintResultModel(1, 2);
		assertEquals("1스트라이크 2볼", hint.toString());
	}

	// 3볼 0스트라이크
	@Test
	void testThreeBallsNoStrikes() {
		HintResultModel hint = new HintResultModel(0, 3);
		assertEquals("3볼", hint.toString());
	}

	// 0볼 3스트라이크
	@Test
	void testNoBallsThreeStrikes() {
		HintResultModel hint = new HintResultModel(3, 0);
		assertEquals("3스트라이크", hint.toString());
	}
}