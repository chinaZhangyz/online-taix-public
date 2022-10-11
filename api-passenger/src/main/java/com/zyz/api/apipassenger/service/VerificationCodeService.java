package com.zyz.api.apipassenger.service;

import com.zyz.api.apipassenger.remote.ServicePassengerUserClient;
import com.zyz.api.apipassenger.remote.ServiceVerifivationCodeClient;
import com.zyz.internalcommon.constant.CommonStatusEnum;
import com.zyz.internalcommon.constant.IdentityConstant;
import com.zyz.internalcommon.constant.TokenConstants;
import com.zyz.internalcommon.dto.ResponseResult;
import com.zyz.internalcommon.request.VerificationCodeDTO;
import com.zyz.internalcommon.response.NumberCodeResponse;
import com.zyz.internalcommon.response.TokenResponse;
import com.zyz.internalcommon.util.JwtUtils;
import com.zyz.internalcommon.util.RedisPrefixUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 验证码服务
 *
 * @author zhang
 * @date 2022/10/11
 */
@Service
public class VerificationCodeService {
    @Autowired
    private ServiceVerifivationCodeClient serviceVerifivationCodeClient;

    @Autowired
    private ServicePassengerUserClient passengerUserClient;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    /**
     * 代码生成器
     *
     * @param passengerPhone 乘客电话
     * @return {@link ResponseResult}
     */
    public ResponseResult generatorCode(String passengerPhone) {

        //调用验证码服务，获取验证码
        System.out.println("调用验证码服务，获取验证码");
        ResponseResult<NumberCodeResponse> numberCodeResponse = serviceVerifivationCodeClient.getNumberCode(6);
        String numberCode = numberCodeResponse.getData().getNumberCode();
        System.out.println("remote number code：" + numberCode);

        String key = RedisPrefixUtils.generatorKeyByPhone(passengerPhone);

        //存入redis
        stringRedisTemplate.opsForValue().set(key, numberCode+"", 2, TimeUnit.HOURS);
        //通过服务商，将验证码发送到手机上 阿里短信服务
       /*
       *
       *
       * */
        return ResponseResult.success("");
    }

    /**
     * 校验码
     *
     * @param passengerPhone   乘客电话
     * @param verificationCode 验证码
     * @return {@link ResponseResult}
     */
    public ResponseResult checkCode(String passengerPhone,String verificationCode) {
        //根据手机号，去redis读取验证码
        //生成key
        String key = RedisPrefixUtils.generatorKeyByPhone(passengerPhone);
        String codeRedis = stringRedisTemplate.opsForValue().get(key);

        System.out.println(codeRedis);
        System.out.println("redis中的key是："+codeRedis);
        //效验验证码
        if (StringUtils.isBlank(codeRedis)||!verificationCode.trim().equals(codeRedis.trim())){
            return ResponseResult.fail(CommonStatusEnum.VERIFICATION_CODE_ERROR.getCode(),CommonStatusEnum.VERIFICATION_CODE_ERROR.getValue());
        }
        //判断原来是否有用户，并进行对应处理
        System.out.println("判断原来是否有用户，并进行对应处理:");
        VerificationCodeDTO verificationCodeDTO = new VerificationCodeDTO();
        verificationCodeDTO.setPassengerPhone(passengerPhone);
        verificationCodeDTO.setPassengerPhone(passengerPhone);
        passengerUserClient.loginRegister(verificationCodeDTO);
        //颁发令牌
//        System.out.println("颁发令牌：");
        //不能使用魔法值 ，使用枚举类 或者class
        String accessToken = JwtUtils.generatorToken(passengerPhone, IdentityConstant.PASSENGER_IDENTITY, TokenConstants.ACCESS_TOKEN_TYPE);
        String refreshToken = JwtUtils.generatorToken(passengerPhone, IdentityConstant.PASSENGER_IDENTITY, TokenConstants.REFRESH_TOKEN_TYPE);


        String accessTokenKey = RedisPrefixUtils.generatorTokenKey(passengerPhone, IdentityConstant.PASSENGER_IDENTITY, TokenConstants.ACCESS_TOKEN_TYPE);
        stringRedisTemplate.opsForValue().set(accessTokenKey, accessToken,30,TimeUnit.DAYS);

        String refreshTokenKey = RedisPrefixUtils.generatorTokenKey(passengerPhone, IdentityConstant.PASSENGER_IDENTITY, TokenConstants.REFRESH_TOKEN_TYPE);
        stringRedisTemplate.opsForValue().set(refreshTokenKey, refreshToken,31,TimeUnit.DAYS);

        //响应token
        TokenResponse tokenResponse  = new TokenResponse();
        tokenResponse.setAccessToken(accessToken);
        tokenResponse.setRefreshToken(refreshToken);

        return ResponseResult.success(tokenResponse);
    }
}
