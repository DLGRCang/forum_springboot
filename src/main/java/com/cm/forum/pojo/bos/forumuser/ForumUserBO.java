package com.cm.forum.pojo.bos.forumuser;

/**
 *
 * @ClassName: ForumUserBO
 * @Description: 
 * @Author: CodeFactory
 * @Date: 2021-12-15 16:23:26
 * @Version: 3.0
 **/
public class ForumUserBO {

    private String forumUserId;
    private String forumUserSex;
    private String forumUserBirthday;
    private String forumUserStaffid;
    private String forumUserInductionTime;
    private String forumUserDepartment;
    private String forumUserPosition;
    private String creator;
    private String gmtCreate;
    private String modifier;
    private String gmtModified;
    private Integer isDelete;
    private String forumUserAvatar;
    private String forumUserName;

    public String getForumUserId() {
        return forumUserId == null ? "" : forumUserId.trim();
    }

    public void setForumUserId(String forumUserId) {
        this.forumUserId = forumUserId;
    }

    public String getForumUserSex() {
        return forumUserSex == null ? "" : forumUserSex.trim();
    }

    public void setForumUserSex(String forumUserSex) {
        this.forumUserSex = forumUserSex;
    }

    public String getForumUserBirthday() {
        return forumUserBirthday == null ? "" : forumUserBirthday.trim();
    }

    public void setForumUserBirthday(String forumUserBirthday) {
        this.forumUserBirthday = forumUserBirthday;
    }

    public String getForumUserStaffid() {
        return forumUserStaffid == null ? "" : forumUserStaffid.trim();
    }

    public void setForumUserStaffid(String forumUserStaffid) {
        this.forumUserStaffid = forumUserStaffid;
    }

    public String getForumUserInductionTime() {
        return forumUserInductionTime == null ? "" : forumUserInductionTime.trim();
    }

    public void setForumUserInductionTime(String forumUserInductionTime) {
        this.forumUserInductionTime = forumUserInductionTime;
    }

    public String getForumUserDepartment() {
        return forumUserDepartment == null ? "" : forumUserDepartment.trim();
    }

    public void setForumUserDepartment(String forumUserDepartment) {
        this.forumUserDepartment = forumUserDepartment;
    }

    public String getForumUserPosition() {
        return forumUserPosition == null ? "" : forumUserPosition.trim();
    }

    public void setForumUserPosition(String forumUserPosition) {
        this.forumUserPosition = forumUserPosition;
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

    public String getForumUserAvatar() {
        return forumUserAvatar == null ? "" : forumUserAvatar.trim();
    }

    public void setForumUserAvatar(String forumUserAvatar) {
        this.forumUserAvatar = forumUserAvatar;
    }

    public String getForumUserName() {
        return forumUserName == null ? "" : forumUserName.trim();
    }

    public void setForumUserName(String forumUserName) {
        this.forumUserName = forumUserName;
    }


}
