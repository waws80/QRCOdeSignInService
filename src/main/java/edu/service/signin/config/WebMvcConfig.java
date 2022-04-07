package edu.service.signin.config;

import edu.service.signin.filter.HeaderEditFilter;
import edu.service.signin.utils.GsonUtils;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    HttpMessageConverters convert(){
        List<HttpMessageConverter<?>> convertList = new ArrayList<>();
        GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
        gsonHttpMessageConverter.setGson(GsonUtils.getGson());
        convertList.add(gsonHttpMessageConverter);
        return new HttpMessageConverters(true, convertList);
    }

    @Bean
    FilterRegistrationBean<Filter> addFilters(){
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new HeaderEditFilter());
        return filterFilterRegistrationBean;
    }
}
