package baseball;

public class GameResultModel {
	
	public void showHint(HintResultModel result) {
		System.out.println(result.toString());
	}

	public void showError(String message) {
		System.out.println("[ERROR] " + message);
	}

	public void showWinAndPromptRestart() {
		System.out.println("3스트라이크! 승리했습니다.");
		System.out.println("게임을 재시작하려면 1, 종료하려면 2를 입력하세요.");
	}

	public void showPromptForGuess() {
		System.out.println("서로 다른 3자리 숫자를 입력하세요 (각 자리 1-9):");
	}

	public void showExitMessage() {
		System.out.println("게임을 종료합니다.");
	}
}
