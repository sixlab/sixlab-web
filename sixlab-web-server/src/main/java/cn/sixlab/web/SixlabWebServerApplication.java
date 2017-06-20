package cn.sixlab.web;

import cn.sixlab.web.dao.SixlabUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SixlabWebServerApplication {

    @Autowired
    private SixlabUserDao dao;
    
	public static void main(String[] args) {
		SpringApplication.run(SixlabWebServerApplication.class, args);
	}
}
