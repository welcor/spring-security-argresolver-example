package org.springframework.security.samples.web;

import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * Simple controller
 */

@RestController
public class SimpleController {

    @GetMapping("/")
    @PreAuthorize("@calleeSecurityBean.preauth()")
    public String helloWorld(
            Callee callee,
            @RequestHeader(name = "callee", required = false) String header
    ) {
        LoggerFactory.getLogger(SimpleController.class).info("Method on controller called, header={}", header);
        return "Hello "+callee.getName();
    }
}
