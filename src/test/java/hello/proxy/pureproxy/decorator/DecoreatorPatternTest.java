package hello.proxy.pureproxy.decorator;

import hello.proxy.pureproxy.decorator.code.Component;
import hello.proxy.pureproxy.decorator.code.DecoratorPatternClient;
import hello.proxy.pureproxy.decorator.code.MessageDecorator;
import hello.proxy.pureproxy.decorator.code.RealComponent;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoreatorPatternTest {

    @Test
    void noDecorator(){
        Component realcomponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realcomponent);
        client.execute();
    }

    @Test
    void Decorator1(){
        Component realcomponent = new RealComponent();
        Component messsageDecorator = new MessageDecorator(realcomponent);
        DecoratorPatternClient client = new DecoratorPatternClient(messsageDecorator);
        client.execute();
    }
}
