package dev.pinetree20s.learnspringcorebasic.applicationcontext;

import dev.pinetree20s.learnspringcorebasic.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextTest {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 정보 출력하기")
    void printBeans() {
        //given

        //when
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = context.getBean(beanDefinitionName);
            System.out.println("name : " + beanDefinitionName + ", bean : " + bean);
        }

        //then
    }

    @Test
    @DisplayName("애플리케이션 빈 정보 출력하기")
    void printApplicationBeans() {
        //given

        //when
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = context.getBeanDefinition(beanDefinitionName);
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION)
                System.out.println("name : " + beanDefinitionName + ", bean : " + beanDefinition);
        }

        //then
    }
}
