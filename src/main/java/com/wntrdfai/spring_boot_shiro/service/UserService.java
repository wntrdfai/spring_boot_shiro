package com.wntrdfai.spring_boot_shiro.service;

import com.wntrdfai.spring_boot_shiro.entity.Perms;
import com.wntrdfai.spring_boot_shiro.entity.Role;
import com.wntrdfai.spring_boot_shiro.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wntrdfai
 * @Packagecom.wntrdfai.springbootshiro.service
 * @date 2021/8/13 8:59
 * 作用:
 */

public interface UserService {
    //注册用户方法
    void register(User user);

    User findByUserName(String username);

    //根据用户名查询所有角色
    User findRoleByUserName(String usernaem);

    //根据角色id查询权限集合
    List<Perms> findPermsByRoleId(String id);
}
