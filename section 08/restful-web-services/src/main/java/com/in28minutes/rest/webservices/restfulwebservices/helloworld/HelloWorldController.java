package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * author : ms.Lee
 * date   : 2024-01-29
 */
// 1. REST API
@RestController
public class HelloWorldController {

  // 2. /helloworld

  // return "Hello World"

  // --> path로 해도 되네??
  // @RequestMapping(method = RequestMethod.GET, path = "/hello-world") --> 아래처럼
  @GetMapping (path = "/hello-world")
  public String helloWorld() {

    return "Hello World";
  }

  @GetMapping (path = "/hello-world-bean")
  public HelloWorldBean helloWorldBean() {

    return new HelloWorldBean( "Hello World" );
  }

  // Path Parameters
  // /users/{id}/todos/{id} =>/users/1/todos/101
  // /hello-world/path-variable/{name}
  @GetMapping (path = "/hello-world/path-variable/{name}")
  public HelloWorldBean helloWorldBeanVariable(@PathVariable String name) {

    return new HelloWorldBean(
        String.format( "Hello World, %s", name )
    );
  }
}
