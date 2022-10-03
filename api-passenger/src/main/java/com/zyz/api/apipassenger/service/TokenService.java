package com.zyz.api.apipassenger.service;

import com.zyz.internalcommon.dto.ResponseResult;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    public ResponseResult refreshToken(String refreshTokenSrc){
        //解析refreshToken

        //读取redis中token


        //效验refreshToken

        //生成双token

        return  null;
    }
}
