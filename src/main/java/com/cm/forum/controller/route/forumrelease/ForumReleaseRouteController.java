package com.cm.forum.controller.route.forumrelease;

import ink.wgink.common.base.DefaultBaseController;
import ink.wgink.interfaces.consts.ISystemConstant;
import com.cm.forum.service.forumrelease.IForumReleaseService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ForumReleaseController
 * @Description: 
 * @Author: CodeFactory
 * @Date: 2021-12-16 15:42:04
 * @Version: 3.0
 **/
@Api(tags = ISystemConstant.ROUTE_TAGS_PREFIX + "路由")
@RestController
@RequestMapping(ISystemConstant.ROUTE_PREFIX + "/forum-release")
public class ForumReleaseRouteController extends DefaultBaseController {

    @GetMapping("save")
    public ModelAndView save() {
        return new ModelAndView("forum-release/save");
    }

    @GetMapping("update")
    public ModelAndView update() {
        return new ModelAndView("forum-release/update");
    }

    @GetMapping("list")
    public ModelAndView list() {
        return new ModelAndView("forum-release/list");
    }

}