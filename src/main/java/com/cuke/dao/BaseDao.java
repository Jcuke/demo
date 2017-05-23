package com.cuke.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 用于之后读写分离 来作为dao的转发
 * @ClassName: JpdControl
 * @Description: TODO
 * @author: liw
 * @date: 2016年3月31日 上午11:48:03
 * @param <M>
 * @param <PK>
 */
public interface BaseDao<M, PK extends Serializable>{

    final static String SELECTBYPRIMARYKEY = "Mapper.selectByPrimaryKey";
    final static String SELECTLISTBYMODEL = "Mapper.selectByModel";
    final static String SELECTBYMODEL = "Mapper.selectByModel";
    final static String SELECTCOUNTBYMODEL = "Mapper.selectCountByModel";
    final static String SAVE = "Mapper.insert";
    final static String SAVESELECTIVE = "Mapper.insertSelective";
    final static String UPDATEBYPRIMARYKEYSELECTIVE = "Mapper.updateByPrimaryKeySelective";
    final static String DELETEBYPRIMARYKEY = "Mapper.deleteByPrimaryKey";
    final static String CUSTOMMAPPER = "Mapper.";

    public M 				selectByPrimaryKey(PK id);
    public List<M> selectListByModel(M m);
    public M 				selectByModel(M m);
    public Integer selectCountByModel(M m);
    public <T> T 			selectCustomSqlToObject(String sqlID, Object obj);
    public <T> List<T> selectCustomSqlToList(String sqlID, Object obj);
    public Integer saveSelective(M m);
    public Integer updateByPrimaryKeySelective(M m);
    public Integer deleteByPrimaryKey(PK id);
    public Integer saveCustomSql(String sqlID, Object obj);
    public Integer updateCustomSql(String sqlID, Object obj);
    public Integer deleteCustomSql(String sqlID, Object obj);

}
