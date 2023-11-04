package hello.core.lifecycle;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient{
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);

    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect() {
        System.out.println("connect = " + url);

    }

    public void call(String message) {
        System.out.println("call: "+url+" message= "+message);
    }

    //서비스 종료 시
    public void disconnect() {
        System.out.println("close: "+url);
    }

    //외존관계 주입이 끝나면 호출
    @PostConstruct
    public void init(){
        System.out.println("NetwokrClient.init");
        connect(); //의존관계 주입이 끝나면 연결할것이다.
        call("초기화 연결 메세지");
    }

    //빈 사망 전에 호출
    @PreDestroy
    public void close()  {
        System.out.println("NetworkClient.destroy");
        disconnect();
    }
}
