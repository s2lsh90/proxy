package proxyfactory;

import hello.proxy.common.advice.TimeAdvice;
import hello.proxy.common.service.ConcreteService;
import hello.proxy.common.service.ServiceImpl;
import hello.proxy.common.service.ServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;

@Slf4j
public class ProxyFactoryTest {
    @Test
    @DisplayName("인터페이스가 있으면 JDK")
    void interfaceProxy(){
        ServiceInterface target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice());
        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();
        log.info("target Class = {}", target.getClass());
        log.info("proxy Class = {}", proxy.getClass());
        proxy.save();

        Assertions.assertThat(AopUtils.isAopProxy(proxy)).isTrue();
     }

     @Test
     @DisplayName("구체 클레스만 있으면 CGLIB 사용")
    void concreteProxy(){
         ConcreteService target = new ConcreteService();
         ProxyFactory proxyFactory = new ProxyFactory(target);
         proxyFactory.addAdvice(new TimeAdvice());
         ConcreteService proxy = (ConcreteService) proxyFactory.getProxy();
         log.info("target Class = {}", target.getClass());
         log.info("proxy Class = {}", proxy.getClass());
         proxy.call();

         Assertions.assertThat(AopUtils.isAopProxy(proxy)).isTrue();
     }


    @Test
    @DisplayName("옵션 넣어서 cglib 안쓰고 jdk")
    void proxyTargetClass(){
        ConcreteService target = new ConcreteService();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(true);
        proxyFactory.addAdvice(new TimeAdvice());
        ConcreteService proxy = (ConcreteService) proxyFactory.getProxy();
        log.info("target Class = {}", target.getClass());
        log.info("proxy Class = {}", proxy.getClass());
        proxy.call();

        Assertions.assertThat(AopUtils.isAopProxy(proxy)).isTrue();
    }

}
