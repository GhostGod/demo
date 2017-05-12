package elasticsearch;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class ElasticsearchClient {

	private static final Logger logger = Logger.getLogger(ElasticsearchClient.class);

	private static RestTemplate template = new RestTemplate();

	private static final String URL = "http://192.168.59.103:9200/";

	public static void save(String indices, String type, String document, String field, Map<String, Object> object) {
		String url = getUrl(indices, type, document);
		template.put(url, null, object);
	}

	public static void delete(String indices, String type, String document, String field) {

	}

	public static void update(String indices, String type, String document, String field, Map<String, Object> object) {

	}

	public static String select(String indices, String type, String document, String field) {
		String url = getUrl(indices, type, document);
		ResponseEntity<String> responseEntity = template.getForEntity(url, String.class);
		logger.info(responseEntity);
		return responseEntity.getBody();
	}

	public static String get(String url) {
		ResponseEntity<String> responseEntity = template.getForEntity(url, String.class);
		logger.info(responseEntity);
		return responseEntity.getBody();
	}

	private static String getUrl(String indices, String type, String document) {
		return URL + indices + "/" + type + "/" + document;
	}

	public static void main(String[] args) {
		/*Map<String, Object> object1 = new HashMap<>();
		object1.put("first_name", "John");
		object1.put("last_name", "Smith");
		object1.put("age", 25);
		object1.put("about", "I love to go rock climbing");
		object1.put("interests", new String[] { "sports", "music" });
		ElasticsearchClient.save("megacorp", "employee", "1", null, object1);

		Map<String, Object> object2 = new HashMap<>();
		object2.put("first_name", "Jane");
		object2.put("last_name", "Smith");
		object2.put("age", 32);
		object2.put("about", "I like to collect rock albums");
		object2.put("interests", new String[] { "music" });
		ElasticsearchClient.save("megacorp", "employee", "2", null, object2);

		Map<String, Object> object3 = new HashMap<>();
		object3.put("first_name", "Douglas");
		object3.put("last_name", "Fir");
		object3.put("age", 35);
		object3.put("about", "I like to build cabinets");
		object3.put("interests", new String[] { "forestry" });
		ElasticsearchClient.save("megacorp", "employee", "3", null, object3);
		
		ElasticsearchClient.select("megacorp", "employee", "3", "");
		*/
		//ElasticsearchClient.get("http://192.168.59.103:9200/megacorp/employee/1");
		MultiValueMap<String, Object> object1 = new LinkedMultiValueMap<>();
		/*object1.add("first_name", "John");
		object1.add("last_name", "Smith");
		object1.add("age", 25);
		object1.add("about", "I love to go rock climbing");
		object1.add("interests", new String[] { "sports", "music" });*/
		/*HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(requestHeaders);
		ResponseEntity<String> responseEntity = template.exchange("http://192.168.59.103:9200/music/", HttpMethod.PUT, requestEntity,
				String.class);
		logger.info(responseEntity.getBody());*/
		/*HttpPut request = new HttpPut("http://192.168.59.103:9200/music/");
		DefaultHttpClient client = new DefaultHttpClient();
		try {
			HttpResponse response = client.execute(request);
			logger.info(response.getEntity().getContent());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		JestClientFactory factory = new JestClientFactory();
		 factory.setHttpClientConfig(new HttpClientConfig
		                        .Builder("http://localhost:9200")
		                        .multiThreaded(true)
		                        .build());
		 JestClient client = factory.getObject();
	}
}
