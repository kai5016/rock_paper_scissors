/**
 *
 */
package jp.co.lesson.player;

import java.util.Arrays;

import jp.co.lesson.constant.AppMessage;
import jp.co.lesson.constant.Hands;
import jp.co.lesson.util.AppIOUtil;
import jp.co.lesson.util.AppStringUtil;

/**
 * @author Kai
 *
 */
public class RockPaperScissorsPlayer extends AbstractRockPaperScissorsPlayer {
	static public int playerCount = 0;
	private int id;

	public RockPaperScissorsPlayer() {
		playerCount++;
		id = playerCount;
	}

	/* (非 Javadoc)
	 * @see jp.co.lesson.AbstractRockPaperScissorsPlayer#showHand()
	 */
	@Override
	public void showHand() {
		AppIOUtil.dispMessage(AppMessage.RPS0005.getMessage(Arrays.asList(getName())));

		Hands hand = null;
		int input = -1;
		do {
			try {
				input = AppIOUtil.getUserInputAsNumber();
				hand = Hands.getByCode(input);
			} catch (Exception e) {
				AppIOUtil.dispMessage("次の数値を入力してください【0:ぐー、1:ぱー、2:ちょき】");
			}
		} while (hand == null);

		setHand(hand);
	}

	/* (非 Javadoc)
	 * @see jp.co.lesson.AbstractRockPaperScissorsPlayer#givePlayerName()
	 */
	@Override
	public void givePlayerName() {
		AppIOUtil.dispMessage(
				AppMessage.RPS0004.getMessage(Arrays.asList(String.valueOf(id))));
		String name = null;
		do {
			try {
				name = AppIOUtil.getUserInputAsString();
			} catch (Exception e) {
				AppIOUtil.dispMessage("再度入力してください");
			}
		} while (AppStringUtil.isEmpty(name));

		setName(name);
	}
}
