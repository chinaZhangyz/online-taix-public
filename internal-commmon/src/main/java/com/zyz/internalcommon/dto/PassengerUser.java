package com.zyz.internalcommon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerUser {
    /**
     * id
     */
    private Long id;

    /**
     * 格林尼治时间创建
     */
    private LocalDateTime gmtCreate;

    /**
     * 格林尼治时间修改
     */
    private LocalDateTime gmtModified;

    /**
     * 乘客电话
     */
    private String passengerPhone;

    private String passengerName;

    private Byte passengerGender;

    private Byte state;

    private String profilePhoto;

}
