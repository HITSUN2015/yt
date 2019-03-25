package com.yt.datastructure.datastructure.util;

import org.apache.tomcat.util.codec.binary.Base64;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * Created by yantong on 2019/1/8.
 */
public class Base64Util {


    // base64字符串转化成图片
    public static Image GenerateImage(String imgStr) { //对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) {
            // 图像数据为空
            return null;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    // 调整异常数据
                    b[i] += 256;
                }
            }
            InputStream buffin = new ByteArrayInputStream(b, 0, b.length);

            BufferedImage img = ImageIO.read(buffin);
            return img;

        } catch (Exception e) {
            return null;
        }
    }

    //image转化为byte
    public static byte[] Generatebyte(Image img) {

        if (img == null) {
            // 图像数据为空
            return null;
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ImageIO.write((RenderedImage) img, "jpeg", bos);
        } catch (Exception e) {
            return null;
        }
        byte[] b = bos.toByteArray();

        return b;
    }

    public static byte[] encodeBase64(byte[] src){
        return Base64.encodeBase64(src);
    }

    public static String encodeBase64String(byte[] src){
        return Base64.encodeBase64String(src);
    }

    public static String encodeBase64String(String src){
        return new String(Base64.encodeBase64(src.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
    }

    public static String decodeBase64String(byte[] src){
        return new String(Base64.decodeBase64(src), StandardCharsets.UTF_8);
    }

    public static String decodeBase64String(String src){
        return new String(Base64.decodeBase64(src.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
    }

    public static byte[] decodeBase64(String src){
        return Base64.decodeBase64(src.getBytes(StandardCharsets.UTF_8));
    }

    public static byte[] decodeBase64(byte[] src){
        return Base64.decodeBase64(src);
    }

}
