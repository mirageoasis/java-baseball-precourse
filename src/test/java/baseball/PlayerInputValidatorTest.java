package baseball;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PlayerInputValidatorTest {
	private final PlayerInputValidator validator = new PlayerInputValidator();

	//    - null 입력 -> false 반환
	@Test
	void testIsValidInput_NullInput() {
		assertFalse(validator.isValidInput(null));
	}

	//    - 길이 3이 아닌 입력 (예: "12", "12333", "1234") -> false 반환
	@Test
	void testIsValidInput_InvalidLength() {
		assertFalse(validator.isValidInput("12"));
		assertFalse(validator.isValidInput("12333"));
		assertFalse(validator.isValidInput("1234"));
	}

	//    - 숫자가 아닌 문자 포함 (예: "1a3", "12!")
	@Test
	void testIsValidInput_NonDigitCharacters() {
		assertFalse(validator.isValidInput("1a3"));
	}

	//    - 1-9 범위 밖의 숫자 포함 (예: "023", "1450")
	@Test
	void testIsValidInput_OutOfRangeNumbers() {
		assertFalse(validator.isValidInput("023"));
		assertFalse(validator.isValidInput("1450"));
	}

	//    - 중복된 숫자 포함 (예: "112", "121")
	@Test
	void testIsValidInput_DuplicateNumbers() {
		assertFalse(validator.isValidInput("112"));
		assertFalse(validator.isValidInput("121"));
	}

	//    - 올바른 입력 (예: "123", "987") -> true
	@Test
	void testIsValidInput_ValidInput() {
		assertTrue(validator.isValidInput("123"));
		assertTrue(validator.isValidInput("987"));
	}

}