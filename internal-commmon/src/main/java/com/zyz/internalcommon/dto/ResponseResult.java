package com.zyz.internalcommon.dto;

import com.zyz.internalcommon.constant.CommonStatusEnum;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ResponseResult<T> {

    private Integer code;
    private String message;
    private T data;

/*
* 成功的方法
* */
    public static <T> ResponseResult success(){
        return new ResponseResult().setCode(CommonStatusEnum.SUCCESS.getCode()).setMessage(CommonStatusEnum.SUCCESS.getValue());
    }
    /*
     * 成功方法
     * data
     * */
    public static <T> ResponseResult success(T data) {
        return new ResponseResult().setCode(CommonStatusEnum.SUCCESS.getCode()).setMessage(CommonStatusEnum.SUCCESS.getValue()).setData(data);
    }

    //统一错误返回
    public static <T> ResponseResult fail(T data){
        return new ResponseResult().setData(data);
    }
    /*
     * 失败方法
     * code message
     * */
    public static ResponseResult fail(Integer code, String message) {
        return new ResponseResult().setCode(code).setMessage(message);
    }

    /*
    * 自定义失败，错误信息，错误码，具体错误
    * */
    public static ResponseResult fail(Integer code, String message, Object data) {
        return new ResponseResult().setCode(code).setMessage(message).setData(data);
    }



}
