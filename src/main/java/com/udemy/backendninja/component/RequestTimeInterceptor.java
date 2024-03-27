package com.udemy.backendninja.component;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.udemy.backendninja.repository.LogRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor implements HandlerInterceptor{

    @Autowired
    @Qualifier("logRepository")
    LogRepository logRepository;

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
        String url = request.getRequestURL().toString();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username="";
        if(null!=auth && auth.isAuthenticated()){
            username=auth.getName();
        }
        logRepository.save(new com.udemy.backendninja.entity.Log(new Date(),auth.getDetails().toString(),username,url));
        LOG.info("Url to: '"+request.getRequestURL().toString()+"' in '"+(System.currentTimeMillis() - startTime)+"' ms");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }



}
