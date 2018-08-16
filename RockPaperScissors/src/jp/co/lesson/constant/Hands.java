package jp.co.lesson.constant;

import java.util.Arrays;

/**
 * じゃんけんにおける手の列挙型
 * @author Kai
 *
 */
public enum Hands {
	/** ぐー */
	ROCK(0, "ぐー"),
	/** ぱー */
	PAPER(1, "ぱー"),
	/** ちょき */
	SCISSORS(2, "ちょき"),
	;

	private int code;
	private String name;

	private Hands(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return this.code;
	}

	public String getName() {
		return this.name;
	}

	public static Hands getByCode(int code) {
		return Arrays.stream(Hands.values()).
				filter(data -> data.getCode() == code).
				findFirst().
				orElse(null);
	}

}
