package com.zyz.internalcommon.request;

import lombok.Data;

/**
 * 预测价格dto
 *
 * @author zhang
 * @date 2022/10/17
 */
@Data
public class ForecastPriceDTO {
    /**
     * 出发地经度
     */
    private String depLongitude;
    /**
     * 出发地维度
     */
    private String depLatitude;
    /**
     * 目的地经度
     */
    private String destLongitude;
    /**
     * 目的地维度
     */
    private String destLatitude;


}
