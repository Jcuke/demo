package com.cuke.crawl;

import com.cuke.config.Constant;
import com.cuke.entity.Districturl;
import com.cuke.demo.SysInit;
import com.cuke.service.DistricturlService;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

/**
 * Created by wangjw on 2017/5/19 0019.
 */
public class ProcessorGetDistrict implements PageProcessor{

    public DistricturlService districturlService;

    public ProcessorGetDistrict(DistricturlService districturlService) {
        this.districturlService = districturlService;
    }

    public ProcessorGetDistrict(){
    }
    private Site site = Constant.site;

    public static final String url = Constant.url;

    @Override
    public void process(Page page) {
        try {
            Thread.sleep(1000);
            if(page.getUrl().regex(url).match()){
                List<Selectable> list = null;
                if(page.getUrl().toString().contains("sh.")){
                    list = page.getHtml().xpath("//*[@id=\"plateList\"]/div/a").nodes();
                }else{
                    list = page.getHtml().xpath("//*[@data-role='ershoufang']/div/a").nodes();
                }
                for (Selectable s : list) {
                    if(s.toString().contains("不限")){
                        continue;
                    }
                    String districtCode = s.xpath("//*/@href").toString().replace("http://", "").split("/")[2];
                    String district = s.xpath("//*/text()").toString();
                    System.out.println(districtCode + "   " + district);
                    String cityCode = page.getUrl().toString().replace("http://", "").replace(".lianjia.com/ershoufang/", "");
                    String districtPageUrl = "https://"+ cityCode +".lianjia.com/ershoufang/"+ districtCode +"/";
                    SysInit.districUtls.add(districtPageUrl);

                    Districturl du = new Districturl();
                    du.setDistrictid(districtCode);
                    if(districturlService.selectCountByModel(du) == 0){
                        du.setCityid(cityCode);
                        du.setUrl(districtPageUrl);
                        districturlService.saveSelective(du);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Site getSite() {
        return this.site;
    }

    public static void main(String[] args) {
        try {
            String[] ss = Constant.cityCodeArray;
            String[] xx = new String[ss.length];
            for (int i = 0; i < ss.length; i++) {
                xx[i] = "http://"+ ss[i] +".lianjia.com/ershoufang/";
            }
            Spider spider = Spider.create(new ProcessorGetDistrict());
            spider.addUrl(xx);
            spider.thread(1);
            spider.setExitWhenComplete(true);
            spider.start();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
