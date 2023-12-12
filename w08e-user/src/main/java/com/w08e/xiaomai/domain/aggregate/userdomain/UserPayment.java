package com.w08e.xiaomai.domain.aggregate.userdomain;

import com.w08e.xiaomai.domain.share.enums.PayType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

/**
 * (UserPayment)实体类
 *
 * @author makejava
 * @since 2023-12-04 11:02:05
 */
@Data
@NoArgsConstructor
public class UserPayment{

    private Long id;

    private OffsetDateTime createTime;

    private Boolean isDeleted;

    private OffsetDateTime modifyTime;

    private Integer status;

    /**
     * 支付方式账户
     */
    private String account;
    /**
     * 是否默认支付方式
     */
    private Boolean isDefault;
    /**
     * 支付方式类型
     */
    private PayType type;

    private Long userId;

    public UserPayment(Long id, OffsetDateTime createTime, Boolean isDeleted, OffsetDateTime modifyTime, Integer status,
                       String account, Boolean isDefault, PayType type, Long userId) {
        this.id = id;
        this.createTime = createTime;
        this.isDeleted = isDeleted;
        this.modifyTime = modifyTime;
        this.status = status;
        this.account = account;
        this.isDefault = isDefault;
        this.type = type;
        this.userId = userId;
    }

    public void update(String account, PayType payType, Boolean isDefault) {
        //todo 校验
        this.account = account;
        this.type = payType;
        this.isDefault = isDefault;
    }
}

