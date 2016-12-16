package QA_7_2;

public class Main {

	public static void main(String[] args) {
		if (args.length != 1) {
			usage();
			System.exit(0);
		}

		if (args[0].equals("plain")) {
			TextBuilder textBuilder = new TextBuilder();
			Director director = new Director(textBuilder);

			director.construct();
			String result = textBuilder.getResult();
			System.out.println(result);

		} else if (args[0].equals("html")) {

			HTMLBuilder htmlBuilder = new HTMLBuilder();
			Director director = new Director(htmlBuilder);

			director.construct();
			String result = htmlBuilder.getResult();
			System.out.println(result + "が作成されました。");

		} else if (args[0].equals("xml")) {

			XMLBuilder xmlBuilder = new XMLBuilder();
			Director director = new Director(xmlBuilder);

			director.construct();
			String result = xmlBuilder.getResult();
			System.out.println(result + "が作成されました。");

		} else {
			usage();
			System.exit(0);
		}
	}

	public static void usage() {
		System.out.println("Usage:java Main plain ブレーンテキストで文書作成");
		System.out.println("Usage:java Main html HTMLファイルで文書作成");
	}
}
