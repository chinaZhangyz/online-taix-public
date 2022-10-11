package com.zyz.api.apipassenger.controller;

import com.zyz.internalcommon.dto.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhang
 * @date 2022/10/11
 */
@RestController
public class TestController {
    /**
     * 测试
     *
     * @return {@link String}
     */
    @GetMapping("/test")
    public String test(){
        return "hello";
    }

    /**
     * 身份验证测试
     *
     * @return {@link ResponseResult}
     *///有token
    @GetMapping("/authTest")
    public ResponseResult authTest(){
        return ResponseResult.success("auth test");
    }

    /**
     * noauth测试
     * 没有token
     * @return {@link ResponseResult}
     */
    @GetMapping("/noauthTest")
    public ResponseResult noauthTest(){
        return ResponseResult.success("noauth test");
    }
}
