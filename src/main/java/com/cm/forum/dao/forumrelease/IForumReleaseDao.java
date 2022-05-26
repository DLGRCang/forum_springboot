package com.cm.forum.dao.forumrelease;

import ink.wgink.exceptions.RemoveException;
import ink.wgink.exceptions.SaveException;
import ink.wgink.exceptions.SearchException;
import ink.wgink.exceptions.UpdateException;
import com.cm.forum.pojo.bos.forumrelease.ForumReleaseBO;
import com.cm.forum.pojo.pos.forumrelease.ForumReleasePO;
import com.cm.forum.pojo.dtos.forumrelease.ForumReleaseDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: IForumReleaseDao
 * @Description: 
 * @Author: CodeFactory
 * @Date: 2021-12-16 15:42:04
 * @Version: 3.0
 **/
@Repository
public interface IForumReleaseDao {

    /**
     * 新增
     *
     * @param params
     * @throws SaveException
     */
    void save(Map<String, Object> params) throws SaveException;


    void draft(Map<String, Object> params) throws SaveException;


    void collection(Map<String, Object> params);

    void cancelCollection(Map<String, Object> params);

    /**
     * 删除
     *
     * @param params
     * @throws RemoveException
     */
    void remove(Map<String, Object> params) throws RemoveException;

    void about(Map<String, Object> params) throws RemoveException;



    void removes(String ids) throws RemoveException;


    void draftRemoves(String ids) throws RemoveException;

    /**
     * 删除（物理）
     *
     * @param params
     * @throws RemoveException
     */
    void delete(Map<String, Object> params) throws RemoveException;

    /**
     * 修改
     *
     * @param params
     * @throws UpdateException
     */
    void update(Map<String, Object> params) throws UpdateException;

    /**
     * 详情
     *
     * @param params
     * @return
     * @throws SearchException
     */
    ForumReleaseDTO get(Map<String, Object> params) throws SearchException;

    /**
     * 详情
     *
     * @param params
     * @return
     * @throws SearchException
     */
    ForumReleaseBO getBO(Map<String, Object> params) throws SearchException;

    /**
     * 详情
     *
     * @param params
     * @return
     * @throws SearchException
     */
    ForumReleasePO getPO(Map<String, Object> params) throws SearchException;

    /**
     * 列表
     *
     * @param params
     * @return
     * @throws SearchException
     */
    List<ForumReleaseDTO> list(Map<String, Object> params) throws SearchException;
    List<ForumReleaseDTO> adminList(Map<String, Object> params) throws SearchException;


    List<ForumReleaseDTO> myList(@Param("forumUserId") String forumUserId,@Param("type") String type);

    List<ForumReleaseDTO> myDraft(String forumUserId);


    List<ForumReleaseDTO> myCollection(String forumUserId);

    ForumReleaseDTO myCollectionYN(@Param("forumUserId") String forumUserId,@Param("forumReleaseId")  String forumReleaseId);

    /**
     * 列表
     *
     * @param params
     * @return
     * @throws SearchException
     */
    List<ForumReleaseBO> listBO(Map<String, Object> params) throws SearchException;

    /**
     * 列表
     *
     * @param params
     * @return
     * @throws SearchException
     */
    List<ForumReleasePO> listPO(Map<String, Object> params) throws SearchException;

    /**
     * 统计
     *
     * @param params
     * @return
     * @throws SearchException
     */
    Integer count(Map<String, Object> params) throws SearchException;

}