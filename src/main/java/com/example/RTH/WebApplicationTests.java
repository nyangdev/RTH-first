package com.example.RTH;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// 비밀번호 암호화 기능 테스트
public class WebApplicationTests {
    @Test
    public void passwordEncode() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "abc123@@";
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println("암호화 전 비밀번호 " +rawPassword);
        System.out.println("암호화 후 비밀번호 " + encodedPassword);
        System.out.println("비밀번호 둘 서로 비교 " + encoder.matches(rawPassword, encodedPassword));
    }
}
