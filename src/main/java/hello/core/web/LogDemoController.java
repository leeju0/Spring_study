package hello.core.web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor //생성자 자동주입
//URL 정보 가져오기
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    @RequestMapping("log-demo") //"log-demo"라는 요청이 오면
    @ResponseBody
    public String logDemo(HttpServletRequest request) throws InterruptedException { //reqeustURL 요청 뭘로했는지 알 수 있음


        String requestURL = request.getRequestURL().toString();
        System.out.println("myLogger = "+myLogger.getClass());
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        Thread.sleep(1000);
        logDemoService.logic("testId");
        return "OK";
    }
}
