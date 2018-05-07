package com.lvhong.dao;

import java.util.Map;
import java.util.Set;

import com.lvhong.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	User findUserByPhone(Map<String, String> map);

	Set<String> findRolesByUserName(String userName);

	Set<String> findPermissionsByUserName(String userName);

}