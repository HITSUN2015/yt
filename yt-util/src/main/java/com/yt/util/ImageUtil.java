package com.yt.util;

import net.coobird.thumbnailator.Thumbnails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by yantong on 2019/1/8.
 * TODO 如下烂代码 需要重构
 */
@Service("imageUtilService")
public class ImageUtil {

    private static final Logger logger = LoggerFactory.getLogger(ImageUtil.class);

    @Resource
    private RestTemplate restTemplate;

    /**
     * java 创建图片的缩略图
     * @param base64
     *            源图片
     * @param thumbWidth
     *            缩略图宽
     * @param thumbHeight
     *            缩略图高
     */
    public  byte[] createThumbnail(String base64, int thumbWidth, int thumbHeight) {
        // load image from filename
        Image image = Base64Util.GenerateImage(base64);
        MediaTracker mediaTracker = new MediaTracker(new Container());
        mediaTracker.addImage(image, 0);
        byte[] b;
        try {
            mediaTracker.waitForID(0, 1000);
            // use this to test for errors at this point:
            // System.out.println(mediaTracker.isErrorAny());
            // determine thumbnail size from WIDTH and HEIGHT
            double thumbRatio = (double) thumbWidth / (double) thumbHeight;
            int imageWidth = image.getWidth(null);
            int imageHeight = image.getHeight(null);
            double imageRatio = (double) imageWidth / (double) imageHeight;
            if (thumbRatio < imageRatio) {
                thumbHeight = (int) (thumbWidth / imageRatio);
            } else {
                thumbWidth = (int) (thumbHeight * imageRatio);
            }

            // draw original image to thumbnail image object and
            // scale it to the new size on-the-fly
            BufferedImage thumbImage = new BufferedImage(thumbWidth, thumbHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = thumbImage.createGraphics();
            graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            graphics2D.drawImage(image, 0, 0, thumbWidth, thumbHeight, null);

            // save thumbnail image to outFilename

            b = Base64Util.Generatebyte(thumbImage);

        } catch (Exception e) {
            logger.error("create Thumbnail error!", e);
            return null;
        }
        return b;
    }

    /**
     *
     * @param thumbnailWidth (期望缩略图宽度)
     * @param base64Image
     * @return
     */
    public  byte[] getThumbnail(int thumbnailWidth,String base64Image,String imageType){
        byte[] imageByte = new byte[0];
        BufferedImage orgBufferedImage = null;
        BufferedImage nailBufferedImage = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            orgBufferedImage= (BufferedImage)Base64Util.GenerateImage(base64Image);
            if (null == orgBufferedImage){
                return imageByte;
            }
            int imageWidth = orgBufferedImage.getWidth();
            nailBufferedImage = Thumbnails.of(orgBufferedImage).scale((float)thumbnailWidth/imageWidth).asBufferedImage();
            boolean flag = ImageIO.write(nailBufferedImage, StringUtil.isBlankNoExactly(imageType) ?"jpg":imageType, outputStream);
            if (flag){
                imageByte = outputStream.toByteArray();
            }
        } catch (Exception ex) {
            logger.error("生成缩略图失败",ex);
        }finally{
            try {
                outputStream.close();
            } catch (IOException e) {
            }
            if (null != nailBufferedImage){
                try {
                    nailBufferedImage.flush();
                    nailBufferedImage = null;
                } catch (Exception ex) {
                }
            }
            if (null != orgBufferedImage){
                try {
                    orgBufferedImage.flush();
                    orgBufferedImage = null;
                } catch (Exception ex) {
                }
            }
        }
        return imageByte;
    }

    /**
     *
     * @param thumbnailWidth (期望缩略图宽度)
     * @param base64Image
     * @return
     */
    public  byte[] getThumbnail(int thumbnailWidth,byte[] base64Image,String imageType){
        byte[] imageByte = new byte[0];
        BufferedImage orgBufferedImage = null;
        BufferedImage nailBufferedImage = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            InputStream buffin = new ByteArrayInputStream(base64Image, 0, base64Image.length);
            orgBufferedImage = (BufferedImage) ImageIO.read(buffin);
            if (null == orgBufferedImage) {
                return imageByte;
            }
            int imageWidth = orgBufferedImage.getWidth();
            nailBufferedImage = Thumbnails.of(orgBufferedImage).scale((float) thumbnailWidth / imageWidth)
                    .asBufferedImage();
            boolean flag = ImageIO.write(nailBufferedImage, StringUtil.isBlankNoExactly(imageType) ? "jpg" : imageType,
                    outputStream);
            if (flag) {
                imageByte = outputStream.toByteArray();
            }
        } catch (Exception ex) {
            logger.error("生成缩略图失败",ex);
        }finally{
            try {
                outputStream.close();
            } catch (IOException e) {
            }
            if (null != nailBufferedImage){
                try {
                    nailBufferedImage.flush();
                    nailBufferedImage = null;
                } catch (Exception ex) {
                }
            }
            if (null != orgBufferedImage){
                try {
                    orgBufferedImage.flush();
                    orgBufferedImage = null;
                } catch (Exception ex) {
                }
            }
        }
        return imageByte;
    }

    /**
     *
     * @param avatarWidth,缩略图的宽度
     * @param avatarUrl
     * @param imageType
     * @return
     */
    public byte[] getAvatarThumbnail(int avatarWidth,String avatarUrl, float inX, float inY, float inWidth, float inHeight, String imageType){
        byte[] imageByte = new byte[0];
        /**获取图像数据*/
        ByteArrayOutputStream thumbnailOutputStream = new ByteArrayOutputStream();
        BufferedImage nailBufferedImage = null;
        BufferedImage orgBufferedImage = null;
        InputStream buffin = null;
        try{
            imageByte = restTemplate.getForObject(avatarUrl, byte[].class);
            if (null == imageByte || imageByte.length ==0){
                logger.info("====>get avatar:{} data failed.",avatarUrl);
                return imageByte;
            }
            buffin = new ByteArrayInputStream(imageByte, 0, imageByte.length);
            orgBufferedImage = ImageIO.read(buffin);
            int imageOrgWidth = orgBufferedImage.getWidth();
            int imageOrgHeight = orgBufferedImage.getHeight();
            int x = Math.round(inX * imageOrgWidth);
            int y = Math.round(inY * imageOrgHeight);
            int width = Math.round(inWidth * imageOrgWidth);
            int height = Math.round(inHeight * imageOrgHeight);
            nailBufferedImage = Thumbnails.of(orgBufferedImage).sourceRegion(x, y, width, height)/** 裁剪人脸图像 */
                    .scale((float)avatarWidth / imageOrgWidth).asBufferedImage();
            boolean flag = ImageIO.write(nailBufferedImage, StringUtil.isBlankNoExactly(imageType) ? "jpg" : imageType, thumbnailOutputStream);
            if (flag) {
                imageByte = thumbnailOutputStream.toByteArray();
            }
        }catch(Exception ex){
            logger.error("生成缩略图失败",ex);
        }finally{
            if (null != buffin){
                try {
                    buffin.close();
                    buffin = null;
                } catch (Exception ex) {
                }
            }
            if (null != thumbnailOutputStream){
                try {
                    thumbnailOutputStream.close();
                    thumbnailOutputStream = null;
                } catch (Exception ex) {
                }
            }
            if (null != nailBufferedImage){
                try {
                    nailBufferedImage.flush();
                    nailBufferedImage = null;
                } catch (Exception ex) {
                }
            }
            if (null != orgBufferedImage){
                try {
                    orgBufferedImage.flush();
                    orgBufferedImage = null;
                } catch (Exception ex) {
                }
            }
        }
        return imageByte;
    }


    /**
     *
     * @param avatarWidth,缩略图的宽度
     * @param imgBase64,头像base64 data
     * @param imageType
     * @return
     */
    public  byte[] getAvatarThumbnailByImgBase64(int avatarWidth,String imgBase64, float inX, float inY, float inWidth, float inHeight,String imageType){
        byte[] imageByte = new byte[0];
        /**获取图像数据*/
        ByteArrayOutputStream thumbnailOutputStream = new ByteArrayOutputStream();
        BufferedImage nailBufferedImage = null;
        BufferedImage orgBufferedImage = null;
        InputStream buffin = null;
        try{
            orgBufferedImage = (BufferedImage)Base64Util.GenerateImage(imgBase64);
            int imageOrgWidth = orgBufferedImage.getWidth();
            int imageOrgHeight = orgBufferedImage.getHeight();
            int x = Math.round(inX * imageOrgWidth);
            int y = Math.round(inY * imageOrgHeight);
            int width = Math.round(inWidth * imageOrgWidth);
            int height = Math.round(inHeight * imageOrgHeight);
            nailBufferedImage = Thumbnails.of(orgBufferedImage).sourceRegion(x, y, width, height)/** 裁剪人脸图像 */
                    .scale((float)avatarWidth / imageOrgWidth).asBufferedImage();
            boolean flag = ImageIO.write(nailBufferedImage, StringUtil.isBlankNoExactly(imageType) ? "jpg" : imageType, thumbnailOutputStream);
            if (flag) {
                imageByte = thumbnailOutputStream.toByteArray();
            }
        }catch(Exception ex){
            logger.error("生成缩略图失败",ex);
        }finally{
            if (null != buffin){
                try {
                    buffin.close();
                    buffin = null;
                } catch (Exception ex) {
                }
            }
            if (null != thumbnailOutputStream){
                try {
                    thumbnailOutputStream.close();
                    thumbnailOutputStream = null;
                } catch (Exception ex) {
                }
            }
            if (null != nailBufferedImage){
                try {
                    nailBufferedImage.flush();
                    nailBufferedImage = null;
                } catch (Exception ex) {
                }
            }
            if (null != orgBufferedImage){
                try {
                    orgBufferedImage.flush();
                    orgBufferedImage = null;
                } catch (Exception ex) {
                }
            }
        }
        return imageByte;
    }
}
