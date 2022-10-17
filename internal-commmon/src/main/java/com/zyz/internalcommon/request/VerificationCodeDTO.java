package com.zyz.internalcommon.request;

import lombok.Data;

/**
 * 验证码dto
 *
 * @author zhang
 * @date 2022/10/11
 */
@Data
public class VerificationCodeDTO {
    /**
     * 乘客电话
     */
    private String passengerPhone;
    /**
     * verfication代码
     */
    private String verficationCode;
}
