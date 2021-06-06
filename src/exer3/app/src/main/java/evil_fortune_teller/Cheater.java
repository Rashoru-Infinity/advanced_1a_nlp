package evil_fortune_teller;

public class Cheater {
	public String content;
	public String item;
	public final int RANK = 12;
	public Cheater(String json) {
		String allResult = json.split("\\[")[1];
		allResult = allResult.split("\\]")[0];
		String[] resultArray = allResult.split("\\{");
		String[] properties = null;
		for (int i = 0;i < resultArray.length;i++) {
			if (!(resultArray[i].indexOf("\"rank\":12") < 0)) {
				resultArray[i] = resultArray[i].split("\\}")[0];
				properties = resultArray[i].split(",");
				break;
			}
		}
		content = properties[0].substring("\"content\":\"".length(), properties[0].length() - 1);
		item = properties[1].substring("\"item\":\"".length(), properties[1].length() - 1);
	}
}
