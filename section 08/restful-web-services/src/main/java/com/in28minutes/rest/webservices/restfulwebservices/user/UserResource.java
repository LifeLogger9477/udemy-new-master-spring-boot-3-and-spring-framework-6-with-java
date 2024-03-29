package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * author : ms.Lee
 * date   : 2024-01-29
 */
@RestController
public class UserResource {

  private UserDaoService service;

  public UserResource(UserDaoService service) {

    this.service = service;
  }

  @GetMapping (path = "/users")
  public List<User> retrieveAllUsers() {

    return service.findAll();
  }

  @GetMapping (path = "/users/{id}")
  public User retrieveUser(@PathVariable int id) {

    return service.findOne( id );
  }

  @PostMapping (path = "/users")
  public ResponseEntity<User> createUser(@RequestBody User user) {

    User savedUser = service.save( user );

    // location - /users/4
    // /users/4 => /users/{id}, user.getId() 이렇게 변경하면..
    URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path( "/{id}" )
        .buildAndExpand( savedUser.getId() )
        .toUri();

    return ResponseEntity.created( location ).build();
  }
}
