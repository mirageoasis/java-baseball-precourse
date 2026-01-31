package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class PlayerInputValidator {
	private final Scanner scanner = new Scanner(System.in);

	public String readLine() {
		return scanner.nextLine().trim();
	}

	public boolean isValidInput(String s) {
		if (s == null)
			return false;
		if (s.length() != 3)
			return false;
		HashSet<Character> set = new HashSet<>();
		for (char c : s.toCharArray()) {
			if (!Character.isDigit(c))
				return false;
			int d = c - '0';
			if (d < 1 || d > 9)
				return false;
			set.add(c);
		}
		return set.size() == 3;
	}

	/*
	 * 올바른 입력이 주어졌을 때만 호출되어야 합니다.
	 * */
	public List<Integer> toDigits(String s) {
		List<Integer> list = new ArrayList<>();
		for (char c : s.toCharArray())
			list.add(c - '0');
		return list;
	}
}
