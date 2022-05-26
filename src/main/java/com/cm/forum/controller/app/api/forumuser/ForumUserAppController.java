package com.cm.forum.controller.app.api.forumuser;

import ink.wgink.annotation.CheckRequestBodyAnnotation;
import ink.wgink.app.AppTokenManager;
import ink.wgink.common.base.DefaultBaseController;
import ink.wgink.exceptions.ParamsException;
import ink.wgink.interfaces.consts.ISystemConstant;
import ink.wgink.pojo.ListPage;
import ink.wgink.pojo.app.AppTokenUser;
import ink.wgink.pojo.result.ErrorResult;
import ink.wgink.pojo.result.SuccessResult;
import ink.wgink.pojo.result.SuccessResultData;
import ink.wgink.pojo.result.SuccessResultList;
import com.cm.forum.pojo.dtos.forumuser.ForumUserDTO;
import com.cm.forum.pojo.vos.forumuser.ForumUserVO;
import com.cm.forum.service.forumuser.IForumUserService;
import ink.wgink.pojo.vos.UpdatePasswordVO;
import ink.wgink.service.user.service.IUserService;
import ink.wgink.util.ReflectUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ForumUserAppController
 * @Description: 
 * @Author: CodeFactory
 * @Date: 2021-12-15 16:23:26
 * @Version: 3.0
 **/
@Api(tags = ISystemConstant.API_TAGS_APP_PREFIX + "接口")
@RestController
@RequestMapping(ISystemConstant.APP_PREFIX + "/release/forum-user")
public class ForumUserAppController extends DefaultBaseController {

    @Autowired
    private IForumUserService forumUserService;



    @PostMapping("fromUserList")
    @CheckRequestBodyAnnotation
    public ForumUserDTO fromUserList() {
        Map<String, Object> stringObjectMap = requestParams();
        AppTokenUser appTokenUser = AppTokenManager.getInstance().parseToAppTokenUser(stringObjectMap.get("token").toString());
        ForumUserDTO forumUserDTO = forumUserService.get(appTokenUser.getId());
        return forumUserDTO;
    }


    @ApiOperation(value = "新增", notes = "新增接口")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "token", value = "token", paramType = "header")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @PostMapping("save")
    @CheckRequestBodyAnnotation
    public SuccessResult save(@RequestHeader("token") String token, @RequestBody ForumUserVO forumUserVO) {
        forumUserService.save(token, forumUserVO);
        return new SuccessResult();
    }

    @ApiOperation(value = "删除(id列表)", notes = "删除(id列表)接口")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "token", value = "token", paramType = "header"),
        @ApiImplicitParam(name = "ids", value = "ID列表，用下划线分隔", paramType = "path", example = "1_2_3")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @DeleteMapping("remove/{ids}")
    public SuccessResult remove(@RequestHeader("token") String token, @PathVariable("ids") String ids) {
        forumUserService.remove(token, Arrays.asList(ids.split("\\_")));
        return new SuccessResult();
    }

    @ApiOperation(value = "修改", notes = "修改接口")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "token", value = "token", paramType = "header"),
        @ApiImplicitParam(name = "forumUserId", value = "ID", paramType = "path")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @PutMapping("updateforumuser/{forumUserId}")
    @CheckRequestBodyAnnotation
    public SuccessResult updateForumUser(@RequestHeader("token") String token, @PathVariable("forumUserId") String forumUserId, @RequestBody ForumUserVO forumUserVO) {
        forumUserService.update(token, forumUserId, forumUserVO);
        return new SuccessResult();
    }

    @ApiOperation(value = "详情(通过ID)", notes = "详情(通过ID)接口")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "token", value = "token", paramType = "header"),
        @ApiImplicitParam(name = "forumUserId", value = "ID", paramType = "path")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("get/{forumUserId}")
    public ForumUserDTO get(@RequestHeader("token") String token, @PathVariable("forumUserId") String forumUserId) {
        return forumUserService.get(forumUserId);
    }

    @ApiOperation(value = "列表", notes = "列表接口")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "token", value = "token", paramType = "header")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("list")
    public List<ForumUserDTO> list(@RequestHeader("token") String token) {
        Map<String, Object> params = requestParams();
        return forumUserService.list(params);
    }

    @ApiOperation(value = "分页列表", notes = "分页列表接口")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "token", value = "token", paramType = "header"),
        @ApiImplicitParam(name = "page", value = "当前页码", paramType = "query", dataType = "int", defaultValue = "1"),
        @ApiImplicitParam(name = "rows", value = "显示数量", paramType = "query", dataType = "int", defaultValue = "20"),
        @ApiImplicitParam(name = "keywords", value = "关键字", paramType = "query", dataType = "String"),
        @ApiImplicitParam(name = "startTime", value = "开始时间", paramType = "query", dataType = "String"),
        @ApiImplicitParam(name = "endTime", value = "结束时间", paramType = "query", dataType = "String")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("listpage")
    public SuccessResultList<List<ForumUserDTO>> listPage(@RequestHeader("token") String token, ListPage page) {
        Map<String, Object> params = requestParams();
        page.setParams(params);
        return forumUserService.listPage(page);
    }

    @ApiOperation(value = "统计", notes = "统计接口")
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("count")
    SuccessResultData<Integer> count() {
        Map<String, Object> params = requestParams();
        return new SuccessResultData<>(forumUserService.count(params));
    }


}