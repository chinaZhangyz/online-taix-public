package com.zyz.internalcommon.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.zyz.internalcommon.dto.TokenResult;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * jwt工具类
 *
 * @author zhang
 * @date 2022/10/11
 */
public class JwtUtils {

    /**
     * 标志
     */
    private static final String SIGN = "CPFzyz!@#$$";
    /**
     * jwt关键电话
     */
    private static final String JWT_KEY_PHONE = "passengerPhone";
    /**
     * jwt令牌类型
     */
    private static final String JWT_TOKEN_TYPE = "tokenType";

    /**
     * jwt关键身份
     * 乘客是1， 司机是2
     */
    private static final String JWT_KEY_IDENTITY = "identity";
    /**
     * jwt令牌时间
     */
    private static final String JWT_TOKEN_TIME = "tokenTime";


    /**
     * 发电机令牌
     *
     * @param passengerPhone 乘客电话
     * @param identity       身份
     * @param tokenType      令牌类型
     * @return {@link String}
     */
    public static String generatorToken(String passengerPhone, String identity, String tokenType) {
        Map<String, String> map = new HashMap<>();
        map.put(JWT_KEY_PHONE, passengerPhone);
        map.put(JWT_KEY_IDENTITY, identity);
        map.put(JWT_TOKEN_TYPE, tokenType);
        //token过期时间

        map.put(JWT_TOKEN_TIME,Calendar.getInstance().getTime().toString());

        JWTCreator.Builder builder = JWT.create();
        map.forEach((k, v) -> {
            builder.withClaim(k, v);
        });
        //整合过期时间
//        builder.withExpiresAt(data);
        //生成token
        String sign = builder.sign(Algorithm.HMAC256(SIGN));

        return sign;
    }


    /**
     * 解析令牌
     *
     * @param token 令牌
     * @return {@link TokenResult}
     */
    public static TokenResult parseToken(String token){
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
        String phone = verify.getClaim(JWT_KEY_PHONE).asString();
        String identity = verify.getClaim(JWT_KEY_IDENTITY).asString();

        TokenResult tokenResult = new TokenResult();
        tokenResult.setPhone(phone);
        tokenResult.setIdentity(identity);
        return tokenResult;

    }
    /**
     * 校验token，主要判断token是否异常
     * @param token
     * @return
     */
    public static TokenResult checkToken(String token){
        TokenResult tokenResult = null;
        try {
            tokenResult = JwtUtils.parseToken(token);
        }catch (Exception e){

        }
        return tokenResult;
    }
}
