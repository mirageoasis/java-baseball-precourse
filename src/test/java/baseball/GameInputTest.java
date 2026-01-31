package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GameInputTest {

	// 트림 기능 테스트
	@Test
	void readLine_trims_leading_and_trailing_spaces() {
		GameInput input = new GameInput() {
			@Override
			public String readLine() {
				return "  123  ";
			}
		};
		String result = input.readLine();
		assertEquals("123", result);
	}

	// 일반 입력 테스트
	@Test
	void readLine_returns_input_as_is() {
		GameInput input = new GameInput() {
			@Override
			public String readLine() {
				return "456";
			}
		};
		String result = input.readLine();
		assertEquals("456", result);
	}
}