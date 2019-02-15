package com.apidoc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.apidoc.dao")//mybatis-plus mapper扫描
public class ApiDocApplication {

    private static String port;

    @Value("${server.port}")
    public void setPort(String port) {
        ApiDocApplication.port = port;
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiDocApplication.class, args);
        //输出服务地址url，方便开发调试
        printServerUrl();
    }

    private static void printServerUrl() {

        String url = String.format("http://%s%s%s", "localhost" + ":", port, "/apidoc/index.html?packageName=com.demo");

        System.err.println("-----------------------------------------------------------------");
        System.err.println();
        System.err.println("##### 程序启动成功！");
        System.err.println();
        System.err.println("##### 点击该服务地址打开浏览器 : " + url);
        System.err.println();
        System.err.println("-----------------------------------------------------------------");

    }
}
