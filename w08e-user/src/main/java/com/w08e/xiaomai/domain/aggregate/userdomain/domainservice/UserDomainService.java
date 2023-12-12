package com.w08e.xiaomai.domain.aggregate.userdomain.domainservice;


import com.w08e.xiaomai.common.exception.ServiceException;
import com.w08e.xiaomai.domain.aggregate.userdomain.User;
import com.w08e.xiaomai.domain.aggregate.userdomain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * @Author: jinyuewang
 * @Date: 2023/12/5 10:50
 */
@Service
@RequiredArgsConstructor
public class UserDomainService {

    private final UserRepository userRepository;

    /**
     * 创建
     */
    public User create(OffsetDateTime lastLoginTime, String mail, String mobile, String name, String password, String userName) {
        if (password.length() < 6) {
            throw new ServiceException("password.length.Illegal");
        }
        if (Objects.isNull(mobile) && Objects.isNull(mail)) {
            throw new ServiceException("mail & mobile.not.null");
        }
        if (Objects.nonNull(mobile) && userRepository.existByMobile(mobile)) {
            throw new ServiceException("mobile.exist");
        }
        if (Objects.nonNull(mail) && userRepository.existByMail(mail)) {
            throw new ServiceException("mail.exist");
        }
        User user = new User(lastLoginTime, mail, mobile, name, password, userName);
        userRepository.save(user);
        return user;
    }

    /**
     * 修改
     */
    public Long modify(User user, String mail, String mobile, String name) {
        if (Objects.isNull(user)) {
            throw new ServiceException("user.not.exist");
        }
        if (Objects.nonNull(mobile) && !mobile.equals(user.getMobile()) && userRepository.existByMobile(mobile)) {
            throw new ServiceException("mobile.exist");
        }
        if (Objects.nonNull(mail) && !mail.equals(user.getMail()) && userRepository.existByMail(mail)) {
            throw new ServiceException("mail.exist");
        }
        if (userRepository.existByMail(mail)) {
            throw new ServiceException("Name.exist");
        }
        user.update(mail, mobile, name);
        userRepository.save(user);
        return user.getId();
    }

    /**
     * 修改密码
     */
    public void modifyPassword(User user, String oldPassword, String newPassword) {
        if (Objects.isNull(user)) {
            throw new ServiceException("user.not.exist");
        }
        if (Objects.equals(user.getPassword(), oldPassword)) {
            throw new ServiceException("oldPassword.error");
        }
        if (Objects.equals(oldPassword, newPassword)) {
            throw new ServiceException("newPassword.same");
        }
        user.updatePassword(oldPassword, newPassword);
        userRepository.save(user);
    }
}
