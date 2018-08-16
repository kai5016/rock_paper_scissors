package jp.co.lesson.constant;

import java.util.List;

/**
 * アプリケーションが使用するメッセージを定義する列挙型
 * @author Kai
 *
 */
public enum AppMessage {

	/** じゃんけん開始メッセージ */
	RPS0001("じゃんけんはじめんで"),
	/** 参加者人数(人間)の入力指示メッセージ */
	RPS0002("人間の人数いれんかい"),
	/** 参加者人数(コンピュータ)の入力指示メッセージ */
	RPS0003("コンピュータの人数いれんかい"),
	/** 名前の入力指示メッセージ */
	RPS0004("プレイヤー{0}の名前を教えてや"),
	/** 手の入力指示メッセージ */
	RPS0005("{0}の手はなんや。次の数値を入力【0:ぐー、1:ぱー、2:ちょき】"),
	/** 勝者発表メッセージ */
	RPS0006("{0}が勝ったで"),
	/** あいこメッセージ */
	RPS0007("あいこやったで"),
	/** 場に出た手の出力メッセージ */
	RPS0008("{0}は{1}を出したで"),
	/** 不正な入力値メッセージ */
	RSP0009("不正な値いれんなや。もっかい入力して")
	;

	String message;

	private AppMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	/**
	 * プレースホルダ({0},{1},…)に文字列を代入して返却します。
	 * @param bindStr 代入する文字列リスト
	 * @return プレースホルダ置換後のメッセージ
	 */
	public String getMessage(List<String> bindStr) {
		if (bindStr == null || bindStr.isEmpty()) {
			return message;
		}

		String[] splittedMessage = message.split("\\{|\\}");
		StringBuffer sb = new StringBuffer();

		int bindIndex = 0;
		for (String messagePart: splittedMessage) {
			if (String.valueOf(bindIndex).equals(messagePart)) {
				sb.append(bindStr.get(bindIndex));
				bindIndex++;
			} else {
				sb.append(messagePart);
			}
		}

		return sb.toString();
	}

}
