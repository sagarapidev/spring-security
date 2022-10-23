package com.basic.resource;

import com.basic.exception.UserNotFoundException;
import com.basic.service.UserDetails;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.basic.domain.User;
import com.basic.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/v1")
public class UserResource {

    @Autowired
    MessageSource msg;
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDetails UserDetails;
    private static final Logger logger = LogManager.getLogger(UserResource.class);
    @PostMapping("/user/save")
    public ResponseEntity<Object> saveUser(@RequestBody User user){
        logger.info("Post User Request:{}"+user);
        User Usr=userRepository.findByEmail(user.getEmail());
        logger.info(Usr);
            //check is user exist
        if(Usr!=null){
            return new ResponseEntity<>(msg.getMessage("exist.id", null, "Default Message", LocaleContextHolder.getLocale()), HttpStatus.OK);
        }
        User usr=userRepository.save(user);
        return new ResponseEntity<>(usr, HttpStatus.OK);
    };

    @PutMapping("/user/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User UpdateUser = userRepository.save(user);
        return new ResponseEntity<User>(UpdateUser,HttpStatus.OK);

    }

    @DeleteMapping(value="/user/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String id){
        userRepository.deleteById(id);
        return new ResponseEntity<String>(HttpStatus.OK);

    }

    @GetMapping(value="/user/search/{id}")
    public ResponseEntity<EntityModel<User>> findUser(@PathVariable("id") String  id) {
        Optional<User> user=userRepository.findById(id);

        if(user.isEmpty()) {
            throw new UserNotFoundException(msg.getMessage(
                    "no.id", null,
                    "Default Message", LocaleContextHolder.getLocale())+"{\"id\":\""+id+"\"}");
        }

        EntityModel<User> model=EntityModel.of(user.get());
        WebMvcLinkBuilder linkAll=linkTo(methodOn(this.getClass()).getUsers());
        model.add(linkAll.withRel("all-users"));
        return new ResponseEntity<EntityModel<User>>(model,HttpStatus.OK);

    }

    @GetMapping(value="/user/all")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users=userRepository.findAll();
        return new ResponseEntity<List<User>>(users,HttpStatus.OK);

    }
}
