package com.zyz.internalcommon.request;

import lombok.Data;

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
