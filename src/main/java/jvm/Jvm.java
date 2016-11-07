package jvm;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import org.springframework.web.client.RestTemplate;

public class Jvm {

	public void localVarGC() {
		{
			byte[] a = new byte[6 * 1024 * 1024];
			System.out.println(a);
		}
		int b = 1;
		System.out.println(b);
		System.gc();
	}

	java.util.concurrent.atomic.AtomicInteger a;

	public static void main(String[] args) throws InterruptedException, UnsupportedEncodingException {
		/*//new Jvm().localVarGC();
		Integer a = 128;
		Integer b = 128;
		System.out.println(a == b);*/

		RestTemplate template = new RestTemplate();
		Random r = new Random();
		while (true) {
			String str = template.getForObject("http://web.sqt.gtimg.cn/q=sz002751?r=" + r.nextDouble(), String.class);
			System.out.println(new String(str.getBytes("UTF-8"), "GBK").substring(28, 100));
			str = template.getForObject("http://web.sqt.gtimg.cn/q=sh603959?r=" + r.nextDouble(), String.class);
			System.out.println(new String(str.getBytes("UTF-8"), "GBK").substring(28, 100));
			//str = template.getForObject("http://web.sqt.gtimg.cn/q=sh603025?r=" + r.nextDouble(), String.class);
			//System.out.println(new String(str.getBytes("UTF-8"), "GBK").substring(27, 100));
			//str = template.getForObject("http://web.sqt.gtimg.cn/q=sz000002?r=" + r.nextDouble(), String.class);
			//System.out.println(new String(str.getBytes("UTF-8"), "GBK").substring(29, 100));
			Thread.sleep(10 * 1000l);
		}
	}
}
