package com.zyz.internalcommon.response;

import lombok.Data;

@Data
public class TokenResponse {
    /**
     * 访问令牌
     */
    private String accessToken;
    /**
     * 刷新令牌
     */
    private String refreshToken;

}
