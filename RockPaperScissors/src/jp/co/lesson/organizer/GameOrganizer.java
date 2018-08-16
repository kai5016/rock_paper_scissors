package jp.co.lesson.organizer;

/**
 * ゲームの主催者が実装すべき機能を定義する。
 * @author Kai
 *
 */
public interface GameOrganizer {

	/**
	 * ゲーム開始前のメニュー表示をします
	 */
	void dispMenu();

	/**
	 * ゲームの開始に必要なデータ準備処理
	 */
	void initGame();

	/**
	 * ゲームの実行処理
	 */
	void excecuteGame();

	/**
	 * ゲームの終了処理(データのクリアなど片付け処理)
	 */
	void endGame();
}
