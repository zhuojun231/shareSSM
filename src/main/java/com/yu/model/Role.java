package com.yu.model;

import java.util.List;

/**
 * @ClassName Role
 * @Description TODO
 * @Author yuzhuojun
 * Date 2020/9/27 14:28
 */
public class Role {
    private Integer id;
    private String roleName;
    private String roleDesc;
    private List<Permission> permissions;
    private List<User> users;
}
