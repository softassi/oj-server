package com.softassi.oj.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAsync
public class ServerApplication {
    private static final Logger LOG = LoggerFactory.getLogger(ServerApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ServerApplication.class);
        ConfigurableEnvironment environment = app.run(args).getEnvironment();
        LOG.info("启动成功");
        LOG.info("System地址: \t http://127.0.0.1:{}", environment.getProperty("server.port"));
        LOG.info("Swagger2地址: \t http://127.0.0.1:{}/swagger-ui.html", environment.getProperty("server.port"));
    }

}
