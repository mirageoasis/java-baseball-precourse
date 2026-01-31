package baseball;

public class GameResultView {
	public void showHint(HintResult result) {
		System.out.println(result.toString());
	}

	public void showError(String message) {
		System.out.println("[ERROR] " + message);
	}

	public void showWinAndPromptRestart() {
		System.out.println("3스트라이크! 승리했습니다.");
		System.out.println("게임을 재시작하려면 1, 종료하려면 2를 입력하세요.");
	}
}
