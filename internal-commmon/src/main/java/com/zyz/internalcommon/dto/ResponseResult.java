package com.zyz.internalcommon.dto;

import com.zyz.internalcommon.constant.CommonStatusEnum;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ResponseResult<T> {

    /**
     * 验证码
     */
    private Integer code;
    /**
     * 消息
     */
    private String message;
    /**
     * 数据
     */
    private T data;


    /**
     * 成功
     *
     * @return {@link ResponseResult}
     */
    public static <T> ResponseResult success(){
        return new ResponseResult().setCode(CommonStatusEnum.SUCCESS.getCode()).setMessage(CommonStatusEnum.SUCCESS.getValue());
    }

    /**
     * 成功
     *
     * @param data 数据
     * @return {@link ResponseResult}
     */
    public static <T> ResponseResult success(T data) {
        return new ResponseResult().setCode(CommonStatusEnum.SUCCESS.getCode()).setMessage(CommonStatusEnum.SUCCESS.getValue()).setData(data);
    }


    /**
     * 失败
     *
     * @param data 数据
     * @return {@link ResponseResult}
     */
    public static <T> ResponseResult fail(T data){
        return new ResponseResult().setData(data);
    }

    /**
     * 失败
     *
     * @param code    代码
     * @param message 消息
     * @return {@link ResponseResult}
     */
    public static ResponseResult fail(Integer code, String message) {
        return new ResponseResult().setCode(code).setMessage(message);
    }


    /**
     * 失败
     *
     * @param code    代码
     * @param message 消息
     * @param data    数据
     * @return {@link ResponseResult}
     */
    public static ResponseResult fail(Integer code, String message, Object data) {
        return new ResponseResult().setCode(code).setMessage(message).setData(data);
    }



}
