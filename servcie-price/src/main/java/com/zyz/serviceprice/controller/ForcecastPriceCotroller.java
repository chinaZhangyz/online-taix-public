package com.zyz.serviceprice.controller;

import com.zyz.internalcommon.dao.ResponseResult;
import com.zyz.internalcommon.request.ForecastPriceDTO;
import com.zyz.serviceprice.service.ForecastPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 价格控制器
 *
 * @author zhang
 * @date 2022/10/17
 */
@RestController
public class ForcecastPriceCotroller {

    @Autowired
    private ForecastPriceService forecastPriceService;
    /**
     * 预估价格
     *
     * @param forecastPriceDTO 预测价格dto
     * @return {@link ResponseResult}
     */
    @PostMapping("/foececast-price")
    public ResponseResult forecastPrice(@RequestBody ForecastPriceDTO forecastPriceDTO){
        String depLongitude = forecastPriceDTO.getDepLongitude();
        String depLatitude = forecastPriceDTO.getDepLatitude();
        String destLongitude = forecastPriceDTO.getDestLongitude();
        String destLatitude = forecastPriceDTO.getDestLatitude();

        return forecastPriceService.forecastPrice(depLongitude,depLatitude,destLongitude,destLatitude);
    }
}
