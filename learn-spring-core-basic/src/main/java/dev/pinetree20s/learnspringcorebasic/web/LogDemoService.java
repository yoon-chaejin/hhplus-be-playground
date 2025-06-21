package dev.pinetree20s.learnspringcorebasic.web;

import dev.pinetree20s.learnspringcorebasic.common.CustomLogger;
import org.springframework.stereotype.Service;

@Service
public class LogDemoService {
    private final CustomLogger logger;

    public LogDemoService(CustomLogger logger) {
        this.logger = logger;
    }

    public void logic(String id) {
        logger.log("service id = " + id);
    }
}
