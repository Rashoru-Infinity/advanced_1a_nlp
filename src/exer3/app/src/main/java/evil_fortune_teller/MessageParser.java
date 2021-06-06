package evil_fortune_teller;

import java.io.*;

public class MessageParser {
	public static String parseMsg(String msg, String parser) throws IOException {
		Process parse = Runtime.getRuntime().exec(parser);
		BufferedReader br = new BufferedReader(new InputStreamReader(parse.getInputStream()));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(parse.getOutputStream())));
		pw.println(msg);
		pw.flush();
		String line;
		StringBuilder parseResult = new StringBuilder();
		while ((line = br.readLine()) != null) {
			if (line.equals("EOS")) {
				break;
			}
			parseResult.append(line);
			parseResult.append(System.getProperty("line.separator"));
		}
		br.close();
		pw.close();
		return parseResult.toString();
	}
}
