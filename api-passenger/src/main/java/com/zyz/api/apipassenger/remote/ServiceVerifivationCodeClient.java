package com.zyz.api.apipassenger.remote;

import com.zyz.internalcommon.dao.ResponseResult;
import com.zyz.internalcommon.response.NumberCodeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("service-verification")
public interface ServiceVerifivationCodeClient {
    /**
     * 得到数字代码
     *
     * @param size 大小
     * @return {@link ResponseResult}<{@link NumberCodeResponse}>
     */
    @RequestMapping(method = RequestMethod.GET,value = "/numberCode/{size}")
    ResponseResult<NumberCodeResponse> getNumberCode(@PathVariable("size") int size);
}
