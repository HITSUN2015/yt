package com.yt.intelligence.storage;

import java.util.Date;

/**
 * Created by yantong on 2019/1/8.
 * 图片文件元数据模型
 */
public class ImageFileMetadata {

    //文件唯一标识
    private String imageFileId;

    //图片远程地址
    private String imageUrl;

    //缩略图地址
    private String thumbnailUrl;

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;

    public String getImageFileId() {
        return imageFileId;
    }

    public void setImageFileId(String imageFileId) {
        this.imageFileId = imageFileId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
