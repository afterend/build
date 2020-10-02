package com.xq.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xq.dao.SysUserMapper;
import com.xq.entity.SysUser;
import com.xq.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public SysUser selectByUname(String uname) {
        QueryWrapper<SysUser> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("uname", uname);
        return sysUserMapper.selectOne(queryWrapper);
    }
}
