package com.zyz.internalcommon.dao;

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

    /**
     * 乘客名字
     */
    private String passengerName;

    /**
     * 乘客性别
     */
    private Byte passengerGender;

    /**
     * 状态
     */
    private Byte state;

    /**
     * 档案照片
     */
    private String profilePhoto;

}
