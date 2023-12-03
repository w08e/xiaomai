package com.w08e.xiaomai.domain.aggregate.userdomain.entity;

import com.w08e.xiaomai.common.result.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

/**
 * @author jinyueWang
 * @date 2023/8/1
 */
@Data
@Entity
@Table(name = "user_payment")
public class UserPaymentEntity extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Comment("支付方式类型")
    @Column(name = "type")
    private String type;

    @Comment("支付方式账户")
    @Column(name = "account")
    private String account;

    @Comment("是否默认支付方式")
    @Column(name = "is_default")
    private Boolean isDefault;



}
