package evil_fortune_teller;

import java.util.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.io.*;

public class ReplyGenerator {
	public String defaultMsg;
	private String defenceMsg;
	private PersonalInfo pi = new PersonalInfo();
	private DayOffset dayOffset = new DayOffset();
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	private static final String URLCONST = "http://api.jugemkey.jp/api/horoscope/free/";
	public ReplyGenerator() {
		try {
			defaultMsg = ReplyLoader.loadReply("Default.txt");
			defenceMsg = ReplyLoader.loadReply("Doubt.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String getReply(String msg) throws MalformedURLException, IOException {
		return getFortuneTellingResult("");
	}
	private String getFortuneTellingResult(String msg) throws MalformedURLException, IOException {
		StringBuilder url = new StringBuilder();
		url.append(URLCONST);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, dayOffset.getOffset());
		url.append(dateFormat.format(calendar.getTime()));
		return ResultGetter.getResult(url.toString());
	}
}
