package com.xq.build;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class BuildApplicationTests {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {
        String encode = passwordEncoder.encode("jiale");
        String hashpw = BCrypt.hashpw("tom", BCrypt.gensalt());
        System.out.println("encode："+encode);
        System.out.println("hashpw："+hashpw);

//        encode：$2a$10$Vpeo4t49.wwkGo6Wzd4rL.40REm7wGAxLcqQeZ5HS0j0uCQr6vowK
//        hashpw：$2a$10$C3f7kCtf1o7Xje.B/l9ngOM2LPb3LSrYl/o/xKvHy6XcmThEKcbR.
    }

}
