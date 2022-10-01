package com.zyz.api.apipassenger.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
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
        TokenResult tokenResult = null;


        try {
           tokenResult = JwtUtils.parseToken(token);
        } catch (SignatureVerificationException e) {
            resultString = "token sign error";
            result = false;
        } catch (TokenExpiredException e) {
            resultString = "token time out";
            result = false;
        } catch (AlgorithmMismatchException e) {
            resultString = "token AlgorithmMismatchException";
            result = false;
        } catch (Exception e) {
            resultString = "token invalid";
            result = false;
        }


        if (tokenResult == null) {
            resultString = "token invalid";
            result = false;
        } else {
            //从redis中取出token
            String phone = tokenResult.getPhone();
            String identity = tokenResult.getIdentity();
            String tokenKey = RedisPrefixUtils.generatorTokenKey(phone, identity);
            String tokenRedis = stringRedisTemplate.opsForValue().get(tokenKey);
            if (StringUtils.isBlank(tokenRedis)) {
                resultString = "access token invalid";
                result =  false;
            } else {
                if (!token.trim().equals(tokenRedis.trim())) {
                    resultString = "token invalid";
                    result = false;
                }
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

