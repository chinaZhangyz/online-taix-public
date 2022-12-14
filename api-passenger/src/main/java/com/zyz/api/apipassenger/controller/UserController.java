package com.zyz.api.apipassenger.controller;

import com.zyz.api.apipassenger.service.UserService;
import com.zyz.internalcommon.dao.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户控制器
 *
 * @author zhang
 * @date 2022/10/11
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户
     *
     * @param request 请求
     * @return {@link ResponseResult}
     */
    @GetMapping("/users")
    public ResponseResult getUser(HttpServletRequest request) {
        String accessToken = request.getHeader("Authorization");

        System.out.println(accessToken);
        return userService.getUserByAccessToken(accessToken);
    }
}
