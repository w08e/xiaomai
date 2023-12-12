package com.w08e.xiaomai.infrastructure.db.model;

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
@Table(name = "user_address")
public class UserAdresssEntity extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "name")
    private String name;

    @Comment("省")
    @Column(name = "province")
    private String province;

    @Comment("市")
    @Column(name = "city")
    private String city;

    @Comment("区")
    @Column(name = "district")
    private String district;

    @Comment("详细地址")
    @Column(name = "detail")
    private String detail;

    @Comment("手机号")
    @Column(name = "phone")
    private String phone;

    @Comment("是否默认地址")
    @Column(name = "is_default")
    private Boolean isDefault;

}
