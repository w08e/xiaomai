package com.w08e.xiaomai.domain.aggregate.userdomain.repository;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.w08e.xiaomai.domain.aggregate.userdomain.UserAddress;
import com.w08e.xiaomai.domain.aggregate.userdomain.convert.UserMapper;
import com.w08e.xiaomai.infrastructure.db.model.QUserAdresssEntity;
import com.w08e.xiaomai.infrastructure.db.model.UserAdresssEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author: jinyuewang
 * @Date: 2023/12/4 15:58
 */

@Repository
public class UserAdressRepository {

    private final EntityManager em;

    public UserAdressRepository(EntityManager em) {
        this.em = em;
    }

    /**
     * 仅供聚合根user仓库使用
     * return Long
     */
    protected Long save(UserAdresssEntity entity) {
        UserAdresssEntity afterSave = em.merge(entity);
        return afterSave.getId();
    }

    public Optional<UserAddress> load(Long id) {
        return Optional.of(em.find(UserAdresssEntity.class, id)).map(UserMapper::entity2Domain);
    }

    public Optional<List<UserAddress>> getByUserId(Long userId) {

        List<UserAdresssEntity> entities = query(t -> t.userId.eq(userId)).fetch();
        if (CollectionUtils.isEmpty(entities)) {
            return Optional.empty();
        }
        return Optional.of(entities.stream().map(UserMapper::entity2Domain).collect(Collectors.toList()));
    }


    private JPAQuery<UserAdresssEntity> query(Function<QUserAdresssEntity, Predicate> condition) {
        QUserAdresssEntity t = QUserAdresssEntity.userAdresssEntity;
        return new JPAQueryFactory(em)
                .select(t)
                .from(t)
                .where(t.isDeleted.isFalse().and(condition.apply(t)));
    }

}
