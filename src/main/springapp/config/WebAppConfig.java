package main.springapp.config;

import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewInterceptor;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/3/13 0013.
 */



@Configuration
@EnableWebMvc
@ComponentScan(
        basePackages = {
                "main.springapp.controller",
                "main.springapp.service",
                "main.springapp.security"
        })
@PropertySource("classpath:conf/application.properties")
@Import({ DataBaseConfig.class})
public class WebAppConfig extends WebMvcConfigurerAdapter {

    @Resource
    private Environment environment;

    /**
     * 静态资源过滤
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
        registry.addResourceHandler("/data/**").addResourceLocations("/data/");
    }

    /**
     * 将对于静态资源的请求转发到Servlet容器的默认处理静态资源的servlet
     * 因为将spring的拦截模式设置为"/"时会对静态资源进行拦截
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addWebRequestInterceptor(openEntityManagerInViewInterceptor());
    }

    /**
     * 使用JPA  懒加载数据容易出现 no session 问题，可以加这个拦截器，
     * 相对使用Filter 来说， 这个数据库事物是在找到相应的处理者之后才会打开
     */
    @Bean
    public OpenEntityManagerInViewInterceptor openEntityManagerInViewInterceptor(){
        return new OpenEntityManagerInViewInterceptor();
    }

    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(10 * 1024 * 1024);
        return multipartResolver;
    }

}
