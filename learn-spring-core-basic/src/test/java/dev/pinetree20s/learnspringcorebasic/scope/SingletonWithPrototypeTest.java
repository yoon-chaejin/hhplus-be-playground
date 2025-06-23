package dev.pinetree20s.learnspringcorebasic.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.*;

public class SingletonWithPrototypeTest {

    @Test
    void prototypeFind() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean prototypeBean1 = context.getBean(PrototypeBean.class);
        prototypeBean1.increment();
        assertThat(prototypeBean1.getCount()).isEqualTo(1);

        PrototypeBean prototypeBean2 = context.getBean(PrototypeBean.class);
        prototypeBean2.increment();
        assertThat(prototypeBean2.getCount()).isEqualTo(1);

    }

    @Test
    void singletonWithPrototypeFind() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(PrototypeBean.class, SingletonWithPrototypeBean.class);
        SingletonWithPrototypeBean bean1 = context.getBean(SingletonWithPrototypeBean.class);
        assertThat(bean1.logic()).isEqualTo(1);

        SingletonWithPrototypeBean bean2 = context.getBean(SingletonWithPrototypeBean.class);
        assertThat(bean2.logic()).isEqualTo(2);
    }

    @Scope("prototype")
    static class PrototypeBean {
        private int count = 0;

        public void increment() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        void init() {
            System.out.println("SingletonBean init " + this);
        }

        @PreDestroy
        void destroy() {
            System.out.println("SingletonBean destroy");
        }
    }

    static class SingletonWithPrototypeBean {
        private final PrototypeBean prototypeBean;

        public SingletonWithPrototypeBean(PrototypeBean prototypeBean) {
            this.prototypeBean = prototypeBean;
        }

        public int logic() {
            prototypeBean.increment();
            return prototypeBean.getCount();
        }

    }
}
