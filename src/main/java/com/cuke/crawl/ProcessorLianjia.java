package com.cuke.crawl;

import com.cuke.config.Constant;
import com.cuke.entity.Residence;
import com.cuke.service.ResidenceService;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by wangjw on 2017/5/19 0019.
 */
public class ProcessorLianjia implements PageProcessor{

    private ResidenceService residenceService;

    public ProcessorLianjia(){
    }

    public ProcessorLianjia(ResidenceService residenceService){
        this.residenceService = residenceService;
    }

    @Override
    public void process(Page page) {
        try {
            Thread.sleep(200);
            if(page.getUrl().regex(Constant.url).match()){
                List<Selectable> list = page.getHtml().xpath("/html/body/div[4]/div[1]/ul/li").nodes();
                if(list.size() > 0){
                    residenceService.updateCustomSql("updatePageUrlSuccess", page.getUrl().toString());
                }
                for (Selectable s : list) {
                    Residence res = new Residence();

                    String title = s.xpath("//*[@class='title']/a/text()").toString().trim();
                    String propss = s.xpath("//*[@class='houseInfo']/text()").toString();
                    String area = propss.replaceAll(" ", "").split("\\|")[propss.contains("别墅") ? 3 : 2].replace("平米", "");
                    String xiaoqu = s.xpath("//*[@class='houseInfo']/a/text()").toString().trim();
                    String xiqoquid = s.xpath("//*[@class='houseInfo']/a/@href").toString().split("/")[4];
                    String jiage = s.xpath("//*[@class='totalPrice']/span/text()").toString();
                    String danjia = s.xpath("//*[@class='unitPrice']/span/text()").toString().replace("单价", "").replace("元/平米", "");

                    res.setTitle(title);
                    try{
                        res.setArea(Float.parseFloat(area));
                    }catch (Exception e){
                        System.out.println("\n\n\n"+ propss +"\n\n\n");
                        break;
                    }
                    res.setXiaoqu(xiaoqu);
                    res.setXiaoquid(xiqoquid);
                    res.setJiage(new BigDecimal(jiage));
                    res.setDanjia(new BigDecimal(danjia));
                    String pageUrl = page.getUrl().toString();
                    String districCode = pageUrl.replaceAll("https://[a-z]+.lianjia.com/ershoufang/", "").replaceAll("/pg[0-9]+/", "");
                    String cityCode = pageUrl.replaceAll("https://", "").replaceAll(".lianjia.com/ershoufang/"+ districCode +"/pg[0-9]+/", "");
                    res.setCityid(cityCode);
                    res.setDistrictid(districCode);
                    res.setFyurl(s.xpath("//*/a/@href").toString());
                    Residence model = new Residence();
                    model.setFyurl(res.getFyurl());
                    if(residenceService.selectCountByModel(model) == 0){
                        residenceService.saveSelective(res);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Site getSite() {
        return Constant.site;
    }

    public static void main(String[] args) {
        try {
            Spider spider = Spider.create(new ProcessorLianjia());
            spider.addUrl("http://wh.lianjia.com/ershoufang/");
            spider.thread(1);
            spider.setExitWhenComplete(true);
            spider.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
