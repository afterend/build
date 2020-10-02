package com.xq.controller;

import com.xq.entity.SysUser;
import com.xq.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//开启权限注解 pre在之前 post在之后
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class IndexController {

    @Autowired
    SysUserService sysUserService;

    @GetMapping("hello")
    public String hello(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        简单的获取用户信息
        UserDetails authorities = (UserDetails) authentication.getAuthorities();
        System.out.println(authorities.getAuthorities());
        System.out.println(authorities.getUsername());
        System.out.println(authorities.getPassword());
        return "hello";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @GetMapping("index")
    public String index(){
        SysUser sysUser = sysUserService.selectByUname("jiale");
        System.out.println(sysUser);
        return "index";
    }

    @GetMapping("test1")
    //    给hello加权限
//    @PreAuthorize("hasAuthority('a2')")
//    一般一个路径一个权限
    @PreAuthorize("hasAnyAuthority('a2','b1')")
    public String test1(){
        return "test1";
    }

    @GetMapping("test2")
    @PreAuthorize("hasAuthority('a4')")
    public String test2(){
        return "test2";
    }
}
