package com.w08e.xiaomai.client.service;

import com.w08e.xiaomai.api.model.dto.UserCommand;
import com.w08e.xiaomai.api.model.dto.UserEditCommand;
import com.w08e.xiaomai.api.model.vo.UserVo;
import com.w08e.xiaomai.common.exception.ServiceException;
import com.w08e.xiaomai.domain.aggregate.userdomain.User;
import com.w08e.xiaomai.domain.aggregate.userdomain.domainservice.UserDomainService;
import com.w08e.xiaomai.domain.aggregate.userdomain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * 用户应用服务
 *
 * @author makejava
 * @since 2023-12-04 11:02:04
 */
@Service
public class UserService {
    private final UserDomainService userDomainService;
    private final UserRepository userRepository;

    public UserService(UserDomainService userDomainService, UserRepository userRepository) {
        this.userDomainService = userDomainService;
        this.userRepository = userRepository;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public UserVo queryById(Long id) {
        User load = userRepository.load(id);
        return UserVo.builder().id(load.getId())
                .createTime(load.getCreateTime())
                .isDeleted(load.getIsDeleted())
                .modifyTime(load.getModifyTime())
                .status(load.getStatus())
                .lastLoginTime(load.getLastLoginTime())
                .mail(load.getMail())
                .mobile(load.getMobile())
                .name(load.getName())
                .password(load.getPassword())
                .userName(load.getUserName())
                .userAddress(load.getUserAddress())
                .userPayment(load.getUserPayment())
                .build();
    }
//
//    /**
//     * 分页查询
//     *
//     * @param user        筛选条件
//     * @param pageRequest 分页对象
//     * @return 查询结果
//     */
//    Page<User> queryByPage(User user, PageRequest pageRequest);

    /**
     * 新增数据
     */
    public Long insert(UserCommand cmd) {
        if (cmd.getPassword().length() < 6) {
            throw new ServiceException("password.length.Illegal");
        }
        User user = userDomainService.create(OffsetDateTime.now(),
                cmd.getMail(),
                cmd.getMobile(),
                cmd.getName(),
                cmd.getPassword(),
                cmd.getUserName());

        return user.getId();
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    public Long update(UserEditCommand user, Long id) {
        User load = userRepository.load(id);
        if (Objects.isNull(load)) {
            throw new ServiceException("user.not.exist");
        }
        return userDomainService.modify(load, user.getMail(), user.getMobile(), user.getName());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public void deleteById(Long id) {
        User load = userRepository.load(id);
        if (Objects.isNull(load)) {
            throw new ServiceException("user.not.exist");
        }
        load.del();
    }



}
