package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();
    @Test
    void join() {
        //given :주어진거
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when :언제
        memberService.join(member);
        Member findMember = memberService.findMember(1L);


        //then :이렇게된다.
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
