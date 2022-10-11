package com.zyz.api.apipassenger.controller;


import com.zyz.api.apipassenger.service.VerificationCodeService;
import com.zyz.internalcommon.dto.ResponseResult;
import com.zyz.internalcommon.request.VerificationCodeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 验证码控制器
 *
 * @author zhang
 * @date 2022/10/11
 */
@RestController
public class VerificationCodeController {
    @Autowired
    private VerificationCodeService verificationCodeService;

    /**
     * 验证码
     *
     * @param verificationCodeDTO 验证码dto
     * @return {@link ResponseResult}
     */
    @GetMapping("/verification-code")
    public ResponseResult verificationCode(@RequestBody VerificationCodeDTO verificationCodeDTO) {
        String passengerPhone = verificationCodeDTO.getPassengerPhone();
        System.out.println("接受到的手机号：" + passengerPhone);
        return verificationCodeService.generatorCode(passengerPhone);
    }

    /**
     * 检查验证码
     *
     * @param verificationCodeDTO 验证码dto
     * @return {@link ResponseResult}
     */
    @PostMapping("/verification-code-check")
    public ResponseResult checkVerificationCode(@RequestBody VerificationCodeDTO verificationCodeDTO){
        String passengerPhone = verificationCodeDTO.getPassengerPhone();
        String verificationCode = verificationCodeDTO.getVerficationCode();
//        System.out.println("手机号："+passengerPhone+",验证码："+verificationCode);
        return verificationCodeService.checkCode(passengerPhone,verificationCode);
    }

}
