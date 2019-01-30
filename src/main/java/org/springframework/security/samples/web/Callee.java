package org.springframework.security.samples.web;

import org.slf4j.LoggerFactory;

/**
 * Simple argument class
 */

public class Callee {
    private String name;

    public Callee(String name) {
        this.name = name;
        LoggerFactory.getLogger(Callee.class).info("Creating Callee. name={}", name);
    }

    public String getName() {
        return name;
    }
}
