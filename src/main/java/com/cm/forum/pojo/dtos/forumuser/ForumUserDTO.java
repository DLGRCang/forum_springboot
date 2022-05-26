package com.cm.forum.pojo.dtos.forumuser;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @ClassName: ForumUserDTO
 * @Description: 
 * @Author: CodeFactory
 * @Date: 2021-12-15 16:23:26
 * @Version: 3.0
 **/
@ApiModel
public class ForumUserDTO {

    @ApiModelProperty(name = "forumUserId", value = "")
    private String forumUserId;
    @ApiModelProperty(name = "forumUserSex", value = "性别")
    private String forumUserSex;
    @ApiModelProperty(name = "forumUserBirthday", value = "生日")
    private String forumUserBirthday;
    @ApiModelProperty(name = "forumUserStaffid", value = "员工id")
    private String forumUserStaffid;
    @ApiModelProperty(name = "forumUserInductionTime", value = "入职日期")
    private String forumUserInductionTime;
    @ApiModelProperty(name = "forumUserDepartment", value = "所属部门")
    private String forumUserDepartment;
    @ApiModelProperty(name = "forumUserPosition", value = "职位")
    private String forumUserPosition;
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
    @ApiModelProperty(name = "forumUserAvatar", value = "头像")
    private String forumUserAvatar;
    @ApiModelProperty(name = "forumUserName", value = "姓名")
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
