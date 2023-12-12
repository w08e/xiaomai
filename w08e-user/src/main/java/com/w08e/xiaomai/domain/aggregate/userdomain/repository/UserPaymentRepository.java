package com.w08e.xiaomai.domain.aggregate.userdomain.repository;


import ch.qos.logback.classic.spi.EventArgUtil;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import com.w08e.xiaomai.domain.aggregate.userdomain.UserPayment;
import com.w08e.xiaomai.domain.aggregate.userdomain.convert.UserMapper;
import com.w08e.xiaomai.infrastructure.db.model.QUserPaymentEntity;
import com.w08e.xiaomai.infrastructure.db.model.UserPaymentEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;


import javax.persistence.EntityManager;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * @Author: jinyuewang
 * @Date: 2023/12/4 15:58
 */

@Repository
public class UserPaymentRepository {

    private final EntityManager em;

    public UserPaymentRepository(EntityManager em) {
        this.em = em;
    }

    /**
     * 仅供聚合根user仓库使用
     */
    protected Long save(UserPaymentEntity entity) {
        UserPaymentEntity afterSave = em.merge(entity);
        return afterSave.getId();
    }

    public Optional<UserPayment> load(Long id) {
        return Optional.ofNullable(em.find(UserPaymentEntity.class, id)).map(UserMapper::entity2Domain);
    }


    public Optional<List<UserPayment>> getByUserId(Long userId) {

        List<UserPaymentEntity> entities = query(t -> t.userId.eq(userId)).fetch();
        if (CollectionUtils.isEmpty(entities)) {
            return Optional.empty();
        }
        return Optional.of(entities.stream().map(UserMapper::entity2Domain).collect(Collectors.toList()));
    }


    private JPAQuery<UserPaymentEntity> query(Function<QUserPaymentEntity, Predicate> condition) {
        QUserPaymentEntity t = QUserPaymentEntity.userPaymentEntity;
        return new JPAQueryFactory(em)
                .select(t)
                .from(t)
                .where(t.isDeleted.isFalse().and(condition.apply(t)));
    }


}
