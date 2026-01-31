package baseball;

import java.util.Scanner;

public class GameInput {

	private final Scanner scanner;

	public GameInput() {
		this.scanner = new Scanner(System.in);
	}

	public String readLine() {
		return scanner.nextLine().trim();
	}
}
