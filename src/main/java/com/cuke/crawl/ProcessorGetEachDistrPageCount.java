package com.cuke.crawl;

import com.cuke.config.Constant;
import com.cuke.service.ResidenceService;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * 获取每个区房源记录的页数
 * Created by wangjw on 2017/5/25 0025.
 */
public class ProcessorGetEachDistrPageCount implements PageProcessor {

    public ResidenceService residenceService;

    @Override
    public void process(Page page) {
        try {
            Thread.sleep(200);
            if (page.getUrl().regex(Constant.url).match()) {
                String pageCount =page.getHtml().xpath("/html/body/div[4]/div[1]/div[2]/h2/span/text()").toString().trim();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Site getSite() {
        return Constant.site;
    }
}
