package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameOutputTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private GameOutput view;

	@BeforeEach
	void setUp() {
		System.setOut(new PrintStream(outContent));
		view = new GameOutput();
		outContent.reset();
	}

	@AfterEach
	void tearDown() {
		System.setOut(originalOut);
	}

	@Test
	void showHint_prints_nothing_when_no_match() {
		view.showHint(new HintResultModel(0, 0));
		assertEquals("낫싱\n", outContent.toString());
	}

	@Test
	void showHint_prints_ball_and_strike() {
		view.showHint(new HintResultModel(2, 1));
		assertEquals("2스트라이크 1볼\n", outContent.toString());
	}

	@Test
	void showError_prefixes_message_with_error_tag() {
		view.showError("입력 오류");
		assertEquals("[ERROR] 입력 오류\n", outContent.toString());
	}

	@Test
	void showWinAndPromptRestart_prints_two_lines() {
		view.showWinAndPromptRestart();
		String output = outContent.toString();
		assertTrue(output.contains("3스트라이크! 승리했습니다."));
		assertTrue(output.contains("게임을 재시작하려면 1, 종료하려면 2를 입력하세요."));
	}
}
