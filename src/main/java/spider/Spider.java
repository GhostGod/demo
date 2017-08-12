package spider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.util.StringUtils;

public class Spider {

	private static final String PATH = "";
	private static final String USER_AGENT = "Mozilla/5.0";
	private final static String URL = "";
	private final static Pattern PATTERN = Pattern.compile("<a href=\"([a-zA-Z-_]*\\.html)\">");
	private final static List<String> HTML = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		Spider.html(URL + "index.html");
	}

	public static void html(String url) throws Exception {
		if (HTML.contains(url)) {
			return;
		} else {
			System.out.println(url);
			HTML.add(url);
		}
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		httpGet.addHeader("User-Agent", USER_AGENT);
		//httpGet.addHeader(arg0, arg1);
		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
		BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));

		String inputLine;
		File file = new File(PATH + url.substring(URL.lastIndexOf("/") + 1));
		FileWriter writer = new FileWriter(file);
		while ((inputLine = reader.readLine()) != null) {
			if (StringUtils.hasText(inputLine)) {
				Matcher matcher = PATTERN.matcher(inputLine);
				while (matcher.find()) {
					String name = matcher.group(1);
					//System.out.println(name);
					html(URL + name);
				}
				writer.write(inputLine + "\n");
			}
		}
		reader.close();
		writer.close();
		httpClient.close();
	}
}
