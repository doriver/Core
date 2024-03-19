package hello.core.web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor // final이 붙은 필드를 모아서 생성자를 만들어줌 > 생성자가 하나면 자동으로 의존관계 주입 됨
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger; // 프록시로 일단 가짜를 넣어둠

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();
//        MyLogger myLogger = myLoggerProvider.getObject(); // HTTP 요청이 진행중이므로 request scope빈 이 생성된다

        System.out.println("myLogger = " + myLogger.getClass());
        myLogger.setRequestURL(requestURL); // 기능을 실제 호출하는 시점에, 진짜를 찾아서 동작

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "Ok";
    }

}
