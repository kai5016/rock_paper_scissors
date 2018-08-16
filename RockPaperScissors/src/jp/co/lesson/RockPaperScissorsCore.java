package jp.co.lesson;

import jp.co.lesson.organizer.GameOrganizer;
import jp.co.lesson.organizer.GameOrganizerFactory;

public class RockPaperScissorsCore {

	public static void main(String[] args) {
		// ＜前置き＞
		// オブジェクト指向プログラミングでは、
		// できるだけクラス間の依存度を下げることを検討する
		// メイン処理の中に具体的なじゃんけん処理(=ビジネスロジック)を書かない。
		// 今後じゃんけん以外のゲームを追加しようとした際に邪魔になる。
		//
		// いつぞやの帰り道で話した"オブジェクトの責務"の話。
		//
		// 今回の実装では以下の責務を定義した。
		// ■主催(取り仕切り役)
		// ゲームの進行役。
		// 進行に必要な情報の取得、出力等を行う
		//
		// 格納package: organizer
		//
		// ■プレイヤー(参加者)
		// ゲーム参加者。
		// じゃんけんに参加する人として必要な属性、処理をもつ。
		// 具体的には、名前/手を属性としてもち、
		// 自分の出す手を決定する、という処理をもつ。
		//
		// 格納packege: player
		//
		// ■審判
		// プレイヤーが出した手から、どの手が勝ったかを判定する。
		//
		// 格納packege: judge
		//
		// ＜じゃんけん以外の話＞
		// 今後じゃんけん以外のゲームを実装することを想定し、
		// ゲーム実装におけるインタフェース（GameOrganizer）を用意し、
		// ゲーム実装に多様性を持たせる(ポリモーフィズム)。
		// じゃんけんを実装するのはRockPaperScissorsOrganizer(impl GameOrganier)。
		// ※例えばトランプ遊びを追加する際は PlayingCardsOrganizer(impl GameOrganizer)のように追加する。
		//
		// 処理を実行するために、メイン処理にて実行するGameOrganizerの実装クラスをインスタンス化する必要があるが、
		// その際、明示的にRockPaperScissorsOrganizerを"new"しては、せっかくのポリモーフィズムが水の泡になる。
		// (そういう実装をクラス間の"結合度が高い"という。オブジェクト指向はクラスの疎結合を目指すのが一般的)
		//
		// せっかく多様性を意識してインタフェースを定義して実装クラスを用意したのであれば
		// インスタンス生成の役割をもつクラスを用意するとよい(factoryパターン)。
		// 例えば、最初にユーザに遊びたいゲームを選ばせて、その選択によってfactoryが返却する
		// GameOrganizerの実装クラスインスタンスを決定する、等の柔軟性を持たせるとよい。
		//
		// factoryパターンのように、インスタンスの生成まで抽象化すると、
		// 当mainメソッドは完全にじゃんけんの具体的な処理を知らないまま
		// じゃんけんを実行できる。
		// ※当クラスがじゃんけん関連のクラスをインポートすらしていないことに注目(疎結合)。
		//
		// factoryパターンの説明は以下サイトが個人的に優良な説明をしていると思うので
		// 興味があれば読むことをお勧め。
		// http://www.nulab.co.jp/designPatterns/designPatterns2/designPatterns2-2.html

		// <実装>
		// organizer(主催者)を生成するファクトリ
		GameOrganizerFactory factory = new GameOrganizerFactory();
		GameOrganizer organizer = factory.newInstance();

		// 主催者が実装している処理を呼び出す
		// 具体的な処理内容は主催者のみが知っていればよい
		organizer.initGame();
		organizer.excecuteGame();
		organizer.endGame();

		// ゲームが正しく行われたかどうかは主催者の責務だから
		// メイン処理としての実装は以上。
		// 追加するとしたら例外処理まわり。
	}
}
