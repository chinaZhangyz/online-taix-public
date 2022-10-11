package com.zyz.api.apipassenger.controller;

import com.zyz.internalcommon.dto.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
     *
     * @return {@link ResponseResult}
     *///没有token
    @GetMapping("/noauthTest")
    public ResponseResult noauthTest(){
        return ResponseResult.success("noauth test");
    }
}
