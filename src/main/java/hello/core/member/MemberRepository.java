package hello.core.member;

//회원 저장소 인터페이스
public interface MemberRepository {
    //회원을 저장한다.
    void save(Member member);

    //회원 id로 회원을 찾는다. - 이때 멤버의 id값을 매개변수로 취한다.
    //반환값은 id값에 대응하는 해당 객체이다.
    //반환유형이 Member
    Member findById(Long memberId);
}
