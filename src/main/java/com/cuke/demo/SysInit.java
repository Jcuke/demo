package com.cuke.demo;

import com.cuke.config.Constant;
import com.cuke.crawl.ProcessorGetDistrict;
import com.cuke.crawl.ProcessorLianjia;
import com.cuke.dao.DistrnamesDao;
import com.cuke.entity.Districturl;
import com.cuke.entity.Pageurl;
import com.cuke.service.DistricturlService;
import com.cuke.service.ResidenceService;
import us.codecraft.webmagic.Spider;

import java.util.Date;
import java.util.List;
import java.util.Vector;

/**
 * Created by wangjw on 2017/5/22 0022.
 */
public class SysInit {

    static {
        System.setProperty("javax.Net.ssl.trustStore", "classpath:jssecacerts");
    }

    public static Vector<String> districUtls = new Vector<>();

    public static void init1(){
        DistricturlService districturlService = (DistricturlService) SpringBeanUtil.getBean("districturlService");
        ResidenceService residenceService = (ResidenceService) SpringBeanUtil.getBean("residenceService");

        try {
            Spider spider1 = start1();
            while(true){
                Thread.sleep(2000);
                if(spider1.getStatus().name().toString().equals("Stopped")){
                    System.out.println("spider1结束，spider2开始!");
                    List<Districturl> districturls = districturlService.selectListByModel(new Districturl());
                    Long date = new Date().getTime() / 1000;
                    Pageurl pu = new Pageurl();
                    for (Districturl districturl : districturls) {
                        String districUtl = districturl.getUrl();
                        for (int i = 1; i <=100; i++) {
                            pu.setDate(date);
                            if(districUtl.contains("sh.")){
                                pu.setPageurl(districUtl + "d"+ i +"/");
                            }else{
                                pu.setPageurl(districUtl + "pg"+ i +"/");
                            }

                            pu.setSuccess(0);
                            residenceService.updateCustomSql("insertPageUrl", pu);
                        }
                    }
                    for (String districUtl : districUtls) {
                        System.out.println("0025f41:   "+districUtl);
                    }
                    System.out.println("====================== Page Date Init Done!  ====================");
//                    start2();
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Spider start1(){
        DistricturlService rs = (DistricturlService) SpringBeanUtil.getBean("districturlService");
        DistrnamesDao rd = (DistrnamesDao) SpringBeanUtil.getBean("distrnamesDaoImpl");

        ProcessorGetDistrict lj = new ProcessorGetDistrict(rs, rd);
        Spider spider = null;
        try {
            String[] ss = Constant.cityCodeArray;
            String[] xx = new String[ss.length];
            for (int i = 0; i < ss.length; i++) {
                xx[i] = "http://"+ ss[i] +".lianjia.com/ershoufang/";
            }
            spider = Spider.create(lj);
            spider.addUrl(xx);
            spider.thread(10);
            spider.setExitWhenComplete(true);
            spider.start();
        }catch (Exception e){
            e.printStackTrace();
        }
        return spider;
    }

    public static Spider start2(){
        ResidenceService residenceService = (ResidenceService) SpringBeanUtil.getBean("residenceService");
        ProcessorLianjia lj = new ProcessorLianjia(residenceService);
        Spider spider = null;
        try {
            List<String> pageurls = residenceService.selectCustomSqlToList("getAllPageUrls", null);
            System.out.println("待获取的pageurl条数:" + pageurls.size());
            spider = Spider.create(lj);
            spider.addUrl(pageurls.toArray(new String[pageurls.size()]));
            spider.thread(60);
            spider.setExitWhenComplete(true);
            spider.start();
        }catch (Exception e){
            e.printStackTrace();
        }
        return spider;
    }

}
