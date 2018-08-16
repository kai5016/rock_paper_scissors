package jp.co.lesson.util;

/**
 * ゲームの処理とは直接関係ない文字列操作を
 * ユーティリティクラスとして持たせる。
 * 文字列操作の必要に応じて当クラスのクラスメソッドを追加すること。
 * @author Kai
 *
 */
public class AppStringUtil {

	/**
	 * 引数の文字列がnull, または空文字の場合trueを返却
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}
		return false;
	}

}
