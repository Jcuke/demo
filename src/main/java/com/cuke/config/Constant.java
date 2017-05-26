package com.cuke.config;

import us.codecraft.webmagic.Site;

/**
 * Created by wangjw on 2017/5/23 0023.
 */
public class Constant {


    public static final String[] cityCodeArray = {"wh", "bj", "tj", "nj", "qd", "dl", "sz", "cd", "cq", "jn", "gz", "hz", "cs", "xm", "sy", "hf"};

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
            .setDomain("www.lianjia.com")
            .setRetryTimes(6)
            .setCycleRetryTimes(6)
            .setSleepTime(100)
            .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
            .addHeader("Accept-Encoding", "gzip, deflate, sdch, br")
            .addHeader("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6")
            .addHeader("Connection", "keep-alive")
            .addHeader("Host", "www.lianjia.com")
//            .addHeader("Referer", "https://cq.lianjia.com/")
            .addHeader("Upgrade-Insecure-Requests", "1")
            .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36")
            .addHeader("Cookie", "lianjia_uuid=0ae63f68-df84-4635-849f-c9fd65293428; UM_distinctid=15c303aaa21685-0de4a46457fa3e-5d4e211f-1fa400-15c303aaa2236f; gr_user_id=70a616c5-4e3e-4d6a-bc34-5f5be2fa253f; _jzqx=1.1495543374.1495724923.3.jzqsr=captcha%2Elianjia%2Ecom|jzqct=/.jzqsr=lianjia%2Ecom|jzqct=/ershoufang/wuhou/pg2/; _jzqckmp=1; all-lj=1e9f8fe64a0d8d4cd8642eafcff9cfff; _qzja=1.1361273877.1495755387364.1495755387364.1495755387364.1495755387364.1495755387364.0.0.0.1.1; _qzjb=1.1495755387364.1.0.0.0; _qzjc=1; _qzjto=1.1.0; CNZZDATA1255849584=320431035-1495755385-%7C1495755385; CNZZDATA1254525948=933906727-1495752660-%7C1495752660; CNZZDATA1255633284=412648585-1495755367-%7C1495755367; CNZZDATA1255604082=473793621-1495753309-%7C1495753309; select_city=510100; gr_session_id_a1a50f141657a94e=26f24538-23bf-4877-bc21-15598c1da267; _smt_uid=59276a69.356eabff; _jzqa=1.2087680399991776000.1495755370.1495755370.1495755370.1; _jzqc=1; _jzqb=1.4.10.1495755370.1; _ga=GA1.2.1378865938.1495457777; _gid=GA1.2.987780719.1495755738; lianjia_ssid=ceebd31e-4e8a-0954-1fdd-be0b05375d20");
}
