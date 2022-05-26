package com.cm.forum.pojo.dtos.forumrelease;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @ClassName: ForumReleaseDTO
 * @Description: 
 * @Author: CodeFactory
 * @Date: 2021-12-16 15:42:04
 * @Version: 3.0
 **/
@ApiModel
public class ForumReleaseDTO {

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
    @ApiModelProperty(name = "creator", value = "")
    private String creator;
    @ApiModelProperty(name = "gmtCreate", value = "")
    private String gmtCreate;
    @ApiModelProperty(name = "modifier", value = "")
    private String modifier;
    @ApiModelProperty(name = "gmtModified", value = "")
    private String gmtModified;
    @ApiModelProperty(name = "isDelete", value = "")
    private Integer isDelete;
    @ApiModelProperty(name = "forumUserId", value = "个人id")
    private String forumUserId;
    @ApiModelProperty(name = "userName", value = "姓名")
    private String userName;
    @ApiModelProperty(name = "collectionId", value = "收藏人id")
    private String collectionId;
    @ApiModelProperty(name = "type", value = "审核状态")
    private String type;
    @ApiModelProperty(name = "typeFeedback", value = "审核未通过反馈")
    private String typeFeedback;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeFeedback() {
        return typeFeedback;
    }

    public void setTypeFeedback(String typeFeedback) {
        this.typeFeedback = typeFeedback;
    }

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getCreator() {
        return creator == null ? "" : creator.trim();
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getGmtCreate() {
        return gmtCreate == null ? "" : gmtCreate.trim();
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getModifier() {
        return modifier == null ? "" : modifier.trim();
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getGmtModified() {
        return gmtModified == null ? "" : gmtModified.trim();
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getIsDelete() {
        return isDelete == null ? 0 : isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getForumUserId() {
        return forumUserId == null ? "" : forumUserId.trim();
    }

    public void setForumUserId(String forumUserId) {
        this.forumUserId = forumUserId;
    }


}
