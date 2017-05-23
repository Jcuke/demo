package com.cuke.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.support.ChainedPersistenceExceptionTranslator;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableTransactionManagement
@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages = {"com.cuke", "com.cuke.crawl", "com.cuke.example.demo"})
public class DemoApplication extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//        new Thread(new MyThread()).start();

        SysInit.init1();
	}

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    //参数以下说法解决启动异常问题
    //http://stackoverflow.com/questions/8434712/no-persistence-exception-translators-found-in-bean-factory-cannot-perform-excep
    @Bean
    public PersistenceExceptionTranslator exceptionTranslator(){
        return new ChainedPersistenceExceptionTranslator();
    }
}