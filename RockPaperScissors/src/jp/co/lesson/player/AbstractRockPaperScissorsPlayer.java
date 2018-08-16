/**
 *
 */
package jp.co.lesson.player;

import jp.co.lesson.constant.Hands;

/**
 * @author Kai
 *
 */
public abstract class AbstractRockPaperScissorsPlayer {
	private String name;
	private Hands hand;
	private boolean isWinner;
	private int totalWinCount;

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return hand
	 */
	public Hands getHand() {
		return hand;
	}
	/**
	 * @param hand セットする hand
	 */
	public void setHand(Hands hand) {
		this.hand = hand;
	}
	/**
	 * @return isWinner
	 */
	public boolean isWinner() {
		return isWinner;
	}
	/**
	 * @param isWinner セットする isWinner
	 */
	public void setWinner(boolean isWinner) {
		this.isWinner = isWinner;
	}
	/**
	 * @return totalWinCount
	 */
	public int getTotalWinCount() {
		return totalWinCount;
	}
	/**
	 * totalWinCountをインクリメントする
	 */
	public void increaseTotalWinCount() {
		totalWinCount++;
	}

	/**
	 * @param totalWinCount セットする totalWinCount
	 */
	public void setTotalWinCount(int totalWinCount) {
		this.totalWinCount = totalWinCount;
	}

	/**
	 * じゃんけんの手を出す
	 */
	abstract public void showHand();

	/**
	 * プレイヤーの名前を取得する
	 */
	abstract public void givePlayerName();
}
