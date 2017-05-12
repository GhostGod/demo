package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestAgent {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile(";\\s?(\\S*?\\s?\\S*?)\\s?(Build)?/");
		Matcher matcher = pattern
				.matcher("Mozilla/5.0 (Linux; U; Android 4.3; zh-cn; R8007 Build/JLS36C) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30");
		String model = null;
		if (matcher.find()) {
			model = matcher.group(1);
			System.out.println(model);
		}
	}

}
