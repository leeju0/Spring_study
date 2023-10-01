package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {


    @BeforeEach //TEST실행전에 무조건 실행되는거
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    MemberService memberService;

    @Test
    void join() {

        //given :주어진거
        Member member = new Member(1L, "memberA", Grade.VIP);


        //when :언제
        memberService.join(member);
        Member findMember = memberService.findMember(1L);


        //then :이렇게된다.
        //위에 Assertions 사용
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}
