package com.cm.forum.service.forumrelease;

import ink.wgink.pojo.ListPage;
import ink.wgink.pojo.result.SuccessResultList;
import com.cm.forum.pojo.dtos.forumrelease.ForumReleaseDTO;
import com.cm.forum.pojo.vos.forumrelease.ForumReleaseVO;
import com.cm.forum.pojo.bos.forumrelease.ForumReleaseBO;
import com.cm.forum.pojo.pos.forumrelease.ForumReleasePO;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: IForumReleaseService
 * @Description: 
 * @Author: CodeFactory
 * @Date: 2021-12-16 15:42:04
 * @Version: 3.0
 **/
public interface IForumReleaseService {

    /**
     * 新增
     *
     * @param forumReleaseVO
     * @return
     */
    void save(ForumReleaseVO forumReleaseVO);

    //    草稿
    void draft(ForumReleaseVO forumReleaseVO);



    String collection(ForumReleaseVO forumReleaseVO);


    void cancelCollection(ForumReleaseVO forumReleaseVO);
    /**
     * 新增
     *
     * @param token
     * @param forumReleaseVO
     * @return
     */
    void save(String token, ForumReleaseVO forumReleaseVO);



    /**
     * 新增
     *
     * @param forumReleaseVO
     * @return forumReleaseId
     */
    String saveReturnId(ForumReleaseVO forumReleaseVO);

    /**
     * 新增
     *
     * @param token
     * @param forumReleaseVO
     * @return forumReleaseId
     */
    String saveReturnId(String token, ForumReleaseVO forumReleaseVO);

    /**
     * 删除
     *
     * @param ids id列表
     * @return
     */
    void remove(List<String> ids);

    void about(List<String> ids , String type, String feedback);


    /**
     * 删除
     *
     * @param token
     * @param ids id列表
     * @return
     */
    void remove(String token, List<String> ids);

    void removes(String ids);

    void draftRemoves(String ids);

    /**
     * 删除（物理删除）
     *
     * @param ids id列表
     */
    void delete(List<String> ids);

    /**
     * 修改
     *
     * @param forumReleaseId
     * @param forumReleaseVO
     * @return
     */
    void update(String forumReleaseId, ForumReleaseVO forumReleaseVO);

    /**
     * 修改
     *
     * @param token
     * @param forumReleaseId
     * @param forumReleaseVO
     * @return
     */
    void update(String token, String forumReleaseId, ForumReleaseVO forumReleaseVO);

    /**
     * 详情
     *
     * @param params 参数Map
     * @return
     */
    ForumReleaseDTO get(Map<String, Object> params);

    /**
     * 详情
     *
     * @param forumReleaseId
     * @return
     */
    ForumReleaseDTO get(String forumReleaseId);

    /**
     * 详情
     *
     * @param params 参数Map
     * @return
     */
    ForumReleaseBO getBO(Map<String, Object> params);

    /**
     * 详情
     *
     * @param forumReleaseId
     * @return
     */
    ForumReleaseBO getBO(String forumReleaseId);

    /**
     * 详情
     *
     * @param params 参数Map
     * @return
     */
    ForumReleasePO getPO(Map<String, Object> params);

    /**
     * 详情
     *
     * @param forumReleaseId
     * @return
     */
    ForumReleasePO getPO(String forumReleaseId);

    /**
     * 列表
     *
     * @param params
     * @return
     */
    List<ForumReleaseDTO> list(Map<String, Object> params);
    List<ForumReleaseDTO> adminList(Map<String, Object> params);

    //查询自己的列表
    List<ForumReleaseDTO> myList(String forumUserId,String type);

    //查询自己的列表
    List<ForumReleaseDTO> myDraft(String forumUserId);


    List<ForumReleaseDTO> myCollection(String forumUserId);

    ForumReleaseDTO myCollectionYN(String forumUserId,String forumReleaseId);

    /**
     * 列表
     *
     * @param params
     * @return
     */
    List<ForumReleaseBO> listBO(Map<String, Object> params);

    /**
     * 列表
     *
     * @param params
     * @return
     */
    List<ForumReleasePO> listPO(Map<String, Object> params);

    /**
     * 分页列表
     *
     * @param page
     * @return
     */
    SuccessResultList<List<ForumReleaseDTO>> listPage(ListPage page);

    SuccessResultList<List<ForumReleaseDTO>> adminListPage(ListPage page);

    /**
     * 统计
     *
     * @param params
     * @return
     */
    Integer count(Map<String, Object> params);

}