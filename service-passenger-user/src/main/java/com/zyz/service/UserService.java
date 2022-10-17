package com.zyz.service;

import com.zyz.internalcommon.constant.CommonStatusEnum;
import com.zyz.internalcommon.dao.PassengerUser;
import com.zyz.mapper.PassengerUserMapper;
import com.zyz.internalcommon.dao.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private PassengerUserMapper passengerUserMapper;

    /**
     * 登录或注册
     *
     * @param passengerPhone 乘客电话
     * @return {@link ResponseResult}
     */
    public ResponseResult loginOrRegister(String passengerPhone) {

        System.out.println("user service被调用，手机号：" + passengerPhone);

        //根据手机号查询信息
        Map<String, Object> map = new HashMap<>();
        map.put("passenger_phone", passengerPhone);
        List<PassengerUser> passengerUsers = passengerUserMapper.selectByMap(map);
//        System.out.println(passengerUsers==null?"无记录":passengerUsers.get(0).getPassengerPhone());

        if (passengerUsers.size() == 0){
            PassengerUser passengerUser = new PassengerUser();
            passengerUser.setPassengerName("张三");
            passengerUser.setPassengerGender((byte)0);
            passengerUser.setPassengerPhone(passengerPhone);
            passengerUser.setState((byte)0);
            LocalDateTime now  = LocalDateTime.now();
            passengerUser.setGmtCreate(now);
            passengerUser.setGmtModified(now);
            passengerUserMapper.insert(passengerUser);
        }

        return ResponseResult.success();

    }

    /**
     * 获取用户通过电话
     *
     * @param passengerPhone 乘客电话
     * @return {@link ResponseResult}
     */
    public ResponseResult getUserByPhone(String passengerPhone){
        Map<String,Object> map = new HashMap<>();
        map.put("passenger_Phone", passengerPhone);
        List<PassengerUser> passengerUsers = passengerUserMapper.selectByMap(map);
        if (passengerUsers.size() == 0) {
            return ResponseResult.fail(CommonStatusEnum.USER_NOT_EXIT.getCode(),CommonStatusEnum.USER_NOT_EXIT.getValue());
        }else{
            PassengerUser passengerUser = passengerUsers.get(0);
            return ResponseResult.success(passengerUser);
        }
    }

}
