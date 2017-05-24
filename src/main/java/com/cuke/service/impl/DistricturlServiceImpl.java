package com.cuke.service.impl;

import com.cuke.dao.DistricturlDao;
import com.cuke.mybatis.Inte.IControl;
import com.cuke.service.DistricturlService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by wangjw on 2017/5/19 0019.
 */
@Service("districturlService")
public class DistricturlServiceImpl extends BaseServiceImpl implements DistricturlService{

    @Resource
    public DistricturlDao districturlDao;

    @Override
    public IControl getBaseDao() {
        return districturlDao;
    }
}
