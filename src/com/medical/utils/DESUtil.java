package com.medical.utils;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.iharder.Base64;

/**
 * 配置文件解密
 * @ClassName: DESUtil 
 * @Description: TODO
 * @author: wh
 * @date: 2017年7月31日 下午4:38:41
 */
public class DESUtil {
	Logger log = LoggerFactory.getLogger(DESUtil.class);
	private final static String DES = "DES";

	public static void main(String[] args) throws Exception {
		String data = "data";
		String key = "saiwodianzikeji";
		System.out.println(encrypt(data, key));
	}

	/**
	 * 加密
	 * @Title: encrypt 
	 * @Description: TODO
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	public static String encrypt(String data, String key) throws Exception {
		byte[] bt = encrypt(data.getBytes("UTF-8"), key.getBytes("UTF-8"));
		String strs = new String(Base64.encodeBytes(bt));
		return strs;
	}

	/**
	 * 解密
	 * @Title: decrypt 
	 * @Description: TODO
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	public static String decrypt(String data, String key) throws Exception {
		if (data == null)
			return null;
		byte[] buf = Base64.decode(data);
		byte[] bt = decrypt(buf, key.getBytes());
		return new String(bt, "UTF-8");
	}

	/**
	 * 加密
	 * @Title: encrypt 
	 * @Description: TODO
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 * @return: byte[]
	 */
	private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
		// 生成一个可信任的随机数源
		SecureRandom sr = new SecureRandom();

		// 从原始密钥数据创建DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key);

		// 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);

		// Cipher对象实际完成加密操作
		Cipher cipher = Cipher.getInstance(DES);

		// 用密钥初始化Cipher对象
		cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

		return cipher.doFinal(data);
	}

	/**
	 * 根据键值进行解密
	 * @Title: decrypt 
	 * @Description: TODO
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 * @return: byte[]
	 */
	private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
		// 生成一个可信任的随机数源
		SecureRandom sr = new SecureRandom();

		// 从原始密钥数据创建DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key);

		// 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);

		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance(DES);

		// 用密钥初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

		return cipher.doFinal(data);
	}
}
