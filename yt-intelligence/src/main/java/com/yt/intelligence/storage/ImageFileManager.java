package com.yt.intelligence.storage;

import com.yt.intelligence.CommonResponse;

/**
 * Created by yantong on 2019/1/8.
 * 图片文件管理器
 * TODO 1 还未加入远程权限验证
 */
public interface ImageFileManager {

    /**
     * 上传图片文件到指定文件夹
     * @param parentPath                远程父文件夹路径
     * @param fileContent               文件内容
     * @param toGenerateThumbnail       是否生成缩略图
     * @return {@link CommonResponse} businessContent 字段返回 imageId
     */
    CommonResponse uploadImageFile(String parentPath, byte[] fileContent, boolean toGenerateThumbnail);

    /**
     * 获取图片文件元数据
     * @param ImageFileId                   图片文件唯一标识
     * @return
     */
    ImageFileMetadata getImageFileMetadata(String ImageFileId);
}
