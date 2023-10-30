package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{
    //추상화에도 의존하고 구체화에도 의존하는 상황 ,DIP 위반
    //아래 코드만을 보면 memberRepository는 MemberRepository, MemoryMemberRepository 둘을 모두 의존한다
    private final MemberRepository memberRepository;

    @Autowired //생성자에 붙여줌, 자동의존관계주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    //join에서 save를 호출하면,,다형성에 의해서,, MemberRepository의 save()가 호출되는것이 아니라
    //인터페이스를 구현한 MemoryMemberReposiotry의 save()가 호출된다.
    @Override
    public void join(Member member) {

        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }


}
