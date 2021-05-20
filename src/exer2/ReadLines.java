import java.io.*;

public class ReadLines {
	public static String[] readLines() {
		try {
			BufferedReader bf = new BufferedReader(new FileReader("pattern.txt"));
			String line;
			StringBuilder sb = new StringBuilder();
			while ((line = bf.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}
			bf.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString().split("\n");
	}
}
