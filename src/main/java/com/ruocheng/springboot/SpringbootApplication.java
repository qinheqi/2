package com.ruocheng.springboot;
import com.ruocheng.springboot.Common.AuthFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.ruocheng.springboot.Mapper")
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean<AuthFilter> getFilterRegistrationBean(){
         FilterRegistrationBean<AuthFilter> bean = new FilterRegistrationBean<>(new AuthFilter());
         bean.addUrlPatterns("/","*.html");
         return bean;
    }

}
