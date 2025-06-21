package dev.pinetree20s.learnspringcorebasic.web;

import dev.pinetree20s.learnspringcorebasic.common.CustomLogger;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LogDemoController {
    private final LogDemoService logDemoService;
    private final CustomLogger logger;

    public LogDemoController(LogDemoService logDemoService, CustomLogger logger) {
        this.logDemoService = logDemoService;
        this.logger = logger;
    }

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String requestUrl = request.getRequestURL().toString();
        logger.setRequestUrl(requestUrl);

        logger.log("controller test");
        logDemoService.logic("testId");
        return "finished";
    }
}
