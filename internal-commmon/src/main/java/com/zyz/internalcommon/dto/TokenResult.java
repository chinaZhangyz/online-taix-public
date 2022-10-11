package com.zyz.internalcommon.dto;

import lombok.Data;

/**
 * 令牌结果
 *
 * @author zhang
 * @date 2022/10/11
 */
@Data
public class TokenResult {
     /**
      * 电话
      */
     private String phone;
     /**
      * 身份
      */
     private String identity;
}
