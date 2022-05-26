package com.cm.forum.pojo.bos.forumrelease;

/**
 *
 * @ClassName: ForumReleaseBO
 * @Description: 
 * @Author: CodeFactory
 * @Date: 2021-12-16 15:42:04
 * @Version: 3.0
 **/
public class ForumReleaseBO {

    private String forumReleaseId;
    private String releaseTitle;
    private String releaseContent;
    private String releaseCoverPhoto;
    private String releaseIntroduce;
    private String creator;
    private String gmtCreate;
    private String modifier;
    private String gmtModified;
    private Integer isDelete;
    private String forumUserId;
    private String type;
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
