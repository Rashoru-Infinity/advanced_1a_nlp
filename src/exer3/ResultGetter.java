import java.net.*;
import java.io.*;

public class ResultGetter {
	public static String getResult(String url) {
		StringBuilder sb = new StringBuilder();
		try {
			HttpURLConnection connection = (HttpURLConnection)(new URL(url)).openConnection();
			connection.setRequestMethod("GET");
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			String buf;
			while ((buf = br.readLine()) != null) {
				sb.append(buf);
			}
			br.close();
			connection.disconnect();
		} catch (IOException e) {
			return null;
		}
		return sb.toString();
	}
}
