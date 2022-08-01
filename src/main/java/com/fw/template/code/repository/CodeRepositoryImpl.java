package com.fw.template.code.repository;

import com.fw.template.code.entity.CodeDetailEntity;
import com.fw.template.code.entity.CodeEntity;
import com.fw.template.code.entity.QCodeDetailEntity;
import com.fw.template.code.entity.QCodeEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CodeRepositoryImpl implements CodeRepositoryCustom {
    private final EntityManager em;

    public List<CodeEntity> getListByQuerydsl() {
        JPAQueryFactory query = new JPAQueryFactory(em);
        QCodeEntity codeEntity = QCodeEntity.codeEntity;

        return query.select(codeEntity)
                .from(codeEntity)
                //.join(order.member, member)
                //.where(statusEq(orderSearch.getOrderStatus()), nameLike(orderSearch.getMemberName()))
                .limit(1000)
                .fetch();
    }

    public List<CodeDetailEntity> getDetailListByQuerydsl() {
        JPAQueryFactory query = new JPAQueryFactory(em);
        QCodeEntity codeEntity = QCodeEntity.codeEntity;
        QCodeDetailEntity codeDetailEntity = QCodeDetailEntity.codeDetailEntity;

        return query.select(codeDetailEntity)
                .from(codeDetailEntity)
                .join(codeDetailEntity.code, codeEntity)
                //.where(statusEq(orderSearch.getOrderStatus()), nameLike(orderSearch.getMemberName()))
                //.limit(1000)
                .fetch();
    }

    @Override
    public List testJpql(){
        return em.createQuery("select m from CodeDetailEntity m").getResultList();
    }
}
