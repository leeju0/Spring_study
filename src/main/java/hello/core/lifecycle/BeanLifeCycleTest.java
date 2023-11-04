package hello.core.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testng.annotations.Test;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycyleTest() {
        //Configurable~ 은 Annotation~의 부모이며, ac.close()를 쓸수있게해줌
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();

    }

    @Configuration //싱글톤 빈 등록 스프링 컨테이너
    static class LifeCycleConfig {
        @Bean //NetworkClient의 인스턴스를 빈으로 등록함
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient(); //생성자 호출
            networkClient.setUrl("http://naver.com");
            return networkClient;
        }
    }
}
