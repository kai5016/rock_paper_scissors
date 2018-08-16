package jp.co.lesson.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * ゲームの処理とは直接関係ない入出力操作を
 * ユーティリティクラスとして持たせる。
 * 入出力操作の必要に応じて当クラスのクラスメソッドを追加すること。
 * @author Kai
 *
 */
public class AppIOUtil {

	/**
	 * 標準入力された値を文字列として返却します。
	 * @return
	 * @throws Exception
	 */
	public static String getUserInputAsString() throws Exception {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			return br.readLine();
		} catch(Exception e) {
			dispMessage("入力値が不正です。再度入力してください。");
			throw e;
		}
	}

	/**
	 * 標準入力された値を数値として返却します
	 * @return
	 * @throws Exception
	 */
	public static int getUserInputAsNumber() throws Exception {
		try {
			String line = getUserInputAsString();

			return Integer.parseInt(line);
		} catch (Exception e) {
			dispMessage("入力値を数値に変換できません。再度入力してください。");
			throw e;
		}
	}

	/**
	 * メッセージを表示します
	 * @param message
	 */
	public static void dispMessage(String message) {
		System.out.println(message);
	}

}
