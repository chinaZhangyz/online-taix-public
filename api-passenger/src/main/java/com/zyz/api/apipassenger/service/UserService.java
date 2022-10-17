package com.zyz.api.apipassenger.service;

import com.zyz.api.apipassenger.remote.ServicePassengerUserClient;
import com.zyz.internalcommon.dao.PassengerUser;
import com.zyz.internalcommon.dao.ResponseResult;
import com.zyz.internalcommon.dao.TokenResult;
import com.zyz.internalcommon.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务
 *
 * @author zhang
 * @date 2022/10/11
 */
@Service
@Slf4j
public class UserService {

    @Autowired
    ServicePassengerUserClient servicePassengerUserClient;

    /**
     * 获取用户访问令牌
     *
     * @param accessToken 访问令牌
     * @return {@link ResponseResult}
     */
    public ResponseResult getUserByAccessToken(String accessToken){
        //解析accessToken 拿到手机号
        log.info("accesstoken:"+accessToken);
        //根据手机号查询用户信息
        TokenResult tokenResult = JwtUtils.checkToken(accessToken);
        String phone = tokenResult.getPhone();
        log.info("手机号："+phone);
        ResponseResult<PassengerUser> userByPhone = servicePassengerUserClient.getUserByPhone(phone);
        return ResponseResult.success(userByPhone.getData());
    }
}
