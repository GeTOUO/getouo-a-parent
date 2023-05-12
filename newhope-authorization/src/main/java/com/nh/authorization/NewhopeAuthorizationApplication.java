package com.nh.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication
public class NewhopeAuthorizationApplication {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/hello")
    public List<User> testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        // Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
        return userList;
    }

    public static void main(String[] args) {
        SpringApplication.run(NewhopeAuthorizationApplication.class, args);
    }

}
