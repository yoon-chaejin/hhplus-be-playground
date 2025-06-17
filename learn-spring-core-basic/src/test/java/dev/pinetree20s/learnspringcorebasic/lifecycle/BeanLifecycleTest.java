package dev.pinetree20s.learnspringcorebasic.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifecycleTest {

    @Test
    public void testBeanLifecycle() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(BeanLifecycleConfig.class);
        System.out.println("get bean start");
        NetworkClient networkClient = context.getBean(NetworkClient.class);
        System.out.println("get bean end");

        System.out.println("close start");
        context.close();
        System.out.println("close end");
    }

    @Configuration
    static class BeanLifecycleConfig {
        @Bean(initMethod = "init", destroyMethod = "close")
        public NetworkClient networkClient() {
            // 객체 생성
            NetworkClient networkClient =  new NetworkClient();
            // 의존관계 주입
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
