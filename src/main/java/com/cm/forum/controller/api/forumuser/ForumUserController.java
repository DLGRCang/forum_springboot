package com.cm.forum.controller.api.forumuser;

import ink.wgink.annotation.CheckRequestBodyAnnotation;
import ink.wgink.app.AppTokenManager;
import ink.wgink.common.base.DefaultBaseController;
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
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ForumUserController
 * @Description: 
 * @Author: CodeFactory
 * @Date: 2021-12-15 16:23:26
 * @Version: 3.0
 **/
@Api(tags = ISystemConstant.API_TAGS_SYSTEM_PREFIX + "接口")
@RestController
@RequestMapping(ISystemConstant.API_PREFIX + "/forum-user")
public class ForumUserController extends DefaultBaseController {

    @Autowired
    private IForumUserService forumUserService;



    @ApiOperation(value = "新增", notes = "新增接口")
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @PostMapping("save")
    @CheckRequestBodyAnnotation
    public SuccessResult save(@RequestBody ForumUserVO forumUserVO) {
        forumUserService.save(forumUserVO);
        return new SuccessResult();
    }

    @ApiOperation(value = "删除", notes = "删除接口")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "ids", value = "ID列表，用下划线分隔", paramType = "path", example = "1_2_3")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @DeleteMapping("remove/{ids}")
    public SuccessResult remove(@PathVariable("ids") String ids) {
        forumUserService.remove(Arrays.asList(ids.split("\\_")));
        return new SuccessResult();
    }

    @ApiOperation(value = "修改", notes = "修改接口")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "forumUserId", value = "ID", paramType = "path")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @PutMapping("update/{forumUserId}")
    @CheckRequestBodyAnnotation
    public SuccessResult update(@PathVariable("forumUserId") String forumUserId, @RequestBody ForumUserVO forumUserVO) {
        forumUserService.update(forumUserId, forumUserVO);
        return new SuccessResult();
    }

    @ApiOperation(value = "详情", notes = "详情接口")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "forumUserId", value = "ID", paramType = "path")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("get/{forumUserId}")
        public ForumUserDTO get(@PathVariable("forumUserId") String forumUserId) {
        return forumUserService.get(forumUserId);
    }

    @ApiOperation(value = "列表", notes = "列表接口")
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("list")
    public List<ForumUserDTO> list() {
        Map<String, Object> params = requestParams();
        return forumUserService.list(params);
    }

    @ApiOperation(value = "分页列表", notes = "分页列表接口")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "当前页码", paramType = "query", dataType = "int", defaultValue = "1"),
        @ApiImplicitParam(name = "rows", value = "显示数量", paramType = "query", dataType = "int", defaultValue = "20"),
        @ApiImplicitParam(name = "keywords", value = "关键字", paramType = "query", dataType = "String"),
        @ApiImplicitParam(name = "startTime", value = "开始时间", paramType = "query", dataType = "String"),
        @ApiImplicitParam(name = "endTime", value = "结束时间", paramType = "query", dataType = "String")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("listpage")
    public SuccessResultList<List<ForumUserDTO>> listPage(ListPage page) {
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