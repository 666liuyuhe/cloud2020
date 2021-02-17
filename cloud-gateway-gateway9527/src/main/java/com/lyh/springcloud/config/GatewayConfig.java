package com.lyh.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author martin
 * @date 2021/2/10
 **/

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator1(RouteLocatorBuilder locatorBuilder) {
        RouteLocatorBuilder.Builder routes = locatorBuilder.routes();
        routes.route("path1", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }

    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder locatorBuilder) {
        RouteLocatorBuilder.Builder routes = locatorBuilder.routes();
        routes.route("path2", r -> r.path("/guoji").uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }
}
