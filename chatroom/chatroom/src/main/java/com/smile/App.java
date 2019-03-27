package com.smile;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @SpringBootApplication：包含了@ComponentScan、@Configuration和@EnableAutoConfiguration注解。
 * 其中@ComponentScan让spring Boot扫描到Configuration类并把它加入到程序上下文。
 */
@EnableTransactionManagement(proxyTargetClass = true)
@SpringBootApplication(scanBasePackages = "com.smile")
@MapperScan(basePackages = "com.smile.mapper")
public class App extends SpringBootServletInitializer{


    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }

//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(App.class);
//    }
//
//    public static void main(String[] args) throws Exception {
//        SpringApplication.run(App.class, args);
//    }

}
