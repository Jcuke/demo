package com.cuke.dao.impl;

import com.cuke.dao.BaseDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by sunyz on 2017/5/19 0019.
 */
public class BaseDb1DaoImpl<M, PK extends Serializable> extends SqlSessionDaoSupport implements BaseDao<M, PK> {

    private Class<M> entityClass = null;

    public BaseDb1DaoImpl() {
        Class<?> c = getClass();
        Type type = c.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
            entityClass = (Class<M>) parameterizedType[0];
        }
    }
    
    @Resource(name = "test1SqlSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public M selectByPrimaryKey(PK id) {
        return getSqlSession().selectOne(entityClass.getSimpleName() + SELECTBYPRIMARYKEY, id);
    }

    @Override
    public List<M> selectListByModel(M m) {
        return getSqlSession().selectList(entityClass.getSimpleName() + SELECTLISTBYMODEL, m);
    }

    @Override
    public M selectByModel(M m) {
        return getSqlSession().selectOne(entityClass.getSimpleName() + SELECTBYMODEL, m);
    }

    @Override
    public Integer selectCountByModel(M m) {
        return getSqlSession().selectOne(entityClass.getSimpleName() + SELECTCOUNTBYMODEL, m);
    }

    @Override
    public <M> M selectCustomSqlToObject(String sqlID, Object obj) {
        return getSqlSession().selectOne(entityClass.getSimpleName() + CUSTOMMAPPER + sqlID, obj);
    }

    @Override
    public <M> List<M> selectCustomSqlToList(String sqlID, Object obj) {
        return getSqlSession().selectList(entityClass.getSimpleName() + CUSTOMMAPPER + sqlID, obj);
    }

    @Override
    public Integer saveSelective(M m) {
        return getSqlSession().insert(entityClass.getSimpleName() + SAVESELECTIVE, m);
    }

    @Override
    public Integer updateByPrimaryKeySelective(M m) {
        return getSqlSession().insert(entityClass.getSimpleName() + UPDATEBYPRIMARYKEYSELECTIVE, m);
    }

    @Override
    public Integer deleteByPrimaryKey(PK id) {
        return getSqlSession().delete(entityClass.getSimpleName() + DELETEBYPRIMARYKEY, id);
    }

    @Override
    public Integer saveCustomSql(String sqlID, Object obj) {
        return getSqlSession().insert(entityClass.getSimpleName() + CUSTOMMAPPER + sqlID, obj);
    }

    @Override
    public Integer updateCustomSql(String sqlID, Object obj) {
        return getSqlSession().update(entityClass.getSimpleName() + CUSTOMMAPPER + sqlID, obj);
    }

    @Override
    public Integer deleteCustomSql(String sqlID, Object obj) {
        return getSqlSession().delete(entityClass.getSimpleName() + CUSTOMMAPPER + sqlID, obj);
    }

}