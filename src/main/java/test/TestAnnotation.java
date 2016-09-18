package test;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import custom.Encode;

@Encode(value = "ssss")
public class TestAnnotation {
	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
			IllegalBlockSizeException, BadPaddingException {
		TestAnnotation test = new TestAnnotation();
		Class<? extends TestAnnotation> clazz = test.getClass();
		if (clazz.isAnnotationPresent(Encode.class)) {
			Encode encode = clazz.getAnnotation(Encode.class);
			System.out.println("aaaaaaaa" + encode.value());
		}
		//new DESedeKeySpec("123".getBytes());
		
		//AES加密
		KeyGenerator kgen = KeyGenerator.getInstance("AES");  
        kgen.init(128, new SecureRandom());  
        SecretKey secretKey = kgen.generateKey();  
        byte[] enCodeFormat = secretKey.getEncoded();  
		SecretKeySpec s = new SecretKeySpec(enCodeFormat, "AES");
		Cipher cipher = Cipher.getInstance("AES");// 创建密码器
		cipher.init(Cipher.ENCRYPT_MODE, s);
		byte[] result = cipher.doFinal("content".getBytes());
		
		//AES解密
		cipher.init(Cipher.DECRYPT_MODE, s);
		System.out.println(new String(cipher.doFinal(result)));
	}
}
