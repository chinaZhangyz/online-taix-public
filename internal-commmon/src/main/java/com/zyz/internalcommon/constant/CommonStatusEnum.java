package com.zyz.internalcommon.constant;


import lombok.Getter;

public enum CommonStatusEnum {

    VERIFICATION_CODE_ERROR("1099","验证码不正确"),
    /*
    * 成功
    */
    TOKEN_ERROE("1199","token error"),

    SUCCESS("1","success"),
    /*
    * 失败
    * */

    FAIL("0","fail");
    @Getter
    private String code;
    @Getter
    private String value;

    CommonStatusEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }
}
