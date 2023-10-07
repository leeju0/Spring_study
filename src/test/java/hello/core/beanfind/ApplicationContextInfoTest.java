package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest {
    //1. 스프링컨테이너 객체생성
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


    //ac.getBeanDefinitionNames() : 스프링에 등록된 모든 빈 이름을 조회한다. -> 빈 이름 조회
    //ac.getBean() : 빈 이름으로 빈 객체(인스턴스)를 조회한다. -> 위에 조회한 빈의 객체 조회

    @Test
    @DisplayName("모든 빈 출력하기") //스프링 자체적으로 갖고있는 모든 빈 포함
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = "+ beanDefinitionName +" object="+bean);
        }
    }
    @Test
    @DisplayName("애플리케이션 빈 출력하기") //우리가 직접 만든 빈만 출력
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            //Role ROLE_APPLICATION: 직접 등록한 애플리케이션
            //Role ROLE_INFRASTRUCTURE : 스프링 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = "+ beanDefinitionName +" objtect="+bean);

            }
        }
    }
}
