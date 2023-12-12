package com.w08e.xiaomai.domain.aggregate.userdomain.repository;

import cn.hutool.core.collection.CollectionUtil;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.w08e.xiaomai.domain.aggregate.userdomain.User;
import com.w08e.xiaomai.domain.aggregate.userdomain.UserAddress;
import com.w08e.xiaomai.domain.aggregate.userdomain.UserPayment;
import com.w08e.xiaomai.domain.aggregate.userdomain.convert.UserMapper;
import com.w08e.xiaomai.infrastructure.db.model.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * (User)表数据库访问层
 *
 * @author jinyuewang
 */

@Repository
@Transactional(rollbackOn = Exception.class)
public class UserRepository {
    private final EntityManager em;
    private final UserAdressRepository userAdressRepository;
    private final UserPaymentRepository userPaymentRepository;

    public UserRepository(EntityManager em, UserAdressRepository userAdressRepository, UserPaymentRepository userPaymentRepository) {
        this.em = em;
        this.userAdressRepository = userAdressRepository;
        this.userPaymentRepository = userPaymentRepository;
    }

    public void save(User user) {
        UserEntity entity = UserMapper.domain2Entity(user);
        UserEntity afterSave = em.merge(entity);
        user.setId(afterSave.getId());
    }

    public User load(Long id) {
        UserEntity userEntity = em.find(UserEntity.class, id);
        User user = UserMapper.entity2Domain(userEntity);
        Optional<List<UserAddress>> userAdresses = userAdressRepository.getByUserId(userEntity.getId());
        Optional<List<UserPayment>> userPayments = userPaymentRepository.getByUserId(userEntity.getId());
        userAdresses.ifPresent(user::setUserAdress);
        userPayments.ifPresent(user::setUserPayment);
        return user;
    }

    public Boolean existByMail(String mail) {
        List<UserEntity> entities = query(t -> t.mail.eq(mail)).fetch();
        if(CollectionUtil.isEmpty(entities)){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }   public Boolean existByName(String name) {
        List<UserEntity> entities = query(t -> t.mail.eq(name)).fetch();
        if(CollectionUtil.isEmpty(entities)){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public Boolean existByMobile(String mobile) {
        List<UserEntity> entities = query(t -> t.mail.eq(mobile)).fetch();
        if(CollectionUtil.isEmpty(entities)){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private JPAQuery<UserEntity> query(Function<QUserEntity, Predicate> condition) {
        QUserEntity t = QUserEntity.userEntity;
        return new JPAQueryFactory(em)
                .select(t)
                .from(t)
                .where(t.isDeleted.isFalse().and(condition.apply(t)));
    }

}

