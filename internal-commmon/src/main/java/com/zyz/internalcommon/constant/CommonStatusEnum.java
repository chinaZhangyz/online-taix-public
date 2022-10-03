package com.zyz.internalcommon.constant;


import lombok.Getter;

public enum CommonStatusEnum {

    VERIFICATION_CODE_ERROR(1099,"验证码不正确"),
    /*
    * 成功
    */

    /*
    * token类提示：1100-1199
    * */
    TOKEN_ERROE(1199,"token 错误"),

    /*用户不纯在类提示：1200-1299
    * */
    USER_NOT_EXIT(1200,"当前用户不存在"),


    SUCCESS(1,"success"),
    /*
    * 失败
    * */

    FAIL(0,"fail");
    @Getter
    private Integer code;
    @Getter
    private String value;

    CommonStatusEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }
}
