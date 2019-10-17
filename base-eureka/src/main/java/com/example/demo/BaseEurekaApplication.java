package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableEurekaServer
@SpringBootApplication
public class BaseEurekaApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BaseEurekaApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(BaseEurekaApplication.class, args);
    }

    /**
     * 为防止别的服务注册eureka时报错：
     * com.fasterxml.jackson.databind.exc.MismatchedInputException:
     * Root name 'timestamp' does not match expected ('instance') for type [simple type, class com.netflix.appinfo.InstanceInfo]
     */
    @EnableWebSecurity
    static class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            //Howard 2019-03-20,错误的做法：
            //http.csrf().disable();//这样会直接取消验证账号密码了
            //Howard 2019-03-20，注意 正确的做法是这样：
            http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();
        }
    }
}
