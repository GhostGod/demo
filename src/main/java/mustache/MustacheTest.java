package mustache;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

public class MustacheTest {
	public static void main(String[] args) {
		MustacheFactory mf = new DefaultMustacheFactory();
		Mustache mustache = mf.compile("mustache.json");
		Writer w = new StringWriter();
		Map<String, Object> map = new HashMap<>();
		map.put("test1", "aaaa<br>");
		map.put("test2", "aaaa<br>");
		mustache.execute(w, map);
		System.out.println(w.toString());
	}
}
