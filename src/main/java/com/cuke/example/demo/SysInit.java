package com.cuke.example.demo;

import com.cuke.config.Constant;
import com.cuke.crawl.ProcessorGetDistrict;
import com.cuke.crawl.ProcessorLianjia;
import com.cuke.service.ResidenceService;
import com.google.common.collect.Lists;
import us.codecraft.webmagic.Spider;

import java.util.List;
import java.util.Vector;

/**
 * Created by sunyz on 2017/5/22 0022.
 */
public class SysInit {

    public static Vector<String> districUtls = new Vector<>();

    public static void init1(){
        try {
            Spider spider1 = start1();
            while(true){
                Thread.sleep(2000);
                if(spider1.getStatus().name().toString().equals("Stopped")){
                    System.out.println("spider1结束，spider2开始!");
                    for (String districUtl : districUtls) {
                        System.out.println(districUtl);
                    }
                    start2();
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Spider start1(){
        Spider spider = null;
        try {
            String[] ss = Constant.cityCodeArray;
            String[] xx = new String[ss.length];
            for (int i = 0; i < ss.length; i++) {
                xx[i] = "http://"+ ss[i] +".lianjia.com/ershoufang/";
            }
            spider = Spider.create(new ProcessorGetDistrict());
            spider.addUrl(xx);
            spider.thread(1);
            spider.setExitWhenComplete(true);
            spider.start();
        }catch (Exception e){
            e.printStackTrace();
        }
        return spider;
    }

    public static Spider start2(){
        ResidenceService rs = (ResidenceService) SpringBeanUtil.getBean("residenceService");
        ProcessorLianjia lj = new ProcessorLianjia(rs);
        Spider spider = null;
        try {
            List<String> urls = Lists.newArrayList();
            List<String> list = null;
            for (String districUtl : districUtls) {
                list = Lists.newArrayList();
                for (int i = 1; i <=100; i++) {
                    list.add(districUtl + "pg"+ i +"/");
                }
                urls.addAll(list);
            }
            spider = Spider.create(lj);
            //spider.addUrl("http://wh.lianjia.com/ershoufang/");
            //spider.addUrl(list.toArray(new String[list.size()]));
            spider.addUrl(urls.toArray(new String[urls.size()]));
            spider.thread(1);
            spider.setExitWhenComplete(true);
            spider.start();
        }catch (Exception e){
            e.printStackTrace();
        }
        return spider;
    }

}
