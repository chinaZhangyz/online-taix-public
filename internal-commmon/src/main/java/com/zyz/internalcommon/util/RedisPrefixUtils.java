package com.zyz.internalcommon.util;

/**
 * Resis跑龙套
 *
 * @author zhang
 * @date 2022/10/11
 */
public class RedisPrefixUtils {


    /**
     * 乘客验证码前缀
     */
    public static String verificationCodePrefix = "passenger-verification-code-";

    /**
     * token储存
     */
    public static String tokenPrefix = "token-";

    /**
     * 根据手机号和标识信息生成token
     *
     * @param phone     电话
     * @param identity  身份
     * @param tokenType 令牌类型
     * @return {@link String}
     */
    public static String generatorTokenKey(String phone,String identity,String tokenType){
        return tokenPrefix + phone+"-"+identity+"-"+tokenType;
    }

    /**
     * 发电机主要通过电话
     *
     * @param passengerPhone 乘客电话
     * @return {@link String}
     *///生成key
    public static String generatorKeyByPhone(String passengerPhone){
        return verificationCodePrefix+passengerPhone;
    }
}
