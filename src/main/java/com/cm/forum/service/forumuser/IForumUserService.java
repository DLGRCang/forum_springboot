package com.cm.forum.service.forumuser;

import ink.wgink.pojo.ListPage;
import ink.wgink.pojo.result.SuccessResultList;
import com.cm.forum.pojo.dtos.forumuser.ForumUserDTO;
import com.cm.forum.pojo.vos.forumuser.ForumUserVO;
import com.cm.forum.pojo.bos.forumuser.ForumUserBO;
import com.cm.forum.pojo.pos.forumuser.ForumUserPO;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: IForumUserService
 * @Description: 
 * @Author: CodeFactory
 * @Date: 2021-12-15 16:23:26
 * @Version: 3.0
 **/
public interface IForumUserService {

    /**
     * 新增
     *
     * @param forumUserVO
     * @return
     */
    void save(ForumUserVO forumUserVO);

    /**
     * 新增
     *
     * @param token
     * @param forumUserVO
     * @return
     */
    void save(String token, ForumUserVO forumUserVO);

    /**
     * 新增
     *
     * @param forumUserVO
     * @return forumUserId
     */
    String saveReturnId(ForumUserVO forumUserVO);

    /**
     * 新增
     *
     * @param token
     * @param forumUserVO
     * @return forumUserId
     */
    String saveReturnId(String token, ForumUserVO forumUserVO);

    /**
     * 删除
     *
     * @param ids id列表
     * @return
     */
    void remove(List<String> ids);


    /**
     * 删除
     *
     * @param token
     * @param ids id列表
     * @return
     */
    void remove(String token, List<String> ids);

    /**
     * 删除（物理删除）
     *
     * @param ids id列表
     */
    void delete(List<String> ids);

    /**
     * 修改
     *
     * @param forumUserId
     * @param forumUserVO
     * @return
     */
    void update(String forumUserId, ForumUserVO forumUserVO);

    /**
     * 修改
     *
     * @param token
     * @param forumUserId
     * @param forumUserVO
     * @return
     */
    void update(String token, String forumUserId, ForumUserVO forumUserVO);

    /**
     * 详情
     *
     * @param params 参数Map
     * @return
     */
    ForumUserDTO get(Map<String, Object> params);

    /**
     * 详情
     *
     * @param forumUserId
     * @return
     */
    ForumUserDTO get(String forumUserId);

    /**
     * 详情
     *
     * @param params 参数Map
     * @return
     */
    ForumUserBO getBO(Map<String, Object> params);

    /**
     * 详情
     *
     * @param forumUserId
     * @return
     */
    ForumUserBO getBO(String forumUserId);

    /**
     * 详情
     *
     * @param params 参数Map
     * @return
     */
    ForumUserPO getPO(Map<String, Object> params);

    /**
     * 详情
     *
     * @param forumUserId
     * @return
     */
    ForumUserPO getPO(String forumUserId);

    /**
     * 列表
     *
     * @param params
     * @return
     */
    List<ForumUserDTO> list(Map<String, Object> params);

    /**
     * 列表
     *
     * @param params
     * @return
     */
    List<ForumUserBO> listBO(Map<String, Object> params);

    /**
     * 列表
     *
     * @param params
     * @return
     */
    List<ForumUserPO> listPO(Map<String, Object> params);

    /**
     * 分页列表
     *
     * @param page
     * @return
     */
    SuccessResultList<List<ForumUserDTO>> listPage(ListPage page);

    /**
     * 统计
     *
     * @param params
     * @return
     */
    Integer count(Map<String, Object> params);

}