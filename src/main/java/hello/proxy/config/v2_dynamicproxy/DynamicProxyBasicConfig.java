package hello.proxy.config.v2_dynamicproxy;

import hello.proxy.app.v1.OrderControllerV1;
import hello.proxy.app.v1.OrderRepositoryV1;
import hello.proxy.app.v1.OrderRepositoryV1Impl;
import hello.proxy.app.v1.OrderServiceV1;
import hello.proxy.config.v2_dynamicproxy.handler.LogTraceBasicHandler;
import hello.proxy.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

@Configuration
@Slf4j
public class DynamicProxyBasicConfig {
    @Bean
    public OrderRepositoryV1 orderRepositoryV1(LogTrace logTrace){
        OrderRepositoryV1 orderRepositoryV1 = new OrderRepositoryV1Impl();
        return (OrderRepositoryV1) Proxy.newProxyInstance(OrderRepositoryV1.class.getClassLoader() ,
                new Class[] {OrderRepositoryV1.class}, new LogTraceBasicHandler(orderRepositoryV1, logTrace));
    }
    @Bean
    public OrderServiceV1 orderServiceV1(LogTrace logTrace){
        OrderRepositoryV1 orderServiceV1 = new OrderRepositoryV1Impl();
        return (OrderServiceV1) Proxy.newProxyInstance(OrderServiceV1.class.getClassLoader() ,
                new Class[] {OrderServiceV1.class}, new LogTraceBasicHandler(orderServiceV1, logTrace));
    }
    @Bean
    public OrderControllerV1 orderControllerV1(LogTrace logTrace){
        OrderRepositoryV1 orderControllerV1 = new OrderRepositoryV1Impl();
        return (OrderControllerV1) Proxy.newProxyInstance(OrderControllerV1.class.getClassLoader() ,
                new Class[] {OrderControllerV1.class}, new LogTraceBasicHandler(orderControllerV1, logTrace));
    }
}
