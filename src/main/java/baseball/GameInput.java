package baseball;

import java.util.Scanner;

public class GameInput {

	private final Scanner scanner;

	public GameInput(Scanner scanner) {
		this.scanner = scanner;
	}

	public String readLine() {
		return scanner.nextLine().strip();
	}
}
