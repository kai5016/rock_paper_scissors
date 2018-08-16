package jp.co.lesson.judge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.lesson.constant.Hands;

/**
 * じゃんけんで勝った手を判定する審判。
 * 審判はルールブック(マップ)を持っており、そのルールブックの定義によって勝った手を判定する。
 * @author Kai
 *
 */
public class RockPaperScissorsJudge {
	/** じゃんけんの3すくみを定義するマップ */
	private final Map<Hands, Hands> ruleMap;

	/**
	 * コンストラクタ
	 * @param shownHands
	 */
	public RockPaperScissorsJudge() {
		// 勝敗ルールをマップで定義(keyの手はvalueの手に勝つ)
		this.ruleMap = new HashMap<Hands, Hands>();
		ruleMap.put(Hands.ROCK, Hands.SCISSORS);
		ruleMap.put(Hands.SCISSORS, Hands.PAPER);
		ruleMap.put(Hands.PAPER, Hands.ROCK);
	}

	/**
	 * 勝敗を判定し、勝った手を返す。
	 * あいこのときはnullを返却する。
	 *
	 * @param shownHands
	 * @return 勝った手
	 */
	public Hands judge(List<Hands> shownHands) {
		List<Hands> distinctHands = getDistinctHands(shownHands);

		if (isDraw(distinctHands)) {
			return null;
		}

		if (distinctHands.contains(ruleMap.get(distinctHands.get(0)))) {
			return distinctHands.get(0);
		}

		return distinctHands.get(1);
	}

	/**
	 * 場の手から重複を削除した手のリストを返す
	 * @param shownHands
	 * @return
	 */
	private List<Hands> getDistinctHands(List<Hands> shownHands) {
		List<Hands> distinctHands = new ArrayList<Hands>();
		shownHands.stream().distinct().forEach(c -> distinctHands.add(c));

		return distinctHands;
	}

	/**
	 * あいこかどうか</br>
	 *
	 * @return
	 */
	private boolean isDraw(List<Hands> distinctHands) {
		if (distinctHands.size() == 1) {
			return true;
		}
		if (distinctHands.size() == Hands.values().length) {
			return true;
		}
		// あいこは手が１種類か全種類か
		// 上記以外はあいこではない
		return false;
	}
}
