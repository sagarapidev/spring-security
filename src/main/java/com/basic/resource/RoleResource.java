package com.basic.resource;

import com.basic.domain.Role;
import com.basic.repository.RoleRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RoleResource {

    @Autowired
    RoleRepository roleRepository;
    private static final Logger logger = LogManager.getLogger(RoleResource.class);
    @PostMapping("/role/save")
    public ResponseEntity<Object> saveUser(@RequestBody Role role){
        logger.info("Request save Role:{}"+role);
        Role result=roleRepository.save(role);

        return new ResponseEntity<>(result, HttpStatus.OK);
    };

    @GetMapping("/role/all")
    public ResponseEntity<List<Role>> getAllRoles(@RequestBody Role role){
        logger.info("Post User Request:{}"+role);
        List<Role> result=roleRepository.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    };

}
