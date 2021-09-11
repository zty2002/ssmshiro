package com.zking.service.impl;

import com.zking.mapper.UserMapper;
import com.zking.model.User;
import com.zking.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Integer userid) {
        return userMapper.deleteByPrimaryKey(userid);
    }

    @Override
    public int insert(User record) {
        return  userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return 0;
    }

    @Override
    public User selectByPrimaryKey(User user) {
        return userMapper.selectByPrimaryKey(user);
    }


    @Override
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public Set<String> selpermibyuname(String username) {
        return userMapper.selpermibyuname(username);
    }
}
