package evil_fortune_teller;

public class PersonalInfo {
	private Signs sign = Signs.Undefined;
	public void setSign(String words) {
		if (words == null) {
			return ;
		}
		if (words.indexOf("おひつじ") >= 0 || words.indexOf("牡羊") >= 0) {
			sign = Signs.Aries;
		} else if (words.indexOf("おうし") >= 0 || words.indexOf("牡牛") >= 0) {
			sign = Signs.Taurus;
		} else if (words.indexOf("ふたご") >= 0 || words.indexOf("双子") >= 0) {
			sign = Signs.Gemini;
		} else if (words.indexOf("かに") >= 0 || words.indexOf("蟹") >= 0) {
			sign = Signs.Cancer;
		} else if (words.indexOf("しし") >= 0 || words.indexOf("獅子") >= 0) {
			sign = Signs.Leo;
		} else if (words.indexOf("おとめ") >= 0 || words.indexOf("乙女") >= 0) {
			sign = Signs.Virgo;
		} else if (words.indexOf("てんびん") >= 0 || words.indexOf("天秤") >= 0) {
			sign = Signs.Libra;
		} else if (words.indexOf("さそり") >= 0 || words.indexOf("蠍") >= 0) {
			sign = Signs.Scorpio;
		} else if (words.indexOf("いて") >= 0 || words.indexOf("射手") >= 0) {
			sign = Signs.Sagittarius;
		} else if (words.indexOf("やぎ") >= 0 || words.indexOf("山羊") >= 0) {
			sign = Signs.Capricorn;
		} else if (words.indexOf("みずがめ") >= 0 || words.indexOf("水瓶") >= 0) {
			sign = Signs.Aquarius;
		} else if (words.indexOf("うお") >= 0 || words.indexOf("魚") >= 0) {
			sign = Signs.Pisces;
		}
	}
	public Signs getSign() {
		return sign;
	}
}
