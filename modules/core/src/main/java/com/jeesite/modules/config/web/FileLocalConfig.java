package com.jeesite.modules.config.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FileLocalConfig implements WebMvcConfigurer {

    static final String ORIGINS[] = new String[] { "GET", "POST", "PUT", "DELETE" };

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        System.out.println(FileLocalConfig.class.getResource("").toString());
        String url = FileLocalConfig.class.getResource("").toString().replace("file:/", "");

        System.out.println("**********************");
        System.out.println(url);
        System.out.println("**********************");
        if (url.contains("/webapps")) {
            url = url.substring(0, url.indexOf("/webapps"));
            url = url.substring(0, url.lastIndexOf("/"));
        } else {
            url = "C:/test001";
        }
        //图片上传路径
        String picUrl = url + "/soHero/platformPic/";
        System.out.println("**********************");
        System.out.println(url);
        System.out.println("**********************");
        registry.addResourceHandler("/image/**").addResourceLocations("file:" + picUrl);


        //registry.addResourceHandler("/image/**").addResourceLocations("file:C:/test001/vehicleImage/");
        //registry.addResourceHandler("/image/**").addResourceLocations("file:/hardDisk2/platform/");

    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowCredentials(true).allowedMethods(ORIGINS)
                .maxAge(3600).allowedHeaders("*");
    }
}
