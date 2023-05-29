package hello.proxy.pureproxy.concreteproxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeProxy extends ConcreteLogic{
    private final ConcreteLogic concreteLogic;


    public TimeProxy(ConcreteLogic concreteLogic) {
        this.concreteLogic = concreteLogic;

    }
    @Override
    public String operation(){
      log.info("TimeDecorator 실행");
      String result = concreteLogic.operation();
       log.info("TimeDecorator 종료");
       return  result;
    }
}
