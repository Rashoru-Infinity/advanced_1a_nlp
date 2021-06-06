package evil_fortune_teller;

import java.io.*;
import java.net.*;
import java.util.*;

public class Main {
	public static PersonalInfo pi = new PersonalInfo();
	public static DayOffset dayOffset = new DayOffset();
	public static ReplyGenerator rpGen = new ReplyGenerator();
	public static void main(String[] args) throws MalformedURLException, IOException {
		chat();
	}
	public static void chat() throws MalformedURLException, IOException {
		Scanner sc = new Scanner(System.in);
		String msg;
		System.out.print("Fortune Teller : ");
		System.out.println(rpGen.defaultMsg);
		System.out.print("You : ");
		while (!(msg = sc.next()).equals("さようなら")) {
			System.out.println(rpGen.getReply(msg, sc));
			System.out.print("You : ");
		}
		sc.close();
	}
}
