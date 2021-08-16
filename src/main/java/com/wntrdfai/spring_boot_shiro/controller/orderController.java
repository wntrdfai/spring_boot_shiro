package com.wntrdfai.spring_boot_shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wntrdfai
 * @Packagecom.wntrdfai.spring_boot_shiro.controller
 * @date 2021/8/13 12:52
 * 作用:
 */
@Controller
@RequestMapping("order")
public class orderController {
    @RequestMapping("save")
//    @RequiresRoles("admin")  //用来判断角色，只有admin能访问这个方法
    @RequiresRoles(value = {"admin", "user"})  //同时具有admin，user可以访问
    @RequiresPermissions("user:update:01")//用来判断权限字符串
    public String save() {
        System.out.println("进入方法 ");
//        //获取主体对象
//        Subject subject = SecurityUtils.getSubject();
//        //代码方式
//        if (subject.hasRole("admin")) {
//            System.out.println("保存订单");
//        } else {
//            System.out.println("无权访问");
//        }
        //基于权限字符串
        return "redirect:/index.jsp";
    }
}
