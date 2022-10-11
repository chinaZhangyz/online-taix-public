package com.zyz.internalcommon.constant;


import lombok.Getter;

public enum CommonStatusEnum {

    /**
     * 验证码错误
     */
    VERIFICATION_CODE_ERROR(1099,"验证码不正确"),

    /**
     * 令牌erroe
     */
    TOKEN_ERROE(1199,"token 错误"),


    /**
     * 用户没有退出
     */
    USER_NOT_EXIT(1200,"当前用户不存在"),


    /**
     * 成功
     */
    SUCCESS(1,"success"),

    /**
     * 失败
     */
    FAIL(0,"fail");
    @Getter
    private Integer code;
    @Getter
    private String value;

    /**
     * 常见状态枚举
     *
     * @param code  代码
     * @param value 价值
     */
    CommonStatusEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }
}
