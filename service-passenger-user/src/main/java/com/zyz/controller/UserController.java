package com.zyz.controller;

import com.zyz.internalcommon.dto.ResponseResult;
import com.zyz.internalcommon.request.VerificationCodeDTO;
import com.zyz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录或注册
     *
     * @param verificationCodeDTO 验证码dto
     * @return {@link ResponseResult}
     */
    @PostMapping("/user")
    public ResponseResult loginOrReg(@RequestBody VerificationCodeDTO verificationCodeDTO) {

        String passengerPhone = verificationCodeDTO.getPassengerPhone();
        System.out.println("手机号：" + passengerPhone);
        //根据用户手机号查询用户信息
        return userService.loginOrRegister(passengerPhone);
    }

    /**
     * 获取用户
     *
     * @param passengerPhone 乘客电话
     * @return {@link ResponseResult}
     *//*@RequestBody VerificationCodeDTO verificationCodeDTO
   *fegin 如果用RequestBody传输，会将get请求转化为post请求
   *
    */
   @GetMapping("/user/{phone}")
    public ResponseResult getUser(@PathVariable("phone") String passengerPhone) {
        System.out.println("passenger-service-phone"+passengerPhone);
        return userService.getUserByPhone(passengerPhone);
    }
}
