package com.zyz.api.apipassenger.service;

import com.zyz.internalcommon.dto.PassengerUser;
import com.zyz.internalcommon.dto.ResponseResult;
import com.zyz.internalcommon.dto.TokenResult;
import com.zyz.internalcommon.response.TokenResponse;
import com.zyz.internalcommon.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    public ResponseResult getUserByAccessToken(String accessToken){
        //解析accessToken 拿到手机号
        log.info("accesstoken:"+accessToken);
        //根据手机号查询用户信息
        TokenResult tokenResult = JwtUtils.checkToken(accessToken);
        String phone = tokenResult.getPhone();
        log.info("手机号："+phone);

        PassengerUser passengerUser = new PassengerUser();
        passengerUser.setPassengerName("张山");
        passengerUser.setProfilePhoto("头像");
        passengerUser.setProfilePhoto(phone);
        return ResponseResult.success(passengerUser);
    }
}
