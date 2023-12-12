package com.w08e.xiaomai.api.model.dto;

import com.w08e.xiaomai.common.result.Command;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

/**
 * @Author: jinyuewang
 * @Date: 2023/12/5 10:59
 */

@Getter
public class UserCommand extends Command {

    private String mail;
    private String mobile;
    @NotBlank(message = "姓名不能为空")
    private String name;
    @NotBlank(message = "密码不能为空")
    private String password;
    @NotBlank(message = "用户登录号不能为空")
    private String userName;
}
