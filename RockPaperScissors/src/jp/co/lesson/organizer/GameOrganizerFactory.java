package jp.co.lesson.organizer;

/**
 * メイン処理において必要となる主催者(GameOrganizer)の実装クラスの
 * インスタンスを生成し返却する。
 *
 * @author Kai
 *
 */
public class GameOrganizerFactory {

	/**
	 * GameOrganizerインスタンスを生成し返却する。
	 *
	 * @return GameOrganizerインスタンス
	 */
	public GameOrganizer newInstance() {
		return new RockPaperScissorsOrganizer();

		// ↑の処理だけ切り出して何が嬉しいのかと思うかもしれないが、
		// それは１つしかGameOrganizerの実装クラスがないため。
		// 今後GameOrganizerの実装クラスが増えたら、newInstance() に引数かなんか追加して
		// if-else, switch文で必要なインスタンスを返却するようにする。
		// (ex)
		// public GameOrganizer newInstance(String camSyb) {
		//    // 引数のcamSybによって返却するインスタンスを変える
		//    if (camSyb.equals("HOGE")) {
		//        return new HogeGameOrganizer();
		//    } else if (camSyb.equals("HIGE")) {
		//        return new HigeGameOrganizer();
		//    } ……
		// }
	}
}
