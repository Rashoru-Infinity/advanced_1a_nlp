import java.io.*;

public class MecabTest {
	public static void main(String[] args) {
		try {
			Process process = Runtime.getRuntime().exec("mecab");
			BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
			PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(process.getOutputStream())));
			BufferedReader brfile = new BufferedReader(new FileReader(new File("./input.txt")));
			StringBuilder sb = new StringBuilder();
			String str;
			while ((str = brfile.readLine()) != null) {
				sb.append(str);
			}
			pw.println(sb.toString());
			pw.flush();
			String line2;
			while ((line2 = br.readLine()) != null) {
				if (line2.equals("EOS")) {
					break;
				}
					System.out.println(line2);
			}
			br.close();
			brfile.close();
			pw.close();
			process.destroy();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
