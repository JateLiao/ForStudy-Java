/*
 * 文件名：DESUtil.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： DESUtil.java
 * 修改人：tianzhong
 * 修改时间：2017年3月2日
 * 修改内容：新增
 */
package util;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * TODO 添加类的一句话简单描述.
 * <p>
 * TODO 详细描述
 * <p>
 * TODO 示例代码
 * <pre>
 * </pre>
 * 
 * @author     tianzhong
 */
public class DESUtil {
    
    public static void main(String[] args) throws Exception {
        try {
            String key = "1044476843@qq.com";
            if (key.length() < 8) {
                key = "00000000".substring(0, 8 - key.length()).concat(key);
            }
            System.out.println(key);
            String data = "qqqq";
            // FcGdUSmQ0zxZejy+HXTivA==
            // FcGdUSmQ0zxZejy+HXTivA==
            // FcGdUSmQ0zxZejy+HXTivA==
            // AnAZGrL4x2A\u003d
            // System.out.println(encrypt(data, key));
            // System.out.println(decrypt(encrypt(data, key), key));
            System.out.println(decrypt("UA58ewyeYhnSKE3qlOcF9g==", key));
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof IllegalBlockSizeException && e.getMessage().contains("Input length must be multiple of 8 when decrypting with padded cipher")) {
                System.out.println("密文已被解密");
            }
        }
    }
    /**
     * Description 根据键值进行加密
     * 
     * @param data
     * @param key
     *            加密键byte数组
     * @return
     * @throws Exception
     */
    public static String encrypt(String data, String key) throws Exception {
        if (null == data|| "".equals(data) || null == key || "".equals(key)) {
            return null;
        }
        byte[] bt = encrypt(data.getBytes("UTF-8"), key.getBytes("UTF-8"));
        String strs = new BASE64Encoder().encode(bt);
        return strs;
    }
    
    /**
     * Description 根据键值进行加密
     * 
     * @param data
     * @param key
     *            加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance("DES");

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }

    /**
     * Description 根据键值进行解密
     * 
     * @param data
     * @param key
     *            加密键byte数组
     * @return
     * @throws Exception
     */
    public static String decrypt(String data, String key) throws Exception {
        if (data == null)
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] buf = decoder.decodeBuffer(data);
        byte[] bt = decrypt(buf, key.getBytes("UTF-8"));
        return new String(bt, "UTF-8");
    }
    /**
     * Description 根据键值进行解密
     * 
     * @param data
     * @param key
     *            加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("DES");

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }
}
