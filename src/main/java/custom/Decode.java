package custom;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 解密注解可以修饰类或方法，包含2个参数，被解密参数位置索引“index”和解密算法“algorithm”
 * 1、修饰类时，默认对全部方法和全部参数都进行解密，可以通过index和algorithm指定解密参数和解密算法
 * 2、修饰方法时，默认对全部参数都进行解密，可以通过index和algorithm指定解密参数和解密算法
 * @author liuyang
 * @Email y_liu@hiersun.com | 745089707@qq.com
 * @Date 2016年9月19日
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@Documented
public @interface Decode {

	/**
	 *  被解密的参数位置索引，允许多个，默认全部解密
	 * @return
	 */
	int[] index() default {};

	/**
	 * 解密的算法，默认AES
	 * @return
	 */
	Algorithm algorithm() default Algorithm.AES;

	/**
	 * 加密算法
	 */
	enum Algorithm {
		AES, MD5, //DES, TRIBLE_DES, RSA
	}
}
