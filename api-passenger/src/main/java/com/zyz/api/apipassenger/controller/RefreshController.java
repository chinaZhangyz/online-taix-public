package com.zyz.api.apipassenger.controller;


import com.zyz.api.apipassenger.service.TokenService;
import com.zyz.internalcommon.dto.ResponseResult;
import com.zyz.internalcommon.response.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefreshController {
    @Autowired
    private TokenService tokenService;

    @PostMapping("/token-refresh")
    public ResponseResult refreshToken(@RequestBody TokenResponse tokenResponse){

        String refreshToken = tokenResponse.getRefreshToken();
        System.out.println("生成原来的 refreshToken"+refreshToken);
        return tokenService.refreshToken(refreshToken);
    }
}
 