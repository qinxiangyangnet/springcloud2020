package com.yueyang.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: cloud-consumerconsul-order80
 * @description: \  使用编码配置gateway
 * @author: qinxiangyang
 * @create: 2020-04-20 14:36
 **/
@Configuration
public class GatewayConfig {


    @Bean
    public RouteLocator customerBuilder(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("payment_route", r -> r.path("/guonei").uri("http://news.baidu.com")).build();
        routes.route("payment_route", r -> r.path("/guoji").uri("http://news.baidu.com")).build();
        return routes.build();
    }


}