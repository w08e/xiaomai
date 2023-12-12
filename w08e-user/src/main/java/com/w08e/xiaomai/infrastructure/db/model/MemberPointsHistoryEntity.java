package com.w08e.xiaomai.infrastructure.db.model;

import com.w08e.xiaomai.common.result.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

/**
 * @Author: jinyuewang
 * @Date: 2023/12/3 18:04
 */
@Data
@Entity
@Table(name = "member_points_history")
public class MemberPointsHistoryEntity extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("用户id")
    @Column(name = "user_id")
    private String userId;

    @Comment("积分类型 1增加 2减少")
    @Column(name = "points_type")
    private String pointsType;

    @Comment("触发积分事件")
    @Column(name = "event")
    private String event;

    @Comment("积分变更量")
    @Column(name = "points_num")
    private String points_num;


}