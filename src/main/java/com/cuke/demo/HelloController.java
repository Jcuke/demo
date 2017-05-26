package com.cuke.demo;

import com.cuke.service.ResidenceService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangjw on 2017/5/18 0018.
 */

@RestController
@EnableAutoConfiguration
public class HelloController {

    @Resource
    private ResidenceService residenceService;


    @RequestMapping(value = "/crawlByCityid/{cityid}", method= RequestMethod.GET)
    @ResponseBody
    public Object crawlByCityid(@PathVariable String cityid){
        try{
            SysInit.start(new String[]{cityid});
            return "1";
        }catch (Exception e){
            return e;
        }
    }

    @RequestMapping(value = "/getEachCityData", method= RequestMethod.GET)
    @ResponseBody
    public List getEachCityData(){
        List list = residenceService.selectCustomSqlToList("getEachCityData", null);
        return list;
    }

    @RequestMapping(value = "/getEachCityFyCount", method= RequestMethod.GET)
    @ResponseBody
    public List getEachCityFyCount(){
        List list = residenceService.selectCustomSqlToList("getEachCityFyCount", null);
        return list;
    }

    @RequestMapping(value = "/getWhEachDistrictData/{cityid}", method= RequestMethod.GET)
    @ResponseBody
    public List getWhEachDistrictData(@PathVariable String cityid){
        System.out.println("hello");
        Map<String, String> param = new HashMap<>();
        param.put("cityid", cityid);
        List list = residenceService.selectCustomSqlToList("getWhEachDistrictData", param);

        return list;
    }

    @RequestMapping(value = "/getEachDistrictFyCount/{cityid}", method= RequestMethod.GET)
    @ResponseBody
    public List getEachDistrictFyCount(@PathVariable String cityid){
        System.out.println("hello");
        Map<String, String> param = new HashMap<>();
        param.put("cityid", cityid);
        List list = residenceService.selectCustomSqlToList("getEachDistrictFyCount", param);

        return list;
    }



    @RequestMapping(value = "/getCityNames", method= RequestMethod.GET)
    @ResponseBody
    public List getCityNames(){
        List list = residenceService.selectCustomSqlToList("getCityNames", null);
        return list;
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        System.out.println("hello");
        return "hwlloe ";
    }

    @RequestMapping("/helloJson")
    public StuDomain getJson(){
        System.out.println("getJson");
        try {
            residenceService.saves();
        } catch (Exception e) {
            e.printStackTrace();
        }
        StuDomain sd = new StuDomain();
        sd.setName("rr3r3r3r");
        return sd;
    }

    @RequestMapping("/threadToggle")
    public boolean threadToggle(HttpServletRequest request){
        try {
            MyThread.isRun = Boolean.parseBoolean(request.getParameter("isRun"));
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
