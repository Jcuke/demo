package com.cuke.service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sunyz on 2017/5/19 0019.
 */
public interface BaseService<M, PK extends Serializable> {

    public M selectByPrimaryKey(PK id);

    public List<M> selectListByModel(M m);

    public M selectByModel(M m);

    public Integer selectCountByModel(M m);

    public <T> T selectCustomSqlToObject(String sqlID, Object obj);
    
    public <T> List<T> selectCustomSqlToList(String sqlID, Object obj);

    public Integer saveSelective(M m);

    public Integer updateByPrimaryKeySelective(M m);

    
    public Integer deleteByPrimaryKey(PK id);

    public Integer saveCustomSql(String sqlID, Object obj);

    public Integer updateCustomSql(String sqlID, Object obj);

    public Integer deleteCustomSql(String sqlID, Object obj);
}
