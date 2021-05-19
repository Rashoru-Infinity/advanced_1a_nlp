import java.io.*;

public class Practice1 {
	public static void main(String[] args) {
		String str = "太郎は昨日図書館で本を借りました。";
		System.out.println(str);
		System.out.println(System.getProperty("file.encoding"));
		try {
			Process process = Runtime.getRuntime().exec("mecab");
			BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
			PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(process.getOutputStream())));
			pw.println(str);
			pw.flush();
			String line2;
			while ((line2 = br.readLine()) != null) {
				if (line2.equals("EOS")) {
					break;
				}
				System.out.println(line2);
			}
			br.close();
			pw.close();
			process.destroy();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
