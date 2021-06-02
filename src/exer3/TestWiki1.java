import java.io.*;
import java.net.*;

// Web APIを利用してWikipediaの記事の概要を取得する例
public class TestWiki1 {

    // コンストラクタ
    public TestWiki1() {
    }

    // Web APIを利用して単語の説明文を得るメソッド
    public String getWiki() {
	String response = null; // Webサーバからの応答

	// Proxyサーバの設定（学内）←設定しなくても正常動作する
	//System.setProperty("http.proxyHost","proxy.sic.shibaura-it.ac.jp");
	//System.setProperty("http.proxyPort","10080");

	try {
	    // Web APIのリクエストURLを構築する
	    String url = "http://api.jugemkey.jp/api/horoscope/free/2021/6/1";

	    // HTTP接続を確立し，処理要求を送る
	    HttpURLConnection conn = (HttpURLConnection)(new URL(url)).openConnection();
	    conn.setRequestMethod("GET"); // GETメソッド

	    // Webサーバからの応答を受け取る
	    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
	    response = "";
	    String line;
	    while((line = br.readLine()) != null) {
		response += line;
	    }
	    br.close();
	    conn.disconnect();
	} catch (IOException ex) {
	    ex.printStackTrace();
	}

	// Javaの場合，上記のコードでサーバからの応答のボディ部のみが得られるので
	// 本APIにおいては，これをそのまま単語の説明文として返せばよい
	return response;
    }

    // 動作テスト用のmainメソッド
    public static void main(String[] args) {
	TestWiki1 instance = new TestWiki1();

	String description = instance.getWiki();
	System.out.println(description);
    }
}
