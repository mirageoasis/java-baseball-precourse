package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class GameInputTest {

	// 트림 기능 테스트
	@Test
	void readLine_trims_leading_and_trailing_spaces() {
		Scanner scanner = new Scanner("  123  ");
		GameInput input = new GameInput(scanner);

		String result = input.readLine();
		assertEquals("123", result);
	}

	// 일반 입력 테스트
	@Test
	void readLine_returns_input_as_is() {
		Scanner scanner = new Scanner("456");
		GameInput input = new GameInput(scanner);
		String result = input.readLine();
		assertEquals("456", result);
	}
}