package org.cloud.system.controller;

import javax.annotation.Resource;

import org.cloud.common.util.PageResultBean;
import org.cloud.common.util.ResultBean;
import org.cloud.system.service.IUserService;
import org.cloud.system.vo.UserOnline;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private IUserService userService;

    @GetMapping("/list")
    @ResponseBody
    public PageResultBean<UserOnline> listUsers(@RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "10") int limit) {
        return new PageResultBean<UserOnline>(userService.getOnlineUserCount(),
                userService.getOnlineUsers(page, limit));
    }

    @PostMapping("/kickout")
    @ResponseBody
    public ResultBean forceLogout(String sessionId) {
        userService.forceLogout(sessionId);
        return ResultBean.success();
    }
}
