package com.zyz.serviceverificationcode.controller;

import com.zyz.internalcommon.dao.ResponseResult;
import com.zyz.internalcommon.response.NumberCodeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数字代码控制器
 *
 * @author zhang
 * @date 2022/10/11
 */
@RestController
public class NumberCodeController {

    /**
     * 数字验证码
     *
     * @param size 大小
     * @return {@link ResponseResult}
     */
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
