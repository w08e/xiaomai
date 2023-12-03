package com.w08e.xiaomai.domain.aggregate.userdomain.entity;

import com.w08e.xiaomai.common.result.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.time.OffsetDateTime;

/**
 * 会员折扣表
 * @Author: jinyuewang
 * @Date: 2023/12/3 18:04
 */
@Data
@Entity
@Table(name = "member_discount_voucher")
public class MemberDiscountVoucherEntity extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("会员ID")
    @Column(name = "member_id")
    private String memberId;

    @Comment("名称")
    @Column(name = "name")
    private Long name;

    @Comment("描述")
    @Column(name = "description")
    private Long description;

    @Comment("折扣")
    @Column(name = "discount")
    private Long discount;

    @Comment("开始时间")
    @Column(name = "start_time")
    private OffsetDateTime startTime;

    @Comment("结束时间")
    @Column(name = "end_time")
    private OffsetDateTime endTime;


}