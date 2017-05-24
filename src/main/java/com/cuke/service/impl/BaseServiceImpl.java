package com.cuke.service.impl;

import com.cuke.mybatis.Inte.IControl;
import com.cuke.service.BaseService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by wangjw on 2017/5/19 0019.
 */
@Component
public class BaseServiceImpl<M, PK extends Serializable> implements BaseService<M, PK> {

    @Qualifier("transactionManager_annotation00102")
    @Resource
    private JtaTransactionManager txManager;
    public IControl getBaseDao(){
        return null;
    }

    @Override
    public M selectByPrimaryKey(PK id) {
        return (M) getBaseDao().selectByPrimaryKey(id);
    }

    @Override
    public List<M> selectListByModel(M m) {
        return getBaseDao().selectListByModel(m);
    }

    @Override
    public M selectByModel(M m) {
        return (M) getBaseDao().selectByModel(m);
    }

    @Override
    public Integer selectCountByModel(M m) {
        return getBaseDao().selectCountByModel(m);
    }

    @Override
    public <M> M selectCustomSqlToObject(String sqlID, Object obj) {
        return (M) getBaseDao().selectCustomSqlToObject(sqlID, obj);
    }

    @Override
    public <M> List<M> selectCustomSqlToList(String sqlID, Object obj) {
        return getBaseDao().selectCustomSqlToList(sqlID, obj);
    }

    @Override
    public Integer saveSelective(M m) {
        return getBaseDao().saveSelective(m);
    }

    @Override
    public Integer updateByPrimaryKeySelective(M m) {
        return getBaseDao().updateByPrimaryKeySelective(m);
    }

    @Override
    public Integer deleteByPrimaryKey(PK id) {
        return getBaseDao().deleteByPrimaryKey(id);
    }

    @Override
    public Integer saveCustomSql(String sqlID, Object obj) {
        return getBaseDao().saveCustomSql(sqlID, obj);
    }

    @Override
    public Integer updateCustomSql(String sqlID, Object obj) {
        return getBaseDao().updateCustomSql(sqlID, obj);
    }

    @Override
    public Integer deleteCustomSql(String sqlID, Object obj) {
        return getBaseDao().deleteCustomSql(sqlID, obj);
    }


    /**
     * @Title: bigenTransaction
     * @Description: 开启事务
     * @param definition
     * @return
     * @return: TransactionStatus
     */
    protected TransactionStatus txBegin(Integer definition) {
        txManager.setRollbackOnCommitFailure(true);
        Integer tdf = null;
        if (definition == null) {
            tdf = TransactionDefinition.PROPAGATION_REQUIRED;
        } else {
            tdf = definition;
        }
        TransactionStatus status = txManager.getTransaction(new DefaultTransactionDefinition(tdf.intValue()));
        return status;
    }

    /**
     * @Title: commitTransaction
     * @Description: 事务提交
     * @param status
     * @return: void
     */
    protected void txCommit(TransactionStatus status) {
        txManager.commit(status);
    }

    protected void txRollback(TransactionStatus status) {
        txManager.rollback(status);
    }
}
