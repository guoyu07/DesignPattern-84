import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//相談役の具体的な実装
public class LoginFrame extends Frame implements ActionListener, Mediator {
	private ColleagueCheckbox checkGuest;
	private ColleagueCheckbox checkLogin;
	private ColleagueTextField textUser;
	private ColleagueTextField textPass;
	private ColleagueButton buttonOk;
	private ColleagueButton buttonCancel;

	// コンストラクタ
	// Colleagueたちを生成し、配置した後に表示を行う
	public LoginFrame(String title) {
		super(title);
		setBackground(Color.lightGray);
		// レイアウトマネージャを使って4*2のグリッドを作る
		setLayout(new GridLayout(4, 2));
		// Colleagueたちを生成
		createColleagues();
		// 配置
		add(checkGuest);
		add(checkLogin);
		add(new Label("Username:"));
		add(textUser);
		add(new Label("Password:"));
		add(textPass);
		add(buttonOk);
		add(buttonCancel);
		// 有効無効の初期設定
		colleagueChanged();
		// 表示
		pack();
		show();
	}

	// Colleagueたちを生成
	public void createColleagues() {
		// 生成
		CheckboxGroup g = new CheckboxGroup();
		checkGuest = new ColleagueCheckbox("Guest", g, true);
		checkLogin = new ColleagueCheckbox("Login", g, false);
		textUser = new ColleagueTextField("", 10);
		textPass = new ColleagueTextField("", 10);
		textPass.setEchoChar('*');
		buttonOk = new ColleagueButton("OK");
		buttonCancel = new ColleagueButton("Cancel");
		// 相談役の設定
		checkGuest.setMediator(this);
		checkLogin.setMediator(this);
		textUser.setMediator(this);
		textPass.setMediator(this);
		buttonOk.setMediator(this);
		buttonCancel.setMediator(this);
		// Listenerの設定
		checkGuest.addItemListener(checkGuest);
		checkLogin.addItemListener(checkLogin);
		textUser.addTextListener(textUser);
		textPass.addTextListener(textPass);
		buttonOk.addActionListener(this);
		buttonCancel.addActionListener(this);
	}

	// Colleageからの通知で各Colleague有効無効を判定する
	public void colleagueChanged() {
		if (checkGuest.getState()) { // Guest mode
			textUser.setColleagueEnabled(false);
			textPass.setColleagueEnabled(false);
			buttonOk.setColleagueEnabled(true);
		} else { // Login mode
			textUser.setColleagueEnabled(true);
			userpassChanged();
		}
	}

	//ユーザーとパスワードの変更（入力）があった
	//各Colleagueの有効有効の判定
	private void userpassChanged() {
		if (textUser.getText().length() > 3) {
			textPass.setColleagueEnabled(true);
			if (textPass.getText().length() > 3) {
				buttonOk.setColleagueEnabled(true);
			} else {
				buttonOk.setColleagueEnabled(false);
			}
		} else {
			textPass.setColleagueEnabled(false);
			buttonOk.setColleagueEnabled(false);
		}
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(e.toString());
		System.exit(0);
	}
}
