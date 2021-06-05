package com.kakinos.webapp;
 
import java.nio.file.Path;
import java.nio.file.Paths;
 
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 
@Configuration
public class MvcConfigDoc implements WebMvcConfigurer {
 
 
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
       Path uploadDir = Paths.get("./patient-docs");  
        
        String uploadPath = uploadDir.toFile().getAbsolutePath(); 


        registry.addResourceHandler("/patient-docs/**").addResourceLocations("file://"+ uploadPath + "//");
    }
    
    @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/").setViewName("redirect:/view.html");
 }
}