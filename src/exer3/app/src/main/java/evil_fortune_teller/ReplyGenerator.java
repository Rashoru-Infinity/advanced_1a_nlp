package evil_fortune_teller;

import java.util.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.io.*;

public class ReplyGenerator {
	public String defaultMsg;
	private String defenceMsg;
	private final String ASK_SIGN = "あなたの星座を教えてください";
	private PersonalInfo profile = new PersonalInfo();
	private DayOffset dayOffset = new DayOffset();
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	private static final String URLCONST = "http://api.jugemkey.jp/api/horoscope/free/";
	private HashSet<String> defenceTriggers = new HashSet<>();
	private HashSet<String> ftKeywords = new HashSet<>();
	public ReplyGenerator() {
		try {
			String triggers = ReplyLoader.loadReply("Doubt.txt");
			String[] words;
			defaultMsg = ReplyLoader.loadReply("Default.txt");
			defenceMsg = ReplyLoader.loadReply("Defence.txt");
			words = triggers.split(System.getProperty("line.separator"));
			for (int i = 0;i < words.length;i++) {
				defenceTriggers.add(words[i]);
			}
			triggers = ReplyLoader.loadReply("FTKeyword.txt");
			words = triggers.split(System.getProperty("line.separator"));
			for (int i = 0;i < words.length;i++) {
				ftKeywords.add(words[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String getReply(String msg, Scanner sc) throws MalformedURLException, IOException {
		msg = replaceWord(msg);
		if (hasDefenceTrigger(msg)) {
			return defenceMsg;
		}else if (!hasFTTrigger(msg)) {
			return defaultMsg;
		}
		StringBuilder reply = new StringBuilder();
		ArrayList<String> words = getWords(msg);
		profile.setSign(msg);
		while (profile.getSign() == Signs.Undefined) {
			System.out.print("Fortune Teller : ");
			System.out.println(ASK_SIGN);
			System.out.print("You : ");
			profile.setSign(sc.next());
		}
		Cheater cheater = new Cheater(getFortuneTellingResult(words));
		reply.append("Fortune Teller : ");
		reply.append(System.getProperty("line.separator"));
		reply.append(profile.getSign().toString(profile.getSign()));
		reply.append("の順位は");
		reply.append(cheater.RANK);
		reply.append("位です。");
		reply.append(System.getProperty("line.separator"));
		reply.append(cheater.content);
		reply.append(System.getProperty("line.separator"));
		reply.append("ラッキーアイテムは");
		reply.append(cheater.item);
		reply.append("です。");
		return reply.toString();
	}
	private String getFortuneTellingResult(ArrayList<String> words) throws MalformedURLException, IOException {
		StringBuilder url = new StringBuilder();
		url.append(URLCONST);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, dayOffset.getOffset(words));
		url.append(dateFormat.format(calendar.getTime()));
		return ResultGetter.getResult(url.toString());
	}
	private ArrayList<String> getWords(String msg) throws IOException {
		String parseResult = MessageParser.parseMsg(msg, "mecab");
		ArrayList<String> words = new ArrayList<>();
		String[] lines = parseResult.split(System.getProperty("line.separator"));
		for (int i = 0;i < lines.length;i++) {
			words.add(lines[i].split("\t")[0]);
		}
		return words;
	}
	private boolean hasDefenceTrigger(String msg) {
		for (String s : defenceTriggers) {
			if (msg.contains(s)) {
				return true;
			}
		}
		return false;
	}
	private boolean hasFTTrigger(String msg) {
		for (String s : ftKeywords) {
			if (msg.contains(s)) {
				return true;
			}
		}
		return false;
	}
	private String replaceWord(String src) {
		src = src.replace("明々後日", "しあさって");
		return src;
	}
}
