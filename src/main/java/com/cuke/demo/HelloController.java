package com.cuke.demo;

import com.cuke.service.ResidenceService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangjw on 2017/5/18 0018.
 */

@RestController
@EnableAutoConfiguration
public class HelloController {

    @Resource
    private ResidenceService residenceService;

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
