package com.xq.service;

import com.xq.entity.SysUser;

public interface SysUserService {
    SysUser selectByUname(String uname);
}
