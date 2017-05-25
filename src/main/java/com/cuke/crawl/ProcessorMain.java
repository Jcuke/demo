package com.cuke.crawl;

import com.cuke.config.Constant;
import com.cuke.dao.DistrnamesDao;
import com.cuke.demo.SysInit;
import com.cuke.entity.Districturl;
import com.cuke.entity.Distrnames;
import com.cuke.entity.Residence;
import com.cuke.service.DistricturlService;
import com.cuke.service.ResidenceService;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.math.BigDecimal;
import java.util.List;

import static us.codecraft.webmagic.selector.Selectors.xpath;

/**
 * Created by wangjw on 2017/5/25 0025.
 */
public class ProcessorMain implements PageProcessor{

    public DistrnamesDao distrnamesDao;
    public DistricturlService districturlService;
    private ResidenceService residenceService;

    @Override
    public void process(Page page) {
        if(page.getUrl().regex("https://[a-z]{2,3}.lianjia.com/ershoufang/").match()){
            processCity(page);
        }else if(page.getUrl().regex("https://[a-z]{2,3}.lianjia.com/ershoufang/[a-z]{2,3}[0-9]{0,2}/").match()){
            processDistrict(page);
        }
    }

    private void processDistrict(Page page){
        String cityCode = page.getRequest().getExtra("cityCode").toString();
        String districtCode = page.getRequest().getExtra("districtCode").toString();

        List<Selectable> list = page.getHtml().xpath("/html/body/div[4]/div[1]/ul/li").nodes();
        if(list.size() > 0){
//            residenceService.updateCustomSql("updatePageUrlSuccess", page.getUrl().toString());
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
                page.setSkip(true);
            }
            res.setXiaoqu(xiaoqu);
            res.setXiaoquid(xiqoquid);
            res.setJiage(new BigDecimal(jiage));
            res.setDanjia(new BigDecimal(danjia));
            String pageUrl = page.getUrl().toString();
            res.setCityid(cityCode);
            res.setDistrictid(districtCode);
            res.setFyurl(s.xpath("//*/a/@href").toString());
            Residence model = new Residence();
            model.setFyurl(res.getFyurl());
            if(residenceService.selectCountByModel(model) == 0){
//                residenceService.saveSelective(res);
            }
        }

    }

    /**
     * 区
     * @param page
     */
    private void processCity(Page page) {
        List<String> list = null;
        if(page.getUrl().toString().contains("sh.")){
            list = page.getHtml().xpath("//*[@id=\"plateList\"]/div/a").all();
        }else{
            list = page.getHtml().xpath("//*[@data-role='ershoufang']/div/a").all();
        }
        for (String districtUrl : list) {
            if(districtUrl.toString().contains("不限")){
                continue;
            }
            String link = xpath("//a/@href").select(districtUrl);
            String title = xpath("//a/text()").select(districtUrl);

            String districtCode = link.replace("http://", "").split("/")[2];
            String district = title;
            String cityCode = page.getUrl().toString().replace("http://", "").replace(".lianjia.com/ershoufang/", "");
            String city = Constant.getCityByCode(cityCode);
            System.out.println("城市"+ cityCode +": " + city + " 区" + districtCode + ":" + district);
            String districtPageUrl = "https://"+ cityCode +".lianjia.com/ershoufang/"+ districtCode +"/";
            SysInit.districUtls.add(districtPageUrl);

            Districturl du = new Districturl();
            du.setDistrictid(districtCode);
            if(districturlService.selectCountByModel(du) == 0){
                du.setCityid(cityCode);
                du.setUrl(districtPageUrl);
                districturlService.saveSelective(du);

                //保存区名和区拼音的关系记录
                Distrnames dn = new Distrnames();
                dn.setDistrict(district);
                dn.setDistrictid(districtCode);
                dn.setCityid(cityCode);
                dn.setCity(city);
//                distrnamesDao.saveSelective(dn);
            }


            Request request = new Request(link).setPriority(1).putExtra("districtCode", districtCode).putExtra("cityCode", cityCode);
            page.addTargetRequest(request);
        }
    }

    private void processDistrictPages(Page page) {

    }

    @Override
    public Site getSite() {
        return Constant.site;
    }

    public static void main(String[] args) {
        Spider spider = Spider.create(new ProcessorMain()).addUrl("https://cd.lianjia.com/ershoufang/");
        spider.run();
    }
}
