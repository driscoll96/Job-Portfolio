//package edu.neu.ccs.cs5500.config;
//
//import edu.neu.ccs.cs5500.filter.RequestInfoFilter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class FilterConfig {
//
//  @Bean
//  public FilterRegistrationBean testFilterRegistration() {
//
//    FilterRegistrationBean registration = new FilterRegistrationBean();
//    registration.setFilter(new RequestInfoFilter());
//    registration.addUrlPatterns("/*");
//    registration.setName("RequestInfoFilter");
//    registration.setOrder(1);
//    return registration;
//  }
//
//}
