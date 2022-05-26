package com.cm.forum.controller.app.api.forumrelease;

import com.cm.forum.pojo.dtos.forumuser.ForumUserDTO;
import com.cm.forum.service.forumuser.IForumUserService;
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
import com.cm.forum.pojo.dtos.forumrelease.ForumReleaseDTO;
import com.cm.forum.pojo.vos.forumrelease.ForumReleaseVO;
import com.cm.forum.service.forumrelease.IForumReleaseService;
import ink.wgink.service.user.pojo.dtos.AppUserDTO;
import ink.wgink.service.user.service.IUserService;
import ink.wgink.util.ReflectUtil;
import io.swagger.annotations.*;
import jdk.nashorn.internal.runtime.Undefined;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ForumReleaseAppController
 * @Description: 
 * @Author: CodeFactory
 * @Date: 2021-12-16 15:42:04
 * @Version: 3.0
 **/
@Api(tags = ISystemConstant.API_TAGS_APP_PREFIX + "接口")
@RestController
@RequestMapping(ISystemConstant.APP_PREFIX + "/release/forum-release")
public class ForumReleaseAppController extends DefaultBaseController {

    @Autowired
    private IForumReleaseService forumReleaseService;

    @ApiOperation(value = "审核", notes = "审核接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "ID列表，用下划线分隔", paramType = "path", example = "1_2_3")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @PostMapping("aboutAndFail/{ids}")
    public SuccessResult about(@PathVariable("ids") String ids,String type,String feedback) {
        forumReleaseService.about(Arrays.asList(ids.split("\\_")),type,feedback);
        return new SuccessResult();
    }

    @ApiOperation(value = "新增", notes = "新增接口")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "token", value = "token", paramType = "header")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @PostMapping("save")
    @CheckRequestBodyAnnotation
    public SuccessResult save(@RequestBody ForumReleaseVO forumReleaseVO) throws ReflectUtil.ReflectException {
        forumReleaseService.save(null, forumReleaseVO);
        return new SuccessResult();
    }

    @ApiOperation(value = "草稿", notes = "新增草稿接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", paramType = "header")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @PostMapping("draft")
    @CheckRequestBodyAnnotation
    public SuccessResult draft(@RequestBody ForumReleaseVO forumReleaseVO) throws ReflectUtil.ReflectException{
        forumReleaseService.draft(forumReleaseVO);
        return new SuccessResult();
    }

    @ApiOperation(value = "收藏", notes = "新增收藏")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", paramType = "header")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @PostMapping("collection")
    @CheckRequestBodyAnnotation
    public SuccessResult collection(@RequestBody ForumReleaseVO forumReleaseVO){

        forumReleaseService.collection(forumReleaseVO);
        return new SuccessResult();
    }

    @ApiOperation(value = "取消收藏", notes = "取消收藏")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", paramType = "header")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @PostMapping("cancelCollection")
    @CheckRequestBodyAnnotation
    public SuccessResult cancelCollection(@RequestBody ForumReleaseVO forumReleaseVO){

        forumReleaseService.cancelCollection(forumReleaseVO);
        return new SuccessResult();
    }

    @ApiOperation(value = "删除(id列表)", notes = "删除(id列表)接口")
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @DeleteMapping("draftRemove")
    public SuccessResult draftRemove(String ids) {
        forumReleaseService.draftRemoves(ids);
        return new SuccessResult();
    }

    @ApiOperation(value = "删除草稿", notes = "删除草稿")
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @DeleteMapping("removes")
    public SuccessResult releaseRemove(String ids) {
        forumReleaseService.removes(ids);
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
        forumReleaseService.remove(token, Arrays.asList(ids.split("\\_")));
        return new SuccessResult();
    }

    @ApiOperation(value = "修改", notes = "修改接口")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "token", value = "token", paramType = "header"),
        @ApiImplicitParam(name = "forumReleaseId", value = "ID", paramType = "path")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @PutMapping("updateforumrelease/{forumReleaseId}")
    @CheckRequestBodyAnnotation
    public SuccessResult updateForumRelease(@RequestHeader("token") String token, @PathVariable("forumReleaseId") String forumReleaseId, @RequestBody ForumReleaseVO forumReleaseVO) {
        forumReleaseService.update(token, forumReleaseId, forumReleaseVO);
        return new SuccessResult();
    }

    @ApiOperation(value = "详情(通过ID)", notes = "详情(通过ID)接口")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "token", value = "token", paramType = "header"),
        @ApiImplicitParam(name = "forumReleaseId", value = "ID", paramType = "path")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("get/{forumReleaseId}")
    public ForumReleaseDTO get(@RequestHeader("token") String token, @PathVariable("forumReleaseId") String forumReleaseId) {
        Map<String, Object> params = requestParams();
        AppTokenUser appTokenUser = AppTokenManager.getInstance().parseToAppTokenUser(token);
        String forumUserId = appTokenUser.getId();
        params.put("userId",forumUserId);
        ForumReleaseDTO forumReleaseDTO = forumReleaseService.get(forumReleaseId);

        ForumReleaseDTO forumRelease = forumReleaseService.myCollectionYN(forumUserId, forumReleaseId);
        if(forumRelease != null){
            forumReleaseDTO.setIsDelete(1);
            return forumReleaseDTO;
        }else {
            return forumReleaseDTO;
        }

    }

    @ApiOperation(value = "列表", notes = "列表接口")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "token", value = "token", paramType = "header")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("list")
    public List<ForumReleaseDTO> list(@RequestHeader("token") String token) {
        Map<String, Object> params = requestParams();
        return forumReleaseService.list(params);
    }

    @ApiOperation(value = "自己的列表", notes = "查询自己的列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", paramType = "header")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("myList")
    public List<ForumReleaseDTO> myList(String forumUserId,String type){
        return forumReleaseService.myList(forumUserId,type);
    }

    @ApiOperation(value = "自己的草稿", notes = "查询自己的草稿")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", paramType = "header")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("myDraft")
    public List<ForumReleaseDTO> myDraft(String forumUserId){
        return forumReleaseService.myDraft(forumUserId);
    }

    @ApiOperation(value = "自己的收藏", notes = "查询自己的收藏")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", paramType = "header")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("myCollection")
    public List<ForumReleaseDTO> myCollection(String forumUserId){
        return forumReleaseService.myCollection(forumUserId);
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
    public SuccessResultList<List<ForumReleaseDTO>> listPage(@RequestHeader("token") String token, ListPage page) {
        Map<String, Object> params = requestParams();
        if("1".equals(params.get("type"))){

            if(params.get("keyup").equals("null")){
                page.setParams(params);
                return forumReleaseService.listPage(page);
            }else {
                params.put("keywords",params.get("keyup"));
                page.setParams(params);
                return forumReleaseService.listPage(page);
            }
        }else {
            AppTokenUser appTokenUser = AppTokenManager.getInstance().parseToAppTokenUser(token);
            params.put("userId",appTokenUser.getId());
            page.setParams(params);
            return forumReleaseService.listPage(page);
        }
    }


    @ApiOperation(value = "统计", notes = "统计接口")
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("count")
    SuccessResultData<Integer> count() {
        Map<String, Object> params = requestParams();
        return new SuccessResultData<>(forumReleaseService.count(params));
    }

}