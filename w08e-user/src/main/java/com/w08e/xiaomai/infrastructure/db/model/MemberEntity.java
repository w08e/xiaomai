package com.w08e.xiaomai.infrastructure.db.model;

import com.w08e.xiaomai.common.result.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.time.OffsetDateTime;

/**
 * @Author: jinyuewang
 * @Date: 2023/12/3 18:04
 */
@Data
@Entity
@Table(name = "member")
public class MemberEntity extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("用户id")
    @Column(name = "user_id")
    private String userId;

    @Comment("当前会员等级")
    @Column(name = "current_level")
    private Long currentLevel;

    @Comment("头像")
    @Column(name = "avatar")
    private String avatar;

    @Comment("性别")
    @Column(name = "gender")
    private Integer gender;

    @Comment("生日")
    @Column(name = "birth")
    private OffsetDateTime birth;

}