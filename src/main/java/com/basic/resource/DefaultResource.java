package com.basic.resource;

import com.basic.domain.User;
import com.basic.exception.UserNotFoundException;
import com.basic.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/v1")
public class DefaultResource {
    private static final Logger logger = LogManager.getLogger(DefaultResource.class);

    @Autowired
    MessageSource msg;
    @Autowired
    UserRepository userRepository;
    @Autowired
    @Lazy
    private BCryptPasswordEncoder encoder;

    @PostMapping("/default/save")
    public ResponseEntity<Object> saveUser(@RequestBody User user){
        logger.info("Defalut Admin Request:{}"+user);
        User Usr=userRepository.findByEmail(user.getEmail());
        logger.info(Usr);
            //check is user exist
        if(Usr!=null){
            return new ResponseEntity<>(msg.getMessage("exist.id", null, "Default Message", LocaleContextHolder.getLocale()), HttpStatus.OK);
        }

        //encode password
        user.setPassword(encoder.encode(user.getPassword()));
        user.setActivated(true);
        user.setCreated_by("bsagar8");
        user.setCreated_date(Instant.now());
        User usr=userRepository.save(user);
        return new ResponseEntity<>(usr, HttpStatus.OK);
    };

}
