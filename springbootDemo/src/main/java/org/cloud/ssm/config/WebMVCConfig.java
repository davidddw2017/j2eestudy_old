package org.cloud.ssm.config;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

public class WebMVCConfig extends WebMvcConfigurationSupport {
    
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public FreeMarkerViewResolver viewResolver()
            throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setPrefix("");
        resolver.setSuffix(".ftl");
        resolver.setContentType("text/html; charset=UTF-8");
        return resolver;
    }

    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new PostAndPutCommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(500000000);
        return multipartResolver;
    }

    /** 
     *  浏览器form表单只支持GET与POST请求，而DELETE、PUT等method并不支持 解决不支持put form数据的问题
     */
    class PostAndPutCommonsMultipartResolver extends CommonsMultipartResolver {
        @Override
        public boolean isMultipart(HttpServletRequest request) {
            String method = request.getMethod().toLowerCase();
            // By default, only POST is allowed. Since this is an 'update' we should accept
            // PUT.
            if (!Arrays.asList("put", "post").contains(method)) {
                return false;
            }
            String contentType = request.getContentType();
            return (contentType != null && contentType.toLowerCase().startsWith("multipart/"));
        }
    }

    /**
     * 使用的是将界面资源放在resource下边的方式
     * 
     * @return
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
