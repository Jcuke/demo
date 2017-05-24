package com.cuke.mybatis.control;

import com.cuke.mybatis.Inte.IControl;
import com.cuke.mybatis.impl.BaseDaoImpl1;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 主要是用于 之后读写分离 来作为dao的转发
 * 
 * @ClassName: BosControl
 * @Description: TODO
 * @author: liw
 * @date: 2016年3月31日 上午11:48:03
 * @param <M>
 * @param <PK>
 */
public class Control1<M, PK extends Serializable> implements IControl<M, PK> {

	private Class<M> entityClass = null;

	@Autowired
	private BaseDaoImpl1<M, PK> dao;

	/**
	 * @Title:JpdWriteDao 创建默认构造方法，以取得真正的泛型类型
	 */
	@SuppressWarnings("unchecked")
	public Control1() {
		Class<?> c = getClass();
		Type type = c.getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
			entityClass = (Class<M>) parameterizedType[0];
		}
	}

	@Override
	public M selectByPrimaryKey(PK id, String... args) {
		return dao.selectByPrimaryKey(id, entityClass.getSimpleName());
	}

	@Override
	public Integer saveSelective(M m, String... args) {
		return dao.saveSelective(m, entityClass.getSimpleName());
	}

	@Override
	public Integer updateByPrimaryKeySelective(M m, String... args) {
		return dao.updateByPrimaryKeySelective(m, entityClass.getSimpleName());
	}

	@Override
	public Integer deleteByPrimaryKey(PK id, String... args) {
		return dao.deleteByPrimaryKey(id, entityClass.getSimpleName());
	}

	@Override
	public Integer saveCustomSql(String sqlID, Object obj, String... args) {
		return dao.saveCustomSql(sqlID, obj, entityClass.getSimpleName());
	}

	@Override
	public Integer updateCustomSql(String sqlID, Object obj, String... args) {
		return dao.updateCustomSql(sqlID, obj, entityClass.getSimpleName());
	}

	@Override
	public Integer deleteCustomSql(String sqlID, Object obj, String... args) {
		return dao.deleteCustomSql(sqlID, obj, entityClass.getSimpleName());
	}

	@Override
	public List<M> selectListByModel(M m, String... args) {
		return dao.selectListByModel(m, entityClass.getSimpleName());
	}

	@Override
	public M selectByModel(M m, String... args) {
		return dao.selectByModel(m, entityClass.getSimpleName());
	}

	@Override
	public Integer selectCountByModel(M m, String... args) {
		return dao.selectCountByModel(m, entityClass.getSimpleName());
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public <T> T selectCustomSqlToObject(String sqlID, Object obj, String... args) {
		return (T) dao.selectCustomSqlToObject(sqlID, obj, entityClass.getSimpleName());
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public <T> List<T> selectCustomSqlToList(String sqlID, Object obj, String... args) {
		return (List<T>) dao.selectCustomSqlToList(sqlID, obj, entityClass.getSimpleName());
	}

}
