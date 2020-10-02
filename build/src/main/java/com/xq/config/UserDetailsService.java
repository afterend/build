package com.xq.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xq.dao.SysUserMapper;
import com.xq.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    SysUserMapper sysUserMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uname",username);
        SysUser sysUser = sysUserMapper.selectOne(queryWrapper);

//        没有的情况
        if(sysUser==null){
            System.out.println("没有此用户");
            return null;
        }

//        List<GrantedAuthority> list=new ArrayList<>();
//        第一种写法一般做角色权限使用
//        UserDetails userDetails=new User("jiale","jiale",list);

//        角色和权限认证
//        UserDetails userDetails=User.withUsername(username).password(sysUser.getUpwd()).roles("user").authorities("a1").build();

        List<String> list = sysUserMapper.selectSysUserByUid(sysUser.getUid());
//        集合转数组
        String[] array = list.toArray(new String[list.size()]);

//        权限效验
        UserDetails userDetails=User.withUsername(username).password(sysUser.getUpwd()).authorities(array).build();
        return userDetails;
    }
}
