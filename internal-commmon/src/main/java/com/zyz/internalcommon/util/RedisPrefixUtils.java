package com.zyz.internalcommon.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

public class RedisPrefixUtils {


    //乘客验证码前缀
    public static String verificationCodePrefix = "passenger-verification-code-";

    //token储存
    public static String tokenPrefix = "token-";

    //根据手机号和标识信息生成token
    public static String generatorTokenKey(String phone,String identity){
        return tokenPrefix + phone+"-"+identity;
    }

    //生成key
    public static String generatorKeyByPhone(String passengerPhone){
        return verificationCodePrefix+passengerPhone;
    }
}
