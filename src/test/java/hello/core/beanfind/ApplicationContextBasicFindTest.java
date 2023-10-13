package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회하기")
    void findBeanByName() {

        MemberService memberService = ac.getBean("memberService", MemberService.class);
        //memberService가 MemberServiceImpl의 instance이면 성공
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }
    @Test
    @DisplayName("이름없이 타입으로만 조회")
    void findBeanByType() {

        MemberService memberService = ac.getBean(MemberService.class);
        //memberService가 MemberServiceImpl의 instance이면 성공
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }
    @Test
    @DisplayName("구체타입으로 조회")
    void findBeanByName2() {

        MemberServiceImpl memberService = ac.getBean("memberService",MemberServiceImpl.class);
        //memberService가 MemberServiceImpl의 instance이면 성공
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

    @Test
    @DisplayName("빈 이름으로 조회x : 실패테스트")
    void findBeanByNameX() {
        //MemberService xxxx = ac.getBean("xxxx", MemberService.class);

        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxx", MemberService.class));
        // -> 이쪽에 있는 로직을 실행하면, NoSuchBean~ 예외가 터져야한다.

    }


}
