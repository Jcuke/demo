package com.cuke.mybatis.Inte;

import java.io.Serializable;
import java.util.List;


/**
 * @ClassName: DaoMethod
 * @Description: TODO
 * @author: leven
 * @date: 2016年8月2日 下午3:32:45
 * @param <M>
 * @param <PK>
 */
public interface IDao<M, PK extends Serializable> {

	final static String SELECTBYPRIMARYKEY = "Mapper.selectByPrimaryKey";
	final static String SELECTLISTBYMODEL = "Mapper.selectByModel";
	final static String SELECTBYMODEL = "Mapper.selectByModel";
	final static String SELECTCOUNTBYMODEL = "Mapper.selectCountByModel";
	final static String SAVE = "Mapper.insert";
	final static String SAVESELECTIVE = "Mapper.insertSelective";
	final static String UPDATEBYPRIMARYKEYSELECTIVE = "Mapper.updateByPrimaryKeySelective";
	final static String DELETEBYPRIMARYKEY = "Mapper.deleteByPrimaryKey";
	final static String CUSTOMMAPPER = "Mapper.";

	public M 					selectByPrimaryKey(PK id, String className);
	public List<M> selectListByModel(M m, String className);
	public M 					selectByModel(M m, String className);
	public Integer selectCountByModel(M m, String className);
	public <T> T 				selectCustomSqlToObject(String sqlID, Object obj, String className);
	public <T> List<T> selectCustomSqlToList(String sqlID, Object obj, String className);
	public Integer saveSelective(M m, String className);
	public Integer updateByPrimaryKeySelective(M m, String className);
	public Integer deleteByPrimaryKey(PK id, String className);
	public Integer saveCustomSql(String sqlID, Object obj, String className);
	public Integer updateCustomSql(String sqlID, Object obj, String className);
	public Integer deleteCustomSql(String sqlID, Object obj, String className);
}
