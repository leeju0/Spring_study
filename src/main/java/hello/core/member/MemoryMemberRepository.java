package hello.core.member;

//회원 저장소, 구현체 1

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository {
    // 멤버 ID를 Member객체와 key-value형태로 매핑하는 변수 : store
    private static Map<Long,Member> store = new HashMap<>();


    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
