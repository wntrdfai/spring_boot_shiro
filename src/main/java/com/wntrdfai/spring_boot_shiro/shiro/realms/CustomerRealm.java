package com.wntrdfai.spring_boot_shiro.shiro.realms;

import com.wntrdfai.spring_boot_shiro.entity.Perms;
import com.wntrdfai.spring_boot_shiro.entity.Role;
import com.wntrdfai.spring_boot_shiro.entity.User;
import com.wntrdfai.spring_boot_shiro.service.UserService;
import com.wntrdfai.spring_boot_shiro.shiro.salt.MyByteSource;
import com.wntrdfai.spring_boot_shiro.utils.ApplicationContextUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @author wntrdfai
 * @Packagecom.wntrdfai.springbootshiro.config.shiro.realms
 * @date 2021/8/12 16:37
 * 作用:  自定义Realm
 */
public class CustomerRealm extends AuthorizingRealm {
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取身份信息
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        System.out.println("调用授权验证：" + primaryPrincipal);
        //根据主身份信息获取角色和权限信息
        UserService userService = (UserService) ApplicationContextUtils.getBean("userService");
        User user = userService.findRoleByUserName(primaryPrincipal);
        //赋值授权角色
        if (!CollectionUtils.isEmpty(user.getRoles())) {
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            user.getRoles().forEach(role -> {
                simpleAuthorizationInfo.addRole(role.getName());//添加角色信息

                //权限信息
                List<Perms> perms = userService.findPermsByRoleId(role.getId());
                if (!CollectionUtils.isEmpty(perms)) {
                    perms.forEach(perm ->{
                        simpleAuthorizationInfo.addStringPermission(perm.getName());
                    } );
                }
            });
            return simpleAuthorizationInfo;
        }
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("======================");
        //根据身份信息
        String principal = (String) authenticationToken.getPrincipal();
        //在工厂中获取service对象
        UserService userService = (UserService) ApplicationContextUtils.getBean("userService");
        System.out.println(principal);
        User user = userService.findByUserName(principal);
        if (!ObjectUtils.isEmpty(user)) {//判断是否为空
            return new SimpleAuthenticationInfo(
                    user.getUsername(),
                    user.getPassword(),
                    new MyByteSource(user.getSalt()),
                    this.getName());
        }
        return null;
    }
}
