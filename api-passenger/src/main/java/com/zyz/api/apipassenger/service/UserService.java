package com.zyz.api.apipassenger.service;

import com.zyz.internalcommon.dto.PassengerUser;
import com.zyz.internalcommon.dto.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    public ResponseResult getUserByAccessToken(String accessToken){
        //解析accessToken 拿到手机号
        log.info("accesstoken:"+accessToken);
        //根据手机号查询用户信息
        PassengerUser passengerUser = new PassengerUser();
        passengerUser.setPassengerName("张山");
        passengerUser.setProfilePhoto("头像");
        return ResponseResult.success(passengerUser);
    }
}
