package com.udemy.backendninja.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.service.Example5Service;

@Service("example5Service")
public class Example5ServiceImpl implements Example5Service{

    private static final Log LOG=LogFactory.getLog(Example5ServiceImpl.class);
    @Override
    public Log MensajeLog() {
        LOG.info("Soy la cazadora Buffy Summers");
        return LOG;
    }
    

}
