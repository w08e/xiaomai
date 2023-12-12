package com.w08e.xiaomai.infrastructure.db.model;

import com.w08e.xiaomai.common.result.BaseEntity;
import com.w08e.xiaomai.domain.share.enums.PayType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

/**
 * @author jinyueWang
 * @date 2023/8/1
 */
@EqualsAndHashCode(callSuper = true)
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
    private PayType type;

    @Comment("支付方式账户")
    @Column(name = "account")
    private String account;

    @Comment("是否默认支付方式")
    @Column(name = "is_default")
    private Boolean isDefault;


}
