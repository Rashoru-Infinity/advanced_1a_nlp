package evil_fortune_teller;

public enum Signs {
	Aries,
	Taurus,
	Gemini,
	Cancer,
	Leo,
	Virgo,
	Libra,
	Scorpio,
	Sagittarius,
	Capricorn,
	Aquarius,
	Pisces,
	Undefined;
	
	public String toString(Signs sign) {
		switch(sign) {
		case Aries:
			return "牡羊座";
		case Taurus:
			return "牡牛座";
		case Gemini:
			return "双子座";
		case Cancer:
			return "蟹座";
		case Leo:
			return "獅子座";
		case Virgo:
			return "乙女座";
		case Libra:
			return "天秤座";
		case Scorpio:
			return "さそり座";
		case Sagittarius:
			return "射手座";
		case Capricorn:
			return "山羊座";
		case Aquarius:
			return "水瓶座";
		case Pisces:
			return "魚座";
		default:
			return "未定義です";
		}
	}
}
