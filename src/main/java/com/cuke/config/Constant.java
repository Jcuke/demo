package com.cuke.config;

import org.apache.http.HttpHost;
import us.codecraft.webmagic.Site;

/**
 * Created by wangjw on 2017/5/23 0023.
 */
public class Constant {


    public static final String[] cityCodeArray = {"wh", "bj", "tj", "nj", "qd", "dl", "sz", "cd", "cq", "jn", "gz", "hz", "cs", "xm", "sy", "hf"};
//    public static final String[] cityCodeArray = {"sh"};
    //上海链家网站xpath不一样,需要单独爬取

    public static String getCityByCode(String code) {
        String name = "";
        switch (code) {
            case "sh":
                name = "上海";
                break;
            case "wh":
                name = "武汉";
                break;
            case "bj":
                name = "北京";
                break;
            case "tj":
                name = "天津";
                break;
            case "nj":
                name = "南京";
                break;
            case "qd":
                name = "青岛";
                break;
            case "dl":
                name = "大连";
                break;
            case "sz":
                name = "深圳";
                break;
            case "cd":
                name = "成都";
                break;
            case "cq":
                name = "重庆";
                break;
            case "jn":
                name = "济南";
                break;
            case "gz":
                name = "广州";
                break;
            case "hz":
                name = "杭州";
                break;
            case "cs":
                name = "长沙";
                break;
            case "xm":
                name = "厦门";
                break;
            case "sy":
                name = "沈阳";
                break;
            case "hf":
                name = "合肥";
                break;
            default:
                name = "";
                break;
        }
        return name;
    }

    public static final String url = "lianjia.com/ershoufang/";


    public static final Site site = Site.me()
            .setDomain("lianjia.com")
            .setRetryTimes(6)
            .setCycleRetryTimes(6)
            .setSleepTime(2000)
            .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
            .addHeader("Accept-Encoding", "gzip, deflate, sdch, br")
            .addHeader("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6")
            .addHeader("Cache-Control", "max-age=0")
            .addHeader("Connection", "keep-alive")
            .addHeader("Upgrade-Insecure-Requests", "1")
//            .addHeader("Host", "www.lianjia.com")
            .addHeader("Referer", "https://wh.lianjia.com/ershoufang/")
            .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")
            .addHeader("Cookie", "lianjia_uuid=b4097b46-4176-4d3f-aaf3-d74c368a00c6; all-lj=492291e11daf53bf34d39f84cc442d11; UM_distinctid=15c3472cee19ca-0bd4e0950385c7-6a11157a-100200-15c3472cee257e; gr_user_id=fd4a1abe-80b1-4f61-a510-c2172f612858; _jzqckmp=1; sample_traffic_test=controlled_66; cityCode=sh; __xsptplus696=696.3.1495695430.1495696656.16%234%7C%7C%7C%7C%7C%23%23sDN4h7WnLFKgt2spkZRX582fbM45tfoI%23; ubt_load_interval_b=1495696656177; ubta=2299869246.3967010957.1495591351451.1495696619307.1495696656624.20; ubtc=2299869246.3967010957.1495696656625.E5CC6DEF6AF63D1E5DA8988E60649FDB; ubtd=20; CNZZDATA1255849575=1592477912-1495525193-%7C1495699022; CNZZDATA1254525948=661031361-1495525093-%7C1495702665; CNZZDATA1255633284=1126531119-1495523992-%7C1495702131; CNZZDATA1255604082=218540706-1495526209-%7C1495699070; _qzja=1.2144972645.1495528560415.1495698671201.1495703838842.1495698671201.1495703838842.0.0.0.16.6; _qzjc=1; select_city=510100; _jzqx=1.1495587324.1495706300.3.jzqsr=wh%2Elianjia%2Ecom|jzqct=/ershoufang/jiangan/.jzqsr=cd%2Elianjia%2Ecom|jzqct=/ershoufang/; _smt_uid=5923f46f.e37720d; _jzqa=1.1500736511112945700.1495528560.1495695227.1495706300.8; _jzqc=1; _ga=GA1.2.979376642.1495528563; _gid=GA1.2.234658946.1495707072")
            .setHttpProxy(new HttpHost("127.0.0.1", 8080));
}
