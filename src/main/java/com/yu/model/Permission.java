package com.yu.model;

import java.util.List;

/**
 * @ClassName Permission
 * @Description TODO
 * @Author yuzhuojun
 * Date 2020/9/27 15:14
 */
public class Permission {
    private Integer id;
    private String permissionName;
    private String url;
    private List<Role> roles;
}
