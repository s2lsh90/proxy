package hello.proxy.common.service;

import hello.proxy.cglib.code.TimeMethodInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Enhancer;

@Slf4j
public class ConcreteService {
    public void call(){
      log.info("ConcreteService 호출");

    }
}
