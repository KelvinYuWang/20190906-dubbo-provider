package com.aaa.dubbo.service.impl;

import com.aaa.dubbo.mapper.UserMapper;
import com.aaa.dubbo.model.User;
import com.aaa.dubbo.service.IUserService;
import com.aaa.dubbo.statuscode.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserService
 * @Author 王宇
 * @Date 2019/8/16 23:39
 * @Version 1.0
 */
@Service(timeout = 5000)
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    /**
     * 通过账号和密码查询用户信息
     * @param user
     * @return
     */
    @Override
    public Map<String, Object> selectUserByUsernameAndPassword(User user) {
        Map<String, Object> resultMap=new HashMap<String,Object>();
        User u=userMapper.selectUserByUsernameAndPassword(user);
        //null写前面是为了防止空指针异常
        if (null!=u&&!"".equals(u.getUsername())){
            resultMap.put("code", StatusEnum.SUCCESS.getCode());
            resultMap.put("result",u);
        }else {
            resultMap.put("code",StatusEnum.FAILED.getCode());
        }
        return resultMap;
    }

}
