package com.cuke.mybatis.impl;

import com.cuke.mybatis.Inte.IDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

@Repository
public class BaseDaoImpl1<M, PK extends Serializable> extends SqlSessionDaoSupport implements IDao<M, PK> {

	@Resource(name = "test1SqlSessionFactory")
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public M selectByPrimaryKey(PK id, String className) {
		return getSqlSession().selectOne(className + SELECTBYPRIMARYKEY, id);
	}

	@Override
	public List<M> selectListByModel(M m, String className) {
		return getSqlSession().selectList(className + SELECTLISTBYMODEL, m);
	}

	@Override
	public M selectByModel(M m, String className) {
		return getSqlSession().selectOne(className + SELECTBYMODEL, m);
	}

	@Override
	public Integer selectCountByModel(M m, String className) {
		return getSqlSession().selectOne(className + SELECTCOUNTBYMODEL, m);
	}

	@Override
	public <T> T selectCustomSqlToObject(String sqlID, Object obj, String className) {
		return getSqlSession().selectOne(className + CUSTOMMAPPER + sqlID, obj);
	}

	@Override
	public <T> List<T> selectCustomSqlToList(String sqlID, Object obj, String className) {
		return getSqlSession().selectList(className + CUSTOMMAPPER + sqlID, obj);
	}

	@Override
	public Integer saveSelective(M m, String className) {
		return getSqlSession().insert(className + SAVESELECTIVE, m);
	}

	@Override
	public Integer updateByPrimaryKeySelective(M m, String className) {
		return getSqlSession().insert(className + UPDATEBYPRIMARYKEYSELECTIVE, m);
	}

	@Override
	public Integer deleteByPrimaryKey(PK id, String className) {
		return getSqlSession().delete(className + DELETEBYPRIMARYKEY, id);
	}

	@Override
	public Integer saveCustomSql(String sqlID, Object obj, String className) {
		return getSqlSession().insert(className + CUSTOMMAPPER + sqlID, obj);
	}

	@Override
	public Integer updateCustomSql(String sqlID, Object obj, String className) {
		return getSqlSession().update(className + CUSTOMMAPPER + sqlID, obj);
	}

	@Override
	public Integer deleteCustomSql(String sqlID, Object obj, String className) {
		return getSqlSession().delete(className + CUSTOMMAPPER + sqlID, obj);
	}

}
