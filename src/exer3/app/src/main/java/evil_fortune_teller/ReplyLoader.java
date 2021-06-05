package evil_fortune_teller;

import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class ReplyLoader {
	public static String loadReply(String filePath) throws IOException {
		return Files.readString(Paths.get(filePath), StandardCharsets.UTF_8);
	}
}
