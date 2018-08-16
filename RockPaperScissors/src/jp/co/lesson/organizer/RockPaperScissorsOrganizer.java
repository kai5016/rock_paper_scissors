package jp.co.lesson.organizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jp.co.lesson.constant.AppMessage;
import jp.co.lesson.constant.Hands;
import jp.co.lesson.judge.RockPaperScissorsJudge;
import jp.co.lesson.player.AbstractRockPaperScissorsPlayer;
import jp.co.lesson.player.RockPaperScissorsNonePlayer;
import jp.co.lesson.player.RockPaperScissorsPlayer;
import jp.co.lesson.util.AppIOUtil;

/**
 * じゃんけんの主催者クラス。
 *
 * @author Kai
 *
 */
public class RockPaperScissorsOrganizer implements GameOrganizer {

	/** 参加者リスト */
	private List<AbstractRockPaperScissorsPlayer> players;

	/**
	 * @return players
	 */
	public List<AbstractRockPaperScissorsPlayer> getPlayers() {
		return players;
	}

	/**
	 * @param players セットする players
	 */
	public void setPlayers(List<AbstractRockPaperScissorsPlayer> players) {
		this.players = players;
	}

	/**
	 * @param players セットする players
	 */
	public void addPlayers(AbstractRockPaperScissorsPlayer player) {
		this.players.add(player);
	}

	@Override
	public void dispMenu() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void initGame() {
		AppIOUtil.dispMessage(AppMessage.RPS0001.getMessage());

		AppIOUtil.dispMessage(AppMessage.RPS0002.getMessage());
		int playerCount = getPlayersCount();

		AppIOUtil.dispMessage(AppMessage.RPS0003.getMessage());
		int nonePlayerCount = getPlayersCount();

		List<AbstractRockPaperScissorsPlayer> players =
				new ArrayList<AbstractRockPaperScissorsPlayer>(playerCount + nonePlayerCount);

		// 人間の参加者のインスタンスを参加者リストに追加
		for(int i = 0; i < playerCount; i++) {
			players.add(new RockPaperScissorsPlayer());
		}
		// コンピュータの参加者のインスタンスを参加者リストに追加
		for(int i = 0; i < nonePlayerCount; i++) {
			players.add(new RockPaperScissorsNonePlayer());
		}

		// 参加者の名前を設定
		players.forEach(player -> player.givePlayerName());

		// 参加者リストをセット
		setPlayers(players);
	}

	@Override
	public void excecuteGame() {
		Hands winnerHand = doRockPaperScissors();

		StringBuffer winnerNames = new StringBuffer();
		players.stream().filter(player -> player.getHand() == winnerHand).
			forEach(player -> {
				winnerNames.append(player.getName() + " ");
				player.setWinner(true);
				player.increaseTotalWinCount();
			});

		AppIOUtil.dispMessage(AppMessage.RPS0006.getMessage(
				Arrays.asList(winnerNames.toString())));
	}

	@Override
	public void endGame() {
		// TODO 自動生成されたメソッド・スタブ

	}

	/**
	 * じゃんけんの実行処理
	 * @return
	 */
	private Hands doRockPaperScissors() {
		RockPaperScissorsJudge judge = new RockPaperScissorsJudge();
		Hands winnerHand = null;

		do {
			List<Hands> shownHands = new ArrayList<Hands>();

			// みんな手を出す
			players.forEach(player -> {
				player.showHand();
				shownHands.add(player.getHand());
			});

			// 出た手の発表
			players.forEach(player -> {
				AppIOUtil.dispMessage(AppMessage.RPS0008.getMessage(
						Arrays.asList(player.getName(),player.getHand().getName())));

			});
			// 勝った手を判定
			winnerHand = judge.judge(shownHands);

			if (winnerHand == null) {
				// judge後winnerHand==nullの場合はあいこ
				AppIOUtil.dispMessage(AppMessage.RPS0007.getMessage());
			}
		// 勝負がつくまでやり直し
		} while(winnerHand == null);

		return winnerHand;
	}

	private int getPlayersCount() {
		int playersCount = -1;
		do {
			try {
				playersCount = AppIOUtil.getUserInputAsNumber();
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (playersCount < 0) {
				AppIOUtil.dispMessage(AppMessage.RSP0009.getMessage());
			}
		} while (playersCount < 0);

		return playersCount;
	}
}
