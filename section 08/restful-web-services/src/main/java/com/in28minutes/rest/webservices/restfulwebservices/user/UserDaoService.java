package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * author : ms.Lee
 * date   : 2024-01-29
 */
@Component
public class UserDaoService {

  // JPA / Hibernate -> Database

  // 1. UserDaoService > Static List
  private static List<User> users = new ArrayList<>();

  static {

    users.add(
        new User(
            1,
            "Adam",
            LocalDate.now().minusYears( 30 )
        )
    );

    users.add(
        new User(
            2,
            "Eve",
            LocalDate.now().minusYears( 25 )
        )
    );

    users.add(
        new User(
            3,
            "Jim",
            LocalDate.now().minusYears( 20 )
        )
    );
  }

  public List<User> findAll() {

    return users;
  }
}