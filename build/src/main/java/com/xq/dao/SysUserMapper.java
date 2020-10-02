package com.xq.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xq.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    @Select("SELECT pname FROM sys_user,sys_role,sys_role_pers,sys_pers WHERE sys_user.rid=sys_role.`rid` AND sys_role.`rid`=sys_role_pers.`rid` AND sys_pers.`pid`=sys_role_pers.`pid` AND uid=#{value}")
    List<String> selectSysUserByUid(int uid);
}
