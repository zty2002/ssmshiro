package com.zking.mapper;

import com.zking.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(User user);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    Set<String> selpermibyuname(String username);
}