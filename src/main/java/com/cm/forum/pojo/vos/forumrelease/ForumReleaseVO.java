package com.cm.forum.pojo.vos.forumrelease;

import ink.wgink.annotation.CheckEmptyAnnotation;
import ink.wgink.annotation.CheckNumberAnnotation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @ClassName: ForumReleaseVO
 * @Description: 
 * @Author: CodeFactory
 * @Date: 2021-12-16 15:42:04
 * @Version: 3.0
 **/
@ApiModel
public class ForumReleaseVO {

    @ApiModelProperty(name = "forumReleaseId", value = "id")
    private String forumReleaseId;
    @ApiModelProperty(name = "releaseTitle", value = "标题")
    private String releaseTitle;
    @ApiModelProperty(name = "releaseContent", value = "内容")
    private String releaseContent;
    @ApiModelProperty(name = "releaseCoverPhoto", value = "封面图")
    private String releaseCoverPhoto;
    @ApiModelProperty(name = "releaseIntroduce", value = "简介")
    private String releaseIntroduce;
    @ApiModelProperty(name = "forumUserId", value = "个人id")
    private String forumUserId;
    @ApiModelProperty(name = "collectionId", value = "收藏人id")
    private String collectionId;

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }

    public String getForumReleaseId() {
        return forumReleaseId == null ? "" : forumReleaseId.trim();
    }

    public void setForumReleaseId(String forumReleaseId) {
        this.forumReleaseId = forumReleaseId;
    }

    public String getReleaseTitle() {
        return releaseTitle == null ? "" : releaseTitle.trim();
    }

    public void setReleaseTitle(String releaseTitle) {
        this.releaseTitle = releaseTitle;
    }

    public String getReleaseContent() {
        return releaseContent == null ? "" : releaseContent.trim();
    }

    public void setReleaseContent(String releaseContent) {
        this.releaseContent = releaseContent;
    }

    public String getReleaseCoverPhoto() {
        return releaseCoverPhoto == null ? "" : releaseCoverPhoto.trim();
    }

    public void setReleaseCoverPhoto(String releaseCoverPhoto) {
        this.releaseCoverPhoto = releaseCoverPhoto;
    }

    public String getReleaseIntroduce() {
        return releaseIntroduce == null ? "" : releaseIntroduce.trim();
    }

    public void setReleaseIntroduce(String releaseIntroduce) {
        this.releaseIntroduce = releaseIntroduce;
    }

    public String getForumUserId() {
        return forumUserId == null ? "" : forumUserId.trim();
    }

    public void setForumUserId(String forumUserId) {
        this.forumUserId = forumUserId;
    }


}
