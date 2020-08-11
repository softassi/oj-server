package com.softassi.oj.server.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName : SHA256Utils
 * @Description : 用sha256对文件进行hash签名
 * @Author : cybersa
 * @Date: 2020-08-11 22:44
 */
public class SHA256Utils {

    static char[] hexdigits = {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};


    public static String getSHA256(MultipartFile file) {
        FileInputStream fis = null;
        try {
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            InputStream inputStream = file.getInputStream();
            byte[] buffer = new byte[1024];
            int length = -1;
            while ((length = inputStream.read(buffer)) != -1) {
                sha256.update(buffer, 0, length);

            }
            byte[] result = sha256.digest();
            return byteToHexString(result);
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private static String byteToHexString(byte[] tmp) {
        String s;
        // 用字节表示就是 16 个字节
        char str[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符，
        // 所以表示成 16 进制需要 32 个字符
        int k = 0; // 表示转换结果中对应的字符位置
        for (int i = 0; i < 16; i++) { // 从第一个字节开始，对 MD5 的每一个字节
            // 转换成 16 进制字符的转换
            byte byte0 = tmp[i]; // 取第 i 个字节
            str[k++] = hexdigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换,
            // >>> 为逻辑右移，将符号位一起右移
            str[k++] = hexdigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
        }

        s = new String(str); // 换后的结果转换为字符串
        return s;

    }

}
