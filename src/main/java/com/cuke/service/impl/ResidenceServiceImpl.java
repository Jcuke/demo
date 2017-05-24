package com.cuke.service.impl;

import com.cuke.dao.ResidenceDao;
import com.cuke.entity.Residence;
import com.cuke.mybatis.Inte.IControl;
import com.cuke.service.ResidenceService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;

import javax.annotation.Resource;

/**
 * Created by wangjw on 2017/5/19 0019.
 */
@Service("residenceService")
public class ResidenceServiceImpl extends BaseServiceImpl implements ResidenceService{

    @Qualifier("residenceDaoImpl")
    @Resource
    protected ResidenceDao residenceDao1;

    @Qualifier("residenceDaoImpl2")
    @Resource
    protected ResidenceDao residenceDao2;

    @Override
    public IControl getBaseDao() {
        return residenceDao1;
    }


    @Override
    public void saves() throws Exception{
        TransactionStatus ts = null;
        try {
            ts = this.txBegin(0);
            Residence residence = new Residence();
            residence.setTitle("1245t45t45t54t54t5453");
            this.saveSelective(residence);

            Residence residence2 = new Residence();
            residence2.setTitle("1245t45t45t54t54t54531245t45t45t54t54t5453");
            residenceDao2.saveSelective(residence2);
            this.txCommit(ts);
        }catch (Exception e){
            this.txRollback(ts);
//            e.printStackTrace();
            throw e;
        }finally {
            if (null != ts && !ts.isCompleted()){
                this.txRollback(ts);
            }
        }
    }

}
