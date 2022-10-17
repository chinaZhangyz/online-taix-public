package com.zyz.api.apipassenger.controller;

import com.zyz.api.apipassenger.service.ForecastPriceService;
import com.zyz.internalcommon.dao.ResponseResult;
import com.zyz.internalcommon.request.ForecastPriceDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.zyz.internalcommon.request.ForecastPriceDTO.*;

/**
 * 价格预测控制器
 *
 * @author zhang
 * @date 2022/10/17
 */
@RestController
@Slf4j
public class ForecastPriceController {
    /**
     * 预估价格
     *
     * @return {@link ResponseResult}
     */
    @Autowired
    private ForecastPriceService forecastPriceService;

    @PostMapping("/forecast-price")
    public ResponseResult forecastPrice(@RequestBody ForecastPriceDTO forecastPriceDTO) {

        String depLongitude = forecastPriceDTO.getDepLongitude();
        String depLatitude = forecastPriceDTO.getDepLatitude();
        String destLongitude = forecastPriceDTO.getDestLongitude();
        String destLatitude = forecastPriceDTO.getDestLatitude();

        return forecastPriceService.forecastPriceService(depLongitude,depLatitude,destLongitude,destLatitude);
    }
}
