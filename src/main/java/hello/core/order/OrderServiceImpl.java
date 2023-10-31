package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;



    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);//1.회원정보조회
        int discountPrice = discountPolicy.discount(member, itemPrice);//2.할인정책에 회원 위임

        return new Order(memberId, itemName, itemPrice, discountPrice);//최종생성된 주문을 반환함
    }

    //테스트 용도 입니다
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}


