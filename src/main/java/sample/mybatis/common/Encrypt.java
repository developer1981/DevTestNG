package sample.mybatis.common;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Collection;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class Encrypt {
	public static byte[] desCrypto(byte[] datasource) {
		try {
			SecureRandom random = new SecureRandom();
			DESKeySpec desKey = new DESKeySpec(Config.ENC_KEY.getBytes());
			// 创建一个密匙工厂，然后用它把DESKeySpec转换成
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey securekey = keyFactory.generateSecret(desKey);
			// Cipher对象实际完成加密操作
			Cipher cipher = Cipher.getInstance("DES");
			// 用密匙初始化Cipher对象
			cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
			// 现在，获取数据并加密
			// 正式执行加密操作
			return cipher.doFinal(datasource);
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
		
	}  

	public static byte[] desDecrypt(byte[] src) {
		try {
		// DES算法要求有一个可信任的随机数源
		SecureRandom random = new SecureRandom();
		// 创建一个DESKeySpec对象
		DESKeySpec desKey = new DESKeySpec(Config.ENC_KEY.getBytes());
		// 创建一个密匙工厂
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		// 将DESKeySpec对象转换成SecretKey对象
		SecretKey securekey = keyFactory.generateSecret(desKey);
		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance("DES");
		// 用密匙初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, random);
		// 真正开始解密操作
			return cipher.doFinal(src);
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
		
	}
	public static String Base64Encode(byte[] src){
		return Base64.getEncoder().encodeToString(src);
	}
    
	public static byte[] Base64Decode(String src){
		return Base64.getDecoder().decode(src);
	}	
	
	public static void main(String[] args) {
		String enc = Encrypt.Base64Encode(Encrypt.desCrypto("test".getBytes()));
		
		String enc2 = new String(Encrypt.desDecrypt(Encrypt.Base64Decode(enc)));
		System.out.println(enc2);

	}
}
