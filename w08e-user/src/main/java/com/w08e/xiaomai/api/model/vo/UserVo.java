package com.w08e.xiaomai.api.model.vo;

import com.w08e.xiaomai.domain.aggregate.userdomain.UserAddress;
import com.w08e.xiaomai.domain.aggregate.userdomain.UserPayment;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @Author: jinyuewang
 * @Date: 2023/12/5 11:03
 */

@Data
@Builder
public class UserVo {

    private Long id;

    private OffsetDateTime createTime;

    private Boolean isDeleted;

    private OffsetDateTime modifyTime;

    private Integer status;

    private OffsetDateTime lastLoginTime;

    private String mail;

    private String mobile;

    private String name;

    private String password;

    private String userName;

    private List<UserAddress> userAddress;

    private List<UserPayment> userPayment;
}
