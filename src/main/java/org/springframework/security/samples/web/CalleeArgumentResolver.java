package org.springframework.security.samples.web;

import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.*;

/**
 * Simple header resolver
 */

public class CalleeArgumentResolver implements HandlerMethodArgumentResolver {
    @Override public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Callee.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        LoggerFactory.getLogger(CalleeArgumentResolver.class).info("Resolving Callee. webRequest={}", webRequest);
        String callee = webRequest.getHeader("callee");
        if (callee == null) {
            throw new IllegalArgumentException("No callee header found!");
        }
        return new Callee(callee);
    }
}
