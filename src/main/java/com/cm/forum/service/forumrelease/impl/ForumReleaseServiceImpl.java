package com.cm.forum.service.forumrelease.impl;

import ink.wgink.common.base.DefaultBaseService;
import ink.wgink.pojo.ListPage;
import ink.wgink.pojo.result.SuccessResultList;
import ink.wgink.util.date.DateUtil;
import ink.wgink.util.map.HashMapUtil;
import ink.wgink.util.UUIDUtil;
import com.cm.forum.dao.forumrelease.IForumReleaseDao;
import com.cm.forum.pojo.dtos.forumrelease.ForumReleaseDTO;
import com.cm.forum.pojo.vos.forumrelease.ForumReleaseVO;
import com.cm.forum.pojo.bos.forumrelease.ForumReleaseBO;
import com.cm.forum.pojo.pos.forumrelease.ForumReleasePO;
import com.cm.forum.service.forumrelease.IForumReleaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName: ForumReleaseServiceImpl
 * @Description: 
 * @Author: CodeFactory
 * @Date: 2021-12-16 15:42:04
 * @Version: 3.0
 **/
@Service
public class ForumReleaseServiceImpl extends DefaultBaseService implements IForumReleaseService {

    @Autowired
    private IForumReleaseDao forumReleaseDao;

    @Override
    public void save(ForumReleaseVO forumReleaseVO) {
        saveReturnId(forumReleaseVO);
    }

    @Override
    public void draft(ForumReleaseVO forumReleaseVO) {
        draftReturnId(forumReleaseVO);
    }

    @Override
    public void save(String token, ForumReleaseVO forumReleaseVO) {
        saveReturnId(token, forumReleaseVO);
    }

    @Override
    public String saveReturnId(ForumReleaseVO forumReleaseVO) {
        return saveReturnId(null, forumReleaseVO);
    }

    public void cancelCollection(ForumReleaseVO forumReleaseVO){
        Map<String, Object> params = HashMapUtil.beanToMap(forumReleaseVO);
        forumReleaseDao.cancelCollection(params);
    }

    public String collection(ForumReleaseVO forumReleaseVO) {
        Map<String, Object> params = HashMapUtil.beanToMap(forumReleaseVO);
        String currentDate = DateUtil.getTime();
        params.put("creator", forumReleaseVO.getForumUserId());
        params.put("gmtCreate", currentDate);
        params.put("modifier", forumReleaseVO.getForumUserId());
        params.put("gmtModified", currentDate);
        params.put("isDelete", 0);
        forumReleaseDao.collection(params);
        return forumReleaseVO.getForumUserId();
    }


    public String draftReturnId(ForumReleaseVO forumReleaseVO) {
        String forumReleaseId = UUIDUtil.getUUID();
        Map<String, Object> params = HashMapUtil.beanToMap(forumReleaseVO);
        params.put("forumReleaseId", forumReleaseId);
        String currentDate = DateUtil.getTime();
        params.put("creator", forumReleaseVO.getForumUserId());
        params.put("gmtCreate", currentDate);
        params.put("modifier", forumReleaseVO.getForumUserId());
        params.put("gmtModified", currentDate);
        params.put("isDelete", 0);
        forumReleaseDao.draft(params);
        return forumReleaseId;
    }

    @Override
    public String saveReturnId(String token, ForumReleaseVO forumReleaseVO) {
        String forumReleaseId = UUIDUtil.getUUID();
        Map<String, Object> params = HashMapUtil.beanToMap(forumReleaseVO);
        params.put("forumReleaseId", forumReleaseId);
    /*    if (StringUtils.isBlank(token)) {
            setSaveInfo(params);
        } else {
            setAppSaveInfo(token, params);
        }*/
        String currentDate = DateUtil.getTime();
        params.put("creator", forumReleaseVO.getForumUserId());
        params.put("gmtCreate", currentDate);
        params.put("modifier", forumReleaseVO.getForumUserId());
        params.put("gmtModified", currentDate);
        params.put("isDelete", 0);
        params.put("type", "0");
        forumReleaseDao.save(params);
        return forumReleaseId;
    }



    @Override
    public void remove(List<String> ids) {
        remove(null, ids);
    }
    @Override
    public void about(List<String> ids,String type,String feedback) {
        Map<String, Object> params = getHashMap(2);
        params.put("forumReleaseIds", ids);
        params.put("type", type);
        params.put("feedback", feedback);

        forumReleaseDao.about(params);
    }

    @Override
    public void remove(String token, List<String> ids) {
        Map<String, Object> params = getHashMap(2);
        params.put("forumReleaseIds", ids);
        if (StringUtils.isBlank(token)) {
            setUpdateInfo(params);
        } else {
            setAppUpdateInfo(token, params);
        }
        forumReleaseDao.remove(params);
    }

    @Override
    public void removes(String ids) {
        forumReleaseDao.removes(ids);
    }

    @Override
    public void draftRemoves(String ids) {
        forumReleaseDao.draftRemoves(ids);
    }

    @Override
    public void delete(List<String> ids) {
        Map<String, Object> params = getHashMap(2);
        params.put("forumReleaseIds", ids);
        forumReleaseDao.delete(params);
    }

    @Override
    public void update(String forumReleaseId, ForumReleaseVO forumReleaseVO) {
        update(null, forumReleaseId, forumReleaseVO);
    }

    @Override
    public void update(String token, String forumReleaseId, ForumReleaseVO forumReleaseVO) {
        Map<String, Object> params = HashMapUtil.beanToMap(forumReleaseVO);
        params.put("forumReleaseId", forumReleaseId);
        if (StringUtils.isBlank(token)) {
            setUpdateInfo(params);
        } else {
            setAppUpdateInfo(token, params);
        }
        forumReleaseDao.update(params);
    }

    @Override
    public ForumReleaseDTO get(Map<String, Object> params) {
        return forumReleaseDao.get(params);
    }

    @Override
    public ForumReleaseDTO get(String forumReleaseId) {
        Map<String, Object> params = super.getHashMap(2);
        params.put("forumReleaseId", forumReleaseId);
        return get(params);
    }

    @Override
    public ForumReleaseBO getBO(Map<String, Object> params) {
        return forumReleaseDao.getBO(params);
    }

    @Override
    public ForumReleaseBO getBO(String forumReleaseId) {
        Map<String, Object> params = super.getHashMap(2);
        params.put("forumReleaseId", forumReleaseId);
        return getBO(params);
    }

    @Override
    public ForumReleasePO getPO(Map<String, Object> params) {
        return forumReleaseDao.getPO(params);
    }

    @Override
    public ForumReleasePO getPO(String forumReleaseId) {
        Map<String, Object> params = super.getHashMap(2);
        params.put("forumReleaseId", forumReleaseId);
        return getPO(params);
    }

    @Override
    public List<ForumReleaseDTO> list(Map<String, Object> params) {
        return forumReleaseDao.list(params);
    }

    @Override
    public List<ForumReleaseDTO> adminList(Map<String, Object> params) {
        return forumReleaseDao.adminList(params);
    }


    @Override
    public List<ForumReleaseDTO> myList(String forumUserId,String type) {
        return forumReleaseDao.myList(forumUserId,type);
    }

    @Override
    public List<ForumReleaseDTO> myDraft(String forumUserId) {
        return forumReleaseDao.myDraft(forumUserId);
    }

    @Override
    public List<ForumReleaseDTO> myCollection(String forumUserId) {
        return forumReleaseDao.myCollection(forumUserId);
    }

    @Override
    public ForumReleaseDTO myCollectionYN(String forumUserId,String forumReleaseId) {
        return forumReleaseDao.myCollectionYN(forumUserId,forumReleaseId);
    }

    @Override
    public List<ForumReleaseBO> listBO(Map<String, Object> params) {
        return forumReleaseDao.listBO(params);
    }

    @Override
    public List<ForumReleasePO> listPO(Map<String, Object> params) {
        return forumReleaseDao.listPO(params);
    }

    @Override
    public SuccessResultList<List<ForumReleaseDTO>> listPage(ListPage page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        List<ForumReleaseDTO> forumReleaseDTOs = list(page.getParams());
        PageInfo<ForumReleaseDTO> pageInfo = new PageInfo<>(forumReleaseDTOs);
        return new SuccessResultList<>(forumReleaseDTOs, pageInfo.getPageNum(), pageInfo.getTotal());
    }

    @Override
    public SuccessResultList<List<ForumReleaseDTO>> adminListPage(ListPage page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        List<ForumReleaseDTO> forumReleaseDTOs = adminList(page.getParams());
        PageInfo<ForumReleaseDTO> pageInfo = new PageInfo<>(forumReleaseDTOs);
        return new SuccessResultList<>(forumReleaseDTOs, pageInfo.getPageNum(), pageInfo.getTotal());
    }

    @Override
    public Integer count(Map<String, Object> params) {
        Integer count = forumReleaseDao.count(params);
        return count == null ? 0 : count;
    }

}