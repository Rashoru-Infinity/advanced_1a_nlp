import java.util.*;

public class PersonalInfo {
	private Sign sign = Undefined;
	public void setSign(ArrayList<String> nouns) {
		for (String n : nouns) {
			if (n == null || sign != Undefined) {
				continue;
			}
			if (n.indexOf("おひつじ") >= 0 || n.indexOf("牡羊") >= 0) {
				sign = Aries;
			} else if (n.indexOf("おうし") >= 0 || n.indexOf("牡牛") >= 0) {
				sign = Taurus;
			} else if (n.indexOf("ふたご") >= 0 || n.indexOf("双子") >= 0) {
				sign = Gemini;
			} else if (n.indexOf("かに") >= 0 || n.indexOf("蟹") >= 0) {
				sign = Cancer;
			} else if (n.indexOf("しし") >= 0 || n.indexOf("獅子") >= 0) {
				sign = Leo;
			} else if (n.indexOf("おとめ") >= 0 || n.indexOf("乙女") >= 0) {
				sign = Virgo;
			} else if (n.indexOf("てんびん") >= 0 || n.indexOf("天秤") >= 0) {
				sign = Libra;
			} else if (n.indexOf("さそり") >= 0 || n.indexOf("蠍") >= 0) {
				sign = Scorpio;
			} else if (n.indexOf("いて") >= 0 || n.indexOf("射手") >= 0) {
				sign = Sagittarius;
			} else if (n.indexOf("やぎ") >= 0 || n.indexOf("山羊") >= 0) {
				sign = Capricorn;
			} else if (n.indexOf("みずがめ") >= 0 || n.indexOf("水瓶") >= 0) {
				sign = Aquarius;
			} else if (n.indexOf("うお") >= 0 || n.indexOf("魚")) {
				sign = Pisces;
			}
		}
	}
	public Sign getSign() {
		return sign;
	}
}
