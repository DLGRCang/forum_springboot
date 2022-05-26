package com.cm.forum.pojo.vos.forumuser;

import ink.wgink.annotation.CheckEmptyAnnotation;
import ink.wgink.annotation.CheckNumberAnnotation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @ClassName: ForumUserVO
 * @Description: 
 * @Author: CodeFactory
 * @Date: 2021-12-15 16:23:26
 * @Version: 3.0
 **/
@ApiModel
public class ForumUserVO {
    @ApiModelProperty(name = "userUsername", value = "账号")
    private String userUsername;
    @ApiModelProperty(name = "userPassword", value = "密码")
    private String userPassword;
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
    @ApiModelProperty(name = "forumUserAvatar", value = "头像")
    private String forumUserAvatar;
    @ApiModelProperty(name = "forumUserName", value = "姓名")
    private String forumUserName;

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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
