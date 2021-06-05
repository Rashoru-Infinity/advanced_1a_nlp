package evil_fortune_teller;

import java.util.*;
import java.io.*;

public class DayOffset {
	private Map<String, Integer> offsetWords = new HashMap<>();
	private static final String DATAFILE = "./DayOffset.txt";
	public DayOffset() {
		try {
			FileReader fr = new FileReader(new File(DATAFILE));
			BufferedReader br = new BufferedReader(fr);
			String line;
			int lineNum = 0;
			while ((line = br.readLine()) != null) {
				++lineNum;
				String[] split = line.split("\t");
				try {
					offsetWords.put(split[0], new Integer(Integer.parseInt(split[1])));
				} catch(Exception e) {
					StringBuilder sb = new StringBuilder();
					sb.append(DATAFILE);
					sb.append(" L");
					sb.append(String.valueOf(lineNum));
					sb.append(":");
					System.out.println("Invalid format!");
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int getOffset() {
		return 0;
	}
	public int getOffset(String[] words) {
		for (int i = 0;i < words.length;i++) {
			if (offsetWords.get(words[i]) != null) {
				return offsetWords.get(words[i]);
			}
		}
		return 0;
	}
	public int getOffset(ArrayList<String> words) {
		for (String s : words) {
			if (offsetWords.get(s) != null) {
				return offsetWords.get(s);
			}
		}
		return 0;
	}
}			
