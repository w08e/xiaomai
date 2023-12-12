package com.w08e.xiaomai.domain.aggregate.userdomain.query;

import com.blazebit.persistence.querydsl.BlazeJPAQuery;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Projections;
import com.w08e.xiaomai.common.query.QueryResult;
import com.w08e.xiaomai.infrastructure.db.model.QUserAdresssEntity;
import com.w08e.xiaomai.infrastructure.db.model.QUserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: jinyuewang
 * @Date: 2023/12/6 16:21
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class userQuery {

    public QueryResult findCats(userQueryPara userQueryPara) {
        QUserEntity user = QUserEntity.userEntity;
        QUserAdresssEntity adress = QUserAdresssEntity.userAdresssEntity;
        BooleanBuilder where = new BooleanBuilder();
        where.and(user.isDeleted.eq(false));
        BlazeJPAQuery<Map<Expression<?>, ?>> blazeJpaQuery = new BlazeJPAQuery<>();
        blazeJpaQuery = blazeJpaQuery
                .select(Projections.map(adress, user))
                .from(user)
                .leftJoin(adress).on(adress.userId.eq(user.id))
                .where(where)
                .orderBy(user.id.desc());

        long fetchCount = blazeJpaQuery.fetchCount();

        blazeJpaQuery.offset(userQueryPara.getPageNumber()).limit(userQueryPara.getPageSize());
        List<Map<Expression<?>, ?>> fetchList = blazeJpaQuery.fetch();
        return QueryResult.of(fetchList, (long) fetchList.size());
    }

}
