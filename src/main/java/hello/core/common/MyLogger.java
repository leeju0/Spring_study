package hello.core.common;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS) //프록시 사용하는 웹 스코프
public class MyLogger {
    private String uuid;
    private String requestURL; //나중에 별도로 세팅하자! -> 세터

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) { //로그 남기기
        System.out.println("["+uuid+"]"+"["+requestURL+"]"+message);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();// uuid 값 초기화 , 랜덤한 값으로
        System.out.println("["+uuid+"]"+"request scope bean create: "+this);
    }

    @PreDestroy
    public void close() { //고객 요청이 끝나면 ..
        System.out.println("["+uuid+"]"+"request scope bean close: "+this);
    }
}
