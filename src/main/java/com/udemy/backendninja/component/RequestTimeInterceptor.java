package com.udemy.backendninja.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor implements HandlerInterceptor{

    private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);
   
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // TODO Auto-generated method stub
        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
        //return HandlerInterceptor.super.preHandle(request, response, handler);
    }
   
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub
        long startTime = (long) request.getAttribute("startTime");
        LOG.info("--REQUEST URL : '"+request.getRequestURL().toString()+"' -- TOTAL TIME --'"+(System.currentTimeMillis() - startTime)+"' ms");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }



}
