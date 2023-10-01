package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%할인이 적용되어야 한다.")
    void vip_o() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP); //멤버 하나 만들자
        //when
        int discount = discountPolicy.discount(member, 10000); //10000원을 넘겨주면?

        //then
        assertThat(discount).isEqualTo(1000); //1000원 나와야한다

    }
    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
    void vip_x() {
        //given
        Member member = new Member(1L, "memberBASIC", Grade.BASIC); //멤버 하나 만들자
        //when
        int discount = discountPolicy.discount(member, 10000); //10000원을 넘겨주면?

        //then
        assertThat(discount).isEqualTo(0); //0원 나와야한다

    }
}