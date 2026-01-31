package baseball;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SecretNumberModelTest {
	@Test
	void testGenerateSecret() {
		SecretNumberModel model = new SecretNumberModel();
		model.generateSecret();
		// 테스트 코드는 여기에서 작성합니다.
		// 예: 비어 있지 않은지, 3자리 숫자인지, 중복이 없는지 등을 확인할 수 있습니다.

		List<Integer> test = model.getSecret();
		Assertions.assertEquals(3, test.size(), "시크릿 넘버는 3자리여야 합니다.");
		for (Integer integer : test) {
			Assertions.assertNotNull(integer, "시크릿 넘버의 각 자리는 null이 될 수 없습니다.");
			Assertions.assertTrue(0 < integer && integer < 10, "시크릿 넘버의 각 자리는 한 자리 자연수여야 합니다.");
		}
		for (int i = 0; i < test.size(); i++) {
			for (int j = i + 1; j < test.size(); j++) {
				Assertions.assertNotEquals(test.get(i), test.get(j), "시크릿 넘버의 각 자리는 서로 달라야 합니다.");
			}
		}
	}
}