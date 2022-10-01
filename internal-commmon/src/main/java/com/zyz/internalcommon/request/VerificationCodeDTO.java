package com.zyz.internalcommon.request;

import lombok.Data;

@Data
public class VerificationCodeDTO {
    private String passengerPhone;
    private String verficationCode;
}
