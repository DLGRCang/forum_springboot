package com.cm.forum.dao.forumuser;

import ink.wgink.exceptions.RemoveException;
import ink.wgink.exceptions.SaveException;
import ink.wgink.exceptions.SearchException;
import ink.wgink.exceptions.UpdateException;
import com.cm.forum.pojo.bos.forumuser.ForumUserBO;
import com.cm.forum.pojo.pos.forumuser.ForumUserPO;
import com.cm.forum.pojo.dtos.forumuser.ForumUserDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: IForumUserDao
 * @Description: 
 * @Author: CodeFactory
 * @Date: 2021-12-15 16:23:26
 * @Version: 3.0
 **/
@Repository
public interface IForumUserDao {

    /**
     * 新增
     *
     * @param params
     * @throws SaveException
     */
    void save(Map<String, Object> params) throws SaveException;

    /**
     * 删除
     *
     * @param params
     * @throws RemoveException
     */
    void remove(Map<String, Object> params) throws RemoveException;

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
    ForumUserDTO get(Map<String, Object> params) throws SearchException;

    /**
     * 详情
     *
     * @param params
     * @return
     * @throws SearchException
     */
    ForumUserBO getBO(Map<String, Object> params) throws SearchException;

    /**
     * 详情
     *
     * @param params
     * @return
     * @throws SearchException
     */
    ForumUserPO getPO(Map<String, Object> params) throws SearchException;

    /**
     * 列表
     *
     * @param params
     * @return
     * @throws SearchException
     */
    List<ForumUserDTO> list(Map<String, Object> params) throws SearchException;

    /**
     * 列表
     *
     * @param params
     * @return
     * @throws SearchException
     */
    List<ForumUserBO> listBO(Map<String, Object> params) throws SearchException;

    /**
     * 列表
     *
     * @param params
     * @return
     * @throws SearchException
     */
    List<ForumUserPO> listPO(Map<String, Object> params) throws SearchException;

    /**
     * 统计
     *
     * @param params
     * @return
     * @throws SearchException
     */
    Integer count(Map<String, Object> params) throws SearchException;

}