package com.zyz.api.apipassenger.remote;

import com.zyz.internalcommon.dto.PassengerUser;
import com.zyz.internalcommon.dto.ResponseResult;
import com.zyz.internalcommon.request.VerificationCodeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.xml.ws.Response;

@FeignClient("service-passenger-user")
public interface ServicePassengerUserClient {

    /**
     * 登录注册
     *
     * @param verificationCodeDTO 验证码dto
     * @return {@link ResponseResult}
     */
    @RequestMapping(method = RequestMethod.POST,value = "/user")
    public ResponseResult loginRegister(@RequestBody VerificationCodeDTO verificationCodeDTO);


    /**
     * 获取用户通过电话
     *
     * @param phone 电话
     * @return {@link ResponseResult}<{@link PassengerUser}>
     */
    @RequestMapping(method = RequestMethod.GET,value = "/user/{phone}")
    public ResponseResult<PassengerUser> getUserByPhone(@PathVariable("phone") String phone);
}
