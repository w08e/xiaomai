package com.w08e.xiaomai.api.model.dto;

import lombok.Getter;

/**
 * @Author: jinyuewang
 * @Date: 2023/12/5 10:59
 */

@Getter
public class UserEditCommand {

    private String mail;
    private String mobile;
    private String name;
    private String password;
    private String userName;
    /**
     * 是否修改基本信息 包括 mail mobile name
     * false为修改用户名密码
     */
    private Boolean isModifyBasicInformation;
}
