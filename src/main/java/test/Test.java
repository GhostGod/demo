package test;

import java.math.BigDecimal;


public class Test {
	public static void main(String[] args) {
		Converter<String, Integer> a = (from) -> {
			if(from ==null){
				from = "1";
			}
			return Integer.valueOf(from);
		};
		//Java 8 允许你使用 :: 关键字来传递方法或者构造函数引用
		Converter<String, Integer> converter = Integer::valueOf;//这个是静态方式导入 

		Integer m = a.convert("123");
		System.out.println(m);
		

		m = converter.convert("1233");
		System.out.println(m);
		
		test test = mms -> "aaaa";//mmm代表你要传入的参数
		String testResult = test.aa("");//aa代表你要传入的方法
		System.out.println(testResult);
		
		
		for(int i=0;i<"".getBytes().length;i++){
			System.out.println("".getBytes()[i]);
		}
		
		BigDecimal b = new BigDecimal(0.01);
		BigDecimal c = new BigDecimal(0.1);
		BigDecimal d = new BigDecimal(0.10);
		System.out.println(b.equals(c));
		System.out.println(d.equals(c));
	}

	@FunctionalInterface
	interface Converter<F, T> {
		T convert(F from);
	}

	interface test {
		String aa(String mmm);
	}

	//使用函数式接口时，接口的定义只能有一个，@FunctionalInterface注解可有可无
}
