package QA14_4;

public class NoSupport extends Support {

	public NoSupport(String name) {
		super(name);
	}

	//解決用メソッド
	protected boolean resolve(Trouble trouble){
		// 自分は何も処理しない
		return false;
	}

}