package hello.proxy.pureproxy.decorator;

import hello.proxy.pureproxy.decorator.code.*;
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

    @Test
    void Decorator2() {
        Component realComponent = new RealComponent();
        Component messageDecorator = new MessageDecorator(realComponent);
        Component timeDecorator = new TimeDecorator(messageDecorator);
        DecoratorPatternClient client = new DecoratorPatternClient(timeDecorator);
        client.execute();
    }
}
