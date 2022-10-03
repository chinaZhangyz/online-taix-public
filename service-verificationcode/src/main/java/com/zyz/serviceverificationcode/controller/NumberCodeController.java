package com.zyz.serviceverificationcode.controller;

import com.zyz.internalcommon.dto.ResponseResult;
import com.zyz.internalcommon.response.NumberCodeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberCodeController {

    @GetMapping("/numberCode/{size}")
    public ResponseResult numberCode(@PathVariable("size") int size) {
        System.out.println("size：" + size);
        //生成验证码
        double mathRandom = (Math.random() * 9 + 1) * Math.pow(10, size - 1);
        int resultInt = (int) mathRandom;
        System.out.println("generator src code" + resultInt);

        NumberCodeResponse response = new NumberCodeResponse();
        response.setNumberCode(resultInt + "");

        return ResponseResult.success(response);
    }

}