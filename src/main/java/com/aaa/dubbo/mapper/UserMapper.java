package com.aaa.dubbo.mapper;

import com.aaa.dubbo.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    /**
     * 登陆
     * 根据用户名和密码查询
     * @param user
     * @return
     */
    User selectUserByUsernameAndPassword(User user);
}