package com.zking.shiro;

import com.zking.model.User;
import  com.zking.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class ShiroRealm  extends AuthorizingRealm {
    @Autowired
    private IUserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username= principalCollection.getPrimaryPrincipal().toString();
        Set<String> permissions = userService.selpermibyuname(username);
        SimpleAuthorizationInfo  info=new SimpleAuthorizationInfo();
        info.setStringPermissions(permissions);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取参数中提交过来的账号密码
        String username = authenticationToken.getPrincipal().toString();
        String password = authenticationToken.getCredentials().toString();
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        //通过用户账号，找到该用户在数据库中的所有数据
        User u = userService.selectByPrimaryKey(user);
        if(null==u){
            System.out.println("账号不存在1");
        }
//        //将找到的数据封装到身份验证信息类中
        SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo
                (u.getUsername(),u.getPassword(), ByteSource.Util.bytes(u.getSalt()),this.getName());
        return authenticationInfo;
    }
}
