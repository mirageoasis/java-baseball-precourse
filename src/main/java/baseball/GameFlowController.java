package baseball;

import java.util.List;

public class GameFlowController {
	private final SecretNumberModel secretModel = new SecretNumberModel();
	private final PlayerInputValidator playerInputValidator = new PlayerInputValidator();
	private final HintCalculatorModel hintModel = new HintCalculatorModel();
	private final GameResultView resultView = new GameResultView();

	public void start() {
		boolean running = true;
		while (running) {
			secretModel.generateSecret();
			List<Integer> secret = secretModel.getSecret();
			System.out.println("숫자의 값은: " + secretModel.getSecret());

			while (true) {
				System.out.println("서로 다른 3자리 숫자를 입력하세요 (각 자리 1-9):");
				String line = playerInputValidator.readLine();
				if (!playerInputValidator.isValidInput(line)) {
					resultView.showError("입력은 서로 다른 3개의 숫자(1-9)여야 합니다.");
					continue;
				}
				List<Integer> guess = playerInputValidator.toDigits(line);
				HintResult hint = hintModel.calculate(secret, guess);
				resultView.showHint(hint);
				if (hint.getStrikes() == 3) {
					resultView.showWinAndPromptRestart();
					boolean restart = askRestart();
					if (restart) {
						break;
					} else {
						running = false;
						break;
					}
				}
			}
		}
		System.out.println("게임을 종료합니다.");
	}

	private boolean askRestart() {
		while (true) {
			String choice = playerInputValidator.readLine();
			if ("1".equals(choice))
				return true;
			if ("2".equals(choice))
				return false;
			resultView.showError("1 또는 2만 입력 가능합니다.");
		}
	}
}
