package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeTest {

    @Test
    void prototypeBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        System.out.println("find prototypeBean1");
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        System.out.println("find prototypeBean2");
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean2 = " + prototypeBean2);
        Assertions.assertThat(prototypeBean1).isNotSameAs(prototypeBean2);
        ac.close();

    }
    @Scope("prototype")
    //@Component 이 없는데요?? 괜찮다 위 코드에서 new AnnotationConfigApplicationContext(PrototypeBean.class); -> PrototypeBean 빈 등록함
    static class PrototypeBean {
        @PostConstruct //초기화 콜백
        public void init() {
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy //소멸전 콜백
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }

    }
}
