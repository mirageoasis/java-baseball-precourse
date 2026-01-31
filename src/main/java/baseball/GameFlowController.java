package baseball;

import java.util.List;

public class GameFlowController {
	private final SecretNumberModel secretModel = new SecretNumberModel();
	private final PlayerInputValidator playerInputValidator = new PlayerInputValidator();
	private final HintCalculatorModel hintModel = new HintCalculatorModel();
	private final GameOutput gameOutput = new GameOutput();
	private final GameInput gameInput = new GameInput();

	private boolean askRestart() {
		while (true) {
			String choice = gameInput.readLine();
			if ("1".equals(choice))
				return true;
			if ("2".equals(choice))
				return false;
			gameOutput.showError("1 또는 2만 입력 가능합니다.");
		}
	}

	public void start() {
		boolean running = true;
		while (running) {
			secretModel.generateSecret();
			List<Integer> secret = secretModel.getSecret();

			while (true) {
				gameOutput.showPromptForGuess();
				String line = gameInput.readLine();
				if (!playerInputValidator.isValidInput(line)) {
					gameOutput.showError("입력은 서로 다른 3개의 숫자(1-9)여야 합니다.");
					continue;
				}
				List<Integer> guess = playerInputValidator.toDigits(line);
				HintResultModel hint = hintModel.calculate(secret, guess);
				gameOutput.showHint(hint);
				if (hint.getStrikes() == 3) {
					gameOutput.showWinAndPromptRestart();
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
		gameOutput.showExitMessage();
	}
}
