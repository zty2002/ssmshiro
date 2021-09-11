package com.zking.service;

import com.zking.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
public interface IUserService {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(User user);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    Set<String> selpermibyuname(String username);
}