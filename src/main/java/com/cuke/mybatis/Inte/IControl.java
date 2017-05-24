package com.cuke.mybatis.Inte;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: ControlMethod
 * @Description: TODO
 * @author: leven
 * @date: 2016年8月2日 下午3:35:04
 * @param <M>
 * @param <PK>
 */
public interface IControl<M, PK extends Serializable> {
	
	
	/**
	 * @Title: selectByPrimaryKey
	 * @Description: TODO
	 * @param id
	 * @param args   可变参数是用于之后可能需要手动指定  读写库
	 * @return
	 * @return: M
	 */
	public M 				selectByPrimaryKey(PK id, String... args);
	public List<M> selectListByModel(M m, String... args);
	public M 				selectByModel(M m, String... args);
	public Integer selectCountByModel(M m, String... args);
	public <T> T 			selectCustomSqlToObject(String sqlID, Object obj, String... args);
	public <T> List<T> selectCustomSqlToList(String sqlID, Object obj, String... args);
	public Integer saveSelective(M m, String... args);
	public Integer updateByPrimaryKeySelective(M m, String... args);
	public Integer deleteByPrimaryKey(PK id, String... args);
	public Integer saveCustomSql(String sqlID, Object obj, String... args);
	public Integer updateCustomSql(String sqlID, Object obj, String... args);
	public Integer deleteCustomSql(String sqlID, Object obj, String... args);
}
