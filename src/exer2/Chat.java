import java.util.*;

public class Chat {
	static List<ResponsePattern> ptnList;
	public static void main(String[] args) {
		ptnList = new ArrayList<>();
		String[] lines = ReadLines.readLines("pattern.txt");
		for (int i = 0;i < lines.length;i++) {
			String[] resp = lines[i].split("\t");
			if (resp.length != 2) {
				System.out.println("invalid format");
				System.exit(0);
			}
			ptnList.add(new ResponsePattern(resp[0], resp[1]));
		}
	}
}
