package com.w08e.xiaomai.domain.aggregate.userdomain;

import com.w08e.xiaomai.common.exception.ServiceException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.DigestUtils;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

/**
 * User聚合根
 *
 * @author w08e
 * @since 2023-12-04 11:02:04
 */
@Getter
@NoArgsConstructor
public class User {

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


    /**
     * 正常添加
     */
    public User(OffsetDateTime lastLoginTime, String mail, String mobile, String name, String password, String userName) {
        this.lastLoginTime = lastLoginTime;
        this.mail = mail;
        this.mobile = mobile;
        this.name = name;
        this.password = DigestUtils.md5DigestAsHex(password.getBytes());
        this.userName = userName;
        this.createTime = OffsetDateTime.now();
        this.modifyTime = OffsetDateTime.now();
        this.isDeleted = false;
    }

    /**
     * 用户地址和用户支付方式
     */
    public User(Long id, List<UserAddress> userAddress, List<UserPayment> userPayment) {
        this.id = id;
        this.userAddress = userAddress;
        this.userPayment = userPayment;
    }

    /**
     * 更新
     */
    public void update(String mail, String mobile, String name) {
        if (Objects.equals(name, this.name)) {
            throw new ServiceException("用户名不能重复");
        }
        this.mail = mail;
        this.mobile = mobile;
        this.name = name;
        this.modifyTime = OffsetDateTime.now();
    }


    /**
     * 修改密码
     */
    public void updatePassword(String oldPassword, String newPassword) {
        if (Objects.equals(newPassword, this.password)) {
            return;
        }
        this.password = password;
        this.modifyTime = OffsetDateTime.now();
    }

    public void del() {
        this.isDeleted = true;
        this.modifyTime = OffsetDateTime.now();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLastLoginTime(OffsetDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public void modiyfMail(String mail) {
        this.mail = mail;
        this.modifyTime = OffsetDateTime.now();
    }

    public void modiyfMobile(String mobile) {
        this.mobile = mobile;
        this.modifyTime = OffsetDateTime.now();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserAdress(List<UserAddress> userAddress) {
        this.userAddress = userAddress;
    }

    public void setUserPayment(List<UserPayment> userPayment) {
        this.userPayment = userPayment;
    }

    public void setCreateTime(OffsetDateTime createTime) {
        this.createTime = createTime;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public void setModifyTime(OffsetDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public static void main(String[] args) {
        System.out.println(test());
    }

    public static Integer test() {
        List<Integer> integers = List.of(1, 3, 4, 1, 6, 7);
        for (Integer integer : integers) {
            if (integer.equals(1)) {
                System.out.println(1111111111);
                return integer;
            }
        }
        return null;
    }
}

