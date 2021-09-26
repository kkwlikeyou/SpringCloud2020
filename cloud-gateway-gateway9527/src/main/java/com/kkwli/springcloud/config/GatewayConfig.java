package com.kkwli.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author kkwli
 * @Since 2021/9/26 8:44
 */
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        RouteLocator routeLocator = routes.route("path_route_kkwli", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routeLocator;
    }

    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        RouteLocator routeLocator = routes.route("path_route_kkwli2", r -> r.path("/guoji").uri("http://news.baidu.com/guoji")).build();
        return routeLocator;
    }
}
