package com.cuke.demo;

import com.cuke.config.Constant;
import com.cuke.crawl.ProcessorMain;
import com.cuke.dao.DistrnamesDao;
import com.cuke.service.DistricturlService;
import com.cuke.service.ResidenceService;
import us.codecraft.webmagic.Spider;

/**
 * Created by wangjw on 2017/5/22 0022.
 */
public class SysInit {

    static {
        System.setProperty("javax.Net.ssl.trustStore", "classpath:jssecacerts");
    }

    public static Spider start(String... cityid){
        DistrnamesDao distrnamesDao = (DistrnamesDao) SpringBeanUtil.getBean("distrnamesDaoImpl");
        DistricturlService districturlService = (DistricturlService) SpringBeanUtil.getBean("districturlService");
        ResidenceService residenceService = (ResidenceService) SpringBeanUtil.getBean("residenceService");
        ProcessorMain lj = new ProcessorMain(distrnamesDao,districturlService,residenceService);
        Spider spider = null;
        try {
            String[] urls = null;
            if(cityid != null && cityid.length > 0){
                urls = cityid;
            }else{
                urls = new String[Constant.cityCodeArray.length];
            }
            for (int i =0; i< urls.length; i++) {
                urls[i] = "https://" + urls[i] + ".lianjia.com/ershoufang/";
            }
            spider = Spider.create(lj);
            spider.addUrl(urls);
            spider.thread(60);
            spider.setExitWhenComplete(true);
            spider.start();
        }catch (Exception e){
            e.printStackTrace();
        }
        return spider;
    }

}
