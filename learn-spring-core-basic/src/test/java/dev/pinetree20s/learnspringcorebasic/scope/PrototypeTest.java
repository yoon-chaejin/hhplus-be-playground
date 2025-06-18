package dev.pinetree20s.learnspringcorebasic.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeTest {

    @Test
    void prototypeBeanFind() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(PrototypeBean.class);

        System.out.println("find bean1");
        PrototypeBean bean1 = context.getBean(PrototypeBean.class);
        System.out.println("bean1 = " + bean1);

        System.out.println("find bean2");
        PrototypeBean bean2 = context.getBean(PrototypeBean.class);
        System.out.println("bean2 = " + bean2);

        Assertions.assertThat(bean1).isNotEqualTo(bean2);

        context.close();
    }

    @Scope("prototype")
    static class PrototypeBean {
        @PostConstruct
        void init() {
            System.out.println("SingletonBean init");
        }

        @PreDestroy
        void destroy() {
            System.out.println("SingletonBean destroy");
        }
    }
}
