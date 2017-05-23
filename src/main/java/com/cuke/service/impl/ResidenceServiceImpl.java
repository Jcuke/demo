package com.cuke.service.impl;

import com.cuke.dao.ResidenceDao;
import com.cuke.entity.Residence;
import com.cuke.service.ResidenceService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;

import javax.annotation.Resource;

/**
 * Created by sunyz on 2017/5/19 0019.
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
    public void saves() {
        TransactionStatus ts = null;
        try {
            ts = this.txBegin(0);
            Residence residence = new Residence();
            residence.setTitle("1245151515153");
            residenceDao1.saveSelective(residence);
            residenceDao2.saveSelective(residence);
            this.txCommit(ts);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (null != ts && !ts.isCompleted()){
                this.txRollback(ts);
            }
        }
    }
}
