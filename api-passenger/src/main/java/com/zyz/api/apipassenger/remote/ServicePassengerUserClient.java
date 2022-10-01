package com.zyz.api.apipassenger.remote;

import com.zyz.internalcommon.dto.ResponseResult;
import com.zyz.internalcommon.request.VerificationCodeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.xml.ws.Response;

@FeignClient("service-passenger-user")
public interface ServicePassengerUserClient {

    @RequestMapping(method = RequestMethod.POST,value = "/user")
    public ResponseResult loginRegister(@RequestBody VerificationCodeDTO verificationCodeDTO);
}
