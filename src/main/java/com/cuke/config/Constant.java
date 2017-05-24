package com.cuke.config;

import us.codecraft.webmagic.Site;

/**
 * Created by wangjw on 2017/5/23 0023.
 */
public class Constant {


    public static final String[] cityCodeArray = {"sh","wh","bj","tj","nj","qd","dl","sz","cd","cq","jn","gz","hz","cs","xm","sy", "hf"};

    public static final String url = "lianjia.com/ershoufang/";





    public static final Site site = Site.me()
            .setDomain("lianjia.com")
            .setRetryTimes(6)
            .setCycleRetryTimes(6)
            .setSleepTime(2000)
//            .addCookie("all-lj", "ae53ba2bb01d9055b48cc0081f0ce3f9")
//            .addCookie("lianjia_uuid", "ab894b9e-a588-4f0a-b6ec-cfab3e13d2e0")
//            .addCookie("UM_distinctid", "15c1e47d283b5f-02890f62176777-6a11157a-100200-15c1e47d28498c")
//            .addCookie("_jzqx", "1.1495156642.1495160862.2.jzqsr=wh%2Elianjia%2Ecom|jzqct=/.jzqsr=wh%2Elianjia%2Ecom|jzqct=/ershoufang/")
//            .addCookie("select_city", "420100")
//            .addCookie("_jzqckmp", "1")
//            .addCookie("_smt_uid", "591e47a1.3ca757e6")
//            .addCookie("CNZZDATA1255849575", "518992096-1495152253-%7C1495437389")
//            .addCookie("CNZZDATA1254525948", "1268543338-1495151445-%7C1495436887")
//            .addCookie("CNZZDATA1255633284", "1697284692-1495155913-%7C1495436814")
//            .addCookie("CNZZDATA1255604082", "1221577192-1495151371-%7C1495437716")
//            .addCookie("_qzja", "1.1773252320.1495156642402.1495160861821.1495436396533.1495439803434.1495440048658.0.0.0.25.3")
//            .addCookie("_qzjb", "1.1495436396532.14.0.0.0")
//            .addCookie("_qzjc", "1")
//            .addCookie("_qzjto", "14.1.0")
//            .addCookie("_jzqa", "1.2867534514407142000.1495156642.1495160862.1495436397.3")
//            .addCookie("_jzqc", "1")
//            .addCookie("_jzqb", "1.14.10.1495436397.1")
//            .addCookie("_ga", "GA1.2.463186900.1495156650")
//            .addCookie("_gid", "GA1.2.1636028203.1495440050")
//            .addCookie("lianjia_ssid", "64ce2c9e-89fa-4bbe-bad1-4e39470d9aa4")
            .addCookie("CNZZDATA1253477573", "854456868-1495456814-%7C1495539108")
            .addCookie("CNZZDATA1254525948", "682061377-1495458487-%7C1495542274")
            .addCookie("CNZZDATA1255604082", "810532355-1495457995-%7C1495543180")
            .addCookie("CNZZDATA1255633284", "1881935743-1495457572-%7C1495540083")
            .addCookie("UM_distinctid", "15c303aaa21685-0de4a46457fa3e-5d4e211f-1fa400-15c303aaa2236f")
            .addCookie("_ga", "GA1.2.1378865938.1495457777")
            .addCookie("_gat", "1")
            .addCookie("_gat_dianpu_agent", "1")
            .addCookie("_gat_global", "1")
            .addCookie("_gat_new_global", "1")
            .addCookie("_gat_past", "1")
            .addCookie("_gid", "GA1.2.184371838.1495543394")
            .addCookie("_jzqa", "1.690897097566904700.1495543374.1495543374.1495543374.1")
            .addCookie("_jzqb", "1.5.10.1495543374.1")
            .addCookie("_jzqc", "1")
            .addCookie("_jzqckmp", "1")
            .addCookie("_jzqx", "1.1495543374.1495543374.1.jzqsr=captcha%2Elianjia%2Ecom|jzqct=/.-")
            .addCookie("_qzja", "1.1444704220.1495543374152.1495543374152.1495543374153.1495543384256.1495543392612.0.0.0.5.1")
            .addCookie("_qzjb", "1.1495543374153.5.0.0.0")
            .addCookie("_qzjc", "1")
            .addCookie("_qzjto", "5.1.0")
            .addCookie("_smt_uid", "5922dfe9.18094940")
            .addCookie("all-lj", "1e9f8fe64a0d8d4cd8642eafcff9cfff")
            .addCookie("lianjia_ssid", "e33a6fcc-f30d-46e1-b00b-c71b6cc96577")
            .addCookie("lianjia_uuid", "0ae63f68-df84-4635-849f-c9fd65293428")
            .addCookie("sample_traffic_test", "controlled_66")
            .addCookie("select_city", "110000")
            .setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
}
