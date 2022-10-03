package com.zyz.api.apipassenger.interceptor;

import com.zyz.internalcommon.constant.TokenConstants;
import com.zyz.internalcommon.dto.ResponseResult;
import com.zyz.internalcommon.dto.TokenResult;
import com.zyz.internalcommon.util.JwtUtils;
import com.zyz.internalcommon.util.RedisPrefixUtils;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


public class JwtInterceptor implements HandlerInterceptor {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        boolean result = true;

        String token = request.getHeader("Authorization");
        String resultString = "";

        //解析token
        TokenResult tokenResult = JwtUtils.checkToken(token);

        if (tokenResult == null) {
            resultString = "token invalid";
            result = false;
        } else {
            //从redis中取出token
            String phone = tokenResult.getPhone();
            String identity = tokenResult.getIdentity();
            String tokenKey = RedisPrefixUtils.generatorTokenKey(phone, identity, TokenConstants.ACCESS_TOKEN_TYPE);
            String tokenRedis = stringRedisTemplate.opsForValue().get(tokenKey);
            if ((StringUtils.isBlank(tokenRedis))||(!token.trim().equals(tokenRedis.trim())) ){
                resultString = "access token invalid";
                result =  false;
            }
        }

        //比较我们传入的token和redis中的token是否相等
        if (!result) {
            PrintWriter out = response.getWriter();
            out.print(JSONObject.fromObject(ResponseResult.fail(resultString)).toString());
        }
        return result;
    }

}

