package com.xq.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
public class SysUser {
    private int uid;
    private String uname;
    private String upwd;
}
