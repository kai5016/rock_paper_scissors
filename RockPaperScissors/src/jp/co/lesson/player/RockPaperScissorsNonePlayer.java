/**
 *
 */
package jp.co.lesson.player;

import java.util.Random;

import jp.co.lesson.constant.Hands;

/**
 * コンピュータのじゃんけん参加者クラス。
 *
 * @author Kai
 */
public class RockPaperScissorsNonePlayer extends AbstractRockPaperScissorsPlayer {

	private int id;
	static public int nonePlayerCount = 0;

	public RockPaperScissorsNonePlayer() {
		nonePlayerCount++;
		id = nonePlayerCount;
	}
	/* (非 Javadoc)
	 * @see jp.co.lesson.AbstractRockPaperScissorsPlayer#showHand()
	 */
	@Override
	public void showHand() {
		// 乱数で手を生成して手とする
		int hand = new Random().nextInt(Hands.values().length);
		super.setHand(Hands.getByCode(hand));
	}

	/* (非 Javadoc)
	 * @see jp.co.lesson.AbstractRockPaperScissorsPlayer#givePlayerName()
	 */
	@Override
	public void givePlayerName() {
		setName("コンピュータ" + id);
	}

}
