package com.cm.forum.controller.route.forumuser;

import ink.wgink.common.base.DefaultBaseController;
import ink.wgink.interfaces.consts.ISystemConstant;
import com.cm.forum.service.forumuser.IForumUserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
@Api(tags = ISystemConstant.ROUTE_TAGS_PREFIX + "路由")
@RestController
@RequestMapping(ISystemConstant.ROUTE_PREFIX + "/forum-user")
public class ForumUserRouteController extends DefaultBaseController {

    @GetMapping("save")
    public ModelAndView save() {
        return new ModelAndView("forum-user/save");
    }

    @GetMapping("update")
    public ModelAndView update() {
        return new ModelAndView("forum-user/update");
    }

    @GetMapping("list")
    public ModelAndView list() {
        return new ModelAndView("forum-user/list");
    }

}