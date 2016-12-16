package QA_6_1;

public class Main {

	public static void main(String[] args) {
		// 準備
		Manager manager = new Manager();

		UnderlinePen upen = new UnderlinePen('~');
		MessageBox mbox = new MessageBox('*');
		MessageBox sbox = new MessageBox('/');
		manager.register("strong message", upen);
		manager.register("warning message", mbox);
		manager.register("slash message", sbox);

		//生成
		Product p1 = manager.create("strong message");
		p1.use("Hello, world.");

		Product p2 = manager.create("warning message");
		p2.use("Hello, world.");

		Product p3 = manager.create("slash message");
		p3.use("Hello, world.");
	}

}
