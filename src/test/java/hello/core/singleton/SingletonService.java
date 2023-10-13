package hello.core.singleton;

public class SingletonService {
    //static영역에 자기 자신 객체를 생성한다음에 instance에 넣어둠,
    // 이 instance의 참조를 꺼낼 수있는 방법은 getInstance()뿐 그리고 생성할 수 있는 곳은 아무데도 없음
    private static final SingletonService instance = new SingletonService();
    //static을 사용하면 스태틱 메모리 영역에 해당 코드 결과가
    // 따로 올라가서, 모든 객체가 동일한 값을 공유하게 할 수 있다.



    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
        System.out.println("싱글톤 객체 로직 호출했다.");
    }

}
