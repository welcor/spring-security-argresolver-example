package org.springframework.security.samples.web;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * // TODO: describe
 */

@Component
public class CalleeSecurityBean {
    public boolean preauth() {
        LoggerFactory.getLogger(CalleeSecurityBean.class).info("Preauth called");
        return true;
    }
}
