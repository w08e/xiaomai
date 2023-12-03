package com.w08e.xiaomai.domain.aggregate.userdomain.entity;

import com.w08e.xiaomai.common.result.BaseEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * @author jinyueWang
 * @date 2023/8/1
 */
@Data
@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "mail")
    private String mail;

    @Column(name = "last_login_time")
    private String lastLoginTime;

}
