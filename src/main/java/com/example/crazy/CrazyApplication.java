package com.example.crazy;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.example.crazy.mapper")
public class CrazyApplication {

    private final static Logger LOG = LoggerFactory.getLogger(CrazyApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(CrazyApplication.class);
        app.run(args).getEnvironment();
        LOG.info("启动成功！！");
    }

}
