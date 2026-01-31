package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SecretNumberModel {
	private List<Integer> secret = new ArrayList<>();

	public void generateSecret() {
		List<Integer> pool = new ArrayList<>();
		for (int i = 1; i <= 9; i++)
			pool.add(i);
		Collections.shuffle(pool);
		secret = new ArrayList<>(pool.subList(0, 3));
	}

	public List<Integer> getSecret() {
		return new ArrayList<>(secret);
	}
}
