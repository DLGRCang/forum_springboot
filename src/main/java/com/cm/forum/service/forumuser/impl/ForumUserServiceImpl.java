package com.cm.forum.service.forumuser.impl;

import ink.wgink.common.base.DefaultBaseService;
import ink.wgink.pojo.ListPage;
import ink.wgink.pojo.result.SuccessResult;
import ink.wgink.pojo.result.SuccessResultList;
import ink.wgink.service.user.pojo.vos.UserVO;
import ink.wgink.service.user.service.IUserService;
import ink.wgink.util.map.HashMapUtil;
import ink.wgink.util.UUIDUtil;
import com.cm.forum.dao.forumuser.IForumUserDao;
import com.cm.forum.pojo.dtos.forumuser.ForumUserDTO;
import com.cm.forum.pojo.vos.forumuser.ForumUserVO;
import com.cm.forum.pojo.bos.forumuser.ForumUserBO;
import com.cm.forum.pojo.pos.forumuser.ForumUserPO;
import com.cm.forum.service.forumuser.IForumUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName: ForumUserServiceImpl
 * @Description: 
 * @Author: CodeFactory
 * @Date: 2021-12-15 16:23:26
 * @Version: 3.0
 **/
@Service
public class ForumUserServiceImpl extends DefaultBaseService implements IForumUserService {

    @Autowired
    private IForumUserDao forumUserDao;

    @Autowired
    private IUserService userService;

    @Override
    public void save(ForumUserVO forumUserVO) {
        saveReturnId(forumUserVO);
    }

    @Override
    public void save(String token, ForumUserVO forumUserVO) {
        saveReturnId(token, forumUserVO);
    }

    @Override
    public String saveReturnId(ForumUserVO forumUserVO) {
        return saveReturnId(null, forumUserVO);
    }

    @Override
    public String saveReturnId(String token, ForumUserVO forumUserVO) {
        UserVO userVo = new UserVO();
        userVo.setUserUsername(forumUserVO.getUserUsername());
        userVo.setUserPassword(forumUserVO.getUserPassword());
        String userId = userService.saveAndReturnId(userVo, true);



        Map<String, Object> params = HashMapUtil.beanToMap(forumUserVO);
        params.put("forumUserId", userId);
        if (StringUtils.isBlank(token)) {
            setSaveInfo(params);
        } else {
            setAppSaveInfo(token, params);
        }
        forumUserDao.save(params);
        return userId;
    }

    @Override
    public void remove(List<String> ids) {
        remove(null, ids);
    }

    @Override
    public void remove(String token, List<String> ids) {
        Map<String, Object> params = getHashMap(2);
        params.put("forumUserIds", ids);
        if (StringUtils.isBlank(token)) {
            setUpdateInfo(params);
        } else {
            setAppUpdateInfo(token, params);
        }
        forumUserDao.remove(params);
    }

    @Override
    public void delete(List<String> ids) {
        Map<String, Object> params = getHashMap(2);
        params.put("forumUserIds", ids);
        forumUserDao.delete(params);
    }

    @Override
    public void update(String forumUserId, ForumUserVO forumUserVO) {
        update(null, forumUserId, forumUserVO);
    }

    @Override
    public void update(String token, String forumUserId, ForumUserVO forumUserVO) {
        Map<String, Object> params = HashMapUtil.beanToMap(forumUserVO);
        params.put("forumUserId", forumUserId);
        if (StringUtils.isBlank(token)) {
            setUpdateInfo(params);
        } else {
            setAppUpdateInfo(token, params);
        }
        forumUserDao.update(params);
    }

    @Override
    public ForumUserDTO get(Map<String, Object> params) {
        return forumUserDao.get(params);
    }

    @Override
    public ForumUserDTO get(String forumUserId) {
        Map<String, Object> params = super.getHashMap(2);
        params.put("forumUserId", forumUserId);
        return get(params);
    }

    @Override
    public ForumUserBO getBO(Map<String, Object> params) {
        return forumUserDao.getBO(params);
    }

    @Override
    public ForumUserBO getBO(String forumUserId) {
        Map<String, Object> params = super.getHashMap(2);
        params.put("forumUserId", forumUserId);
        return getBO(params);
    }

    @Override
    public ForumUserPO getPO(Map<String, Object> params) {
        return forumUserDao.getPO(params);
    }

    @Override
    public ForumUserPO getPO(String forumUserId) {
        Map<String, Object> params = super.getHashMap(2);
        params.put("forumUserId", forumUserId);
        return getPO(params);
    }

    @Override
    public List<ForumUserDTO> list(Map<String, Object> params) {
        return forumUserDao.list(params);
    }

    @Override
    public List<ForumUserBO> listBO(Map<String, Object> params) {
        return forumUserDao.listBO(params);
    }

    @Override
    public List<ForumUserPO> listPO(Map<String, Object> params) {
        return forumUserDao.listPO(params);
    }

    @Override
    public SuccessResultList<List<ForumUserDTO>> listPage(ListPage page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        List<ForumUserDTO> forumUserDTOs = list(page.getParams());
        PageInfo<ForumUserDTO> pageInfo = new PageInfo<>(forumUserDTOs);
        return new SuccessResultList<>(forumUserDTOs, pageInfo.getPageNum(), pageInfo.getTotal());
    }

    @Override
    public Integer count(Map<String, Object> params) {
        Integer count = forumUserDao.count(params);
        return count == null ? 0 : count;
    }

}