package com.cuke.crawl;

import com.cuke.config.Constant;
import com.cuke.dao.DistrnamesDao;
import com.cuke.entity.Districturl;
import com.cuke.entity.Distrnames;
import com.cuke.entity.Pageurl;
import com.cuke.entity.Residence;
import com.cuke.service.DistricturlService;
import com.cuke.service.ResidenceService;
import com.cuke.util.StringUtil;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static us.codecraft.webmagic.selector.Selectors.xpath;

/**
 * Created by wangjw on 2017/5/25 0025.
 */
public class ProcessorMain implements PageProcessor{

    private DistrnamesDao distrnamesDao;
    private DistricturlService districturlService;
    private ResidenceService residenceService;

    public ProcessorMain(DistrnamesDao distrnamesDao,DistricturlService districturlService,ResidenceService residenceService){
        this.distrnamesDao = distrnamesDao;
        this.districturlService = districturlService;
        this.residenceService = residenceService;
    }

    public ProcessorMain(){

    }

    @Override
    public void process(Page page) {
        if(page.getUrl().regex("http[s]?://[a-z]{2,3}.lianjia.com/ershoufang/[a-z]+[0-9]{0,2}/pg[0-9]{1,3}/").match()){
            processPageDetails(page);
        }else if(page.getUrl().regex("http[s]?://[a-z]{2,3}.lianjia.com/ershoufang/[a-z]+[0-9]{0,2}/").match()){
            processDistrict(page);
        }else if(page.getUrl().regex("http[s]?://[a-z]{2,3}.lianjia.com/ershoufang/").match()){
            processCity(page);
        }
    }

    private void processPageDetails(Page page) {
        String cityCode = page.getRequest().getExtra("cityCode").toString();
        String districtCode = page.getRequest().getExtra("districtCode").toString();
        Html html = page.getHtml();
        List<Selectable> list = html.xpath("/html/body/div[4]/div[1]/ul/li").nodes();
        if(list.size() > 0){
            residenceService.updateCustomSql("updatePageUrlSuccess", page.getUrl().toString());
        }
        for (Selectable s : list) {
            Residence res = new Residence();

            String title = s.xpath("//*[@class='title']/a/text()").toString().trim();
            String propss = s.xpath("//*[@class='houseInfo']/text()").toString();
            String area = propss.replaceAll(" ", "").split("\\|")[propss.contains("别墅") ? 3 : 2].replaceAll("平米", "");
            String xiaoqu = s.xpath("//*[@class='houseInfo']/a/text()").toString().trim();
            String xiqoquid = s.xpath("//*[@class='houseInfo']/a/@href").toString().split("/")[4];
            String jiage = s.xpath("//*[@class='totalPrice']/span/text()").toString();
            String danjia = s.xpath("//*[@class='unitPrice']/span/text()").toString().replaceAll("单价", "").replaceAll("元/平米", "");

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
                residenceService.saveSelective(res);
            }
        }
    }

    private void processDistrict(Page page){
        String cityCode = page.getRequest().getExtra("cityCode").toString();
        String districtCode = page.getRequest().getExtra("districtCode").toString();
        Html html = page.getHtml();

        //next page
        String pageJsonStr = html.xpath("/html/body/div[4]/div[1]/div[7]/div[2]/div/@page-data").toString();
        if(null == pageJsonStr){
            //该区无房源记录,无page按钮
            return;
        }
        Map<String, Double> pageJson = StringUtil.getDoubleMapFromJsonObjStr(pageJsonStr);
        Integer totalPage = pageJson.get("totalPage").intValue();
        Integer curPage = pageJson.get("curPage").intValue();
        System.out.println(pageJsonStr);

        if(curPage < totalPage){
            Pageurl pu = new Pageurl();
            pu.setSuccess(0);
            pu.setDate(new Date().getTime() / 1000);
            for (int i = curPage+1; i<totalPage; i++){
                pu.setPageurl("https://"+ cityCode +".lianjia.com/ershoufang/"+ districtCode +"/pg"+ i +"/");
                residenceService.updateCustomSql("insertPageUrl", pu);
                /*insert into pageurl (`pageurl`, `date`,`success`)
                values(#{pageurl},#{date},#{success})
                select #{pageurl},#{date},#{success} from dual
                where not exists (select 1 from pageurl where pageurl=#{pageurl})*/
                Request request = new Request(page.getUrl().toString() + "pg" + i + "/").putExtra("districtCode", districtCode).putExtra("cityCode", cityCode);;
                page.addTargetRequest(request);
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
            String district = xpath("//a/text()").select(districtUrl);

            String districtCode = link.replaceAll("http[s]?://", "").split("/")[2];
            String cityCode = page.getUrl().toString().replaceAll("http[s]?://", "").replaceAll(".lianjia.com/ershoufang/", "");
            String city = Constant.getCityByCode(cityCode);
            System.out.println("城市"+ cityCode +": " + city + " 区" + districtCode + ":" + district);
            String districtPageUrl = "https://"+ cityCode +".lianjia.com/ershoufang/"+ districtCode +"/";

            Districturl du = new Districturl();
            du.setDistrictid(districtCode);
            if(districturlService.selectCountByModel(du) == 0){
                System.out.println("========================================================   "+cityCode+"  PPPPPPPPPPPPPP");
                du.setCityid(cityCode);
                du.setUrl(districtPageUrl);
                districturlService.saveSelective(du);

                //保存区名和区拼音的关系记录
                Distrnames dn = new Distrnames();
                dn.setDistrict(district);
                dn.setDistrictid(districtCode);
                dn.setCityid(cityCode);
                dn.setCity(city);
                distrnamesDao.saveSelective(dn);
            }


            Request request = new Request(link).putExtra("districtCode", districtCode).putExtra("cityCode", cityCode);
            page.addTargetRequest(request);
        }
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
