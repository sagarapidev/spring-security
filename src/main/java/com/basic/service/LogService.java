package com.basic.service;

import com.basic.domain.Role;
import com.basic.domain.User;
import com.basic.repository.RoleRepository;
import com.basic.repository.UserRepository;
import com.basic.resource.RoleResource;
import com.basic.resource.UserResource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class LogService {
    @Autowired
    UserRepository userRepository;
    private static final Logger logger = LogManager.getLogger(LogService.class);
    @GetMapping ("/log")
    public void logEvent(){
        logger.error(" system info"+System.getProperties());
    };
}
