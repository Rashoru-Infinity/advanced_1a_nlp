package evil_fortune_teller;

import java.util.*;

public class PersonalInfo {
	private Signs sign = Signs.Undefined;
	public void setSign(ArrayList<String> nouns) {
		for (String n : nouns) {
			if (n == null || sign != Signs.Undefined) {
				continue;
			}
			if (n.indexOf("おひつじ") >= 0 || n.indexOf("牡羊") >= 0) {
				sign = Signs.Aries;
			} else if (n.indexOf("おうし") >= 0 || n.indexOf("牡牛") >= 0) {
				sign = Signs.Taurus;
			} else if (n.indexOf("ふたご") >= 0 || n.indexOf("双子") >= 0) {
				sign = Signs.Gemini;
			} else if (n.indexOf("かに") >= 0 || n.indexOf("蟹") >= 0) {
				sign = Signs.Cancer;
			} else if (n.indexOf("しし") >= 0 || n.indexOf("獅子") >= 0) {
				sign = Signs.Leo;
			} else if (n.indexOf("おとめ") >= 0 || n.indexOf("乙女") >= 0) {
				sign = Signs.Virgo;
			} else if (n.indexOf("てんびん") >= 0 || n.indexOf("天秤") >= 0) {
				sign = Signs.Libra;
			} else if (n.indexOf("さそり") >= 0 || n.indexOf("蠍") >= 0) {
				sign = Signs.Scorpio;
			} else if (n.indexOf("いて") >= 0 || n.indexOf("射手") >= 0) {
				sign = Signs.Sagittarius;
			} else if (n.indexOf("やぎ") >= 0 || n.indexOf("山羊") >= 0) {
				sign = Signs.Capricorn;
			} else if (n.indexOf("みずがめ") >= 0 || n.indexOf("水瓶") >= 0) {
				sign = Signs.Aquarius;
			} else if (n.indexOf("うお") >= 0 || n.indexOf("魚") >= 0) {
				sign = Signs.Pisces;
			}
		}
	}
	public Signs getSign() {
		return sign;
	}
}
