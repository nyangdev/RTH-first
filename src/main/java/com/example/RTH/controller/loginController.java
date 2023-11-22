package com.example.RTH.controller;

import com.example.RTH.dto.ResponseDTO;
import com.example.RTH.entity.Member;
import com.example.RTH.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class loginController {

    @GetMapping("/login/login")
    public String loginPage() {
        return "login/login";
    }

//    @PostMapping("/login/loginMember")
//    public String loginMember(Authentication authentication, HttpSession session) {
//        if (authentication != null && authentication.isAuthenticated()) {
//            // 인증이 완료된 경우
//            // 사용자 정보를 세션에 저장
//            session.setAttribute("userDetails", authentication.getPrincipal());
//
//            // 로그인 성공 후 리다이렉트할 페이지로 이동
//            return "redirect:/main"; // 로그인 성공 시 리다이렉트할 페이지
//        } else {
//            // 로그인 실패 시 리다이렉트할 페이지로 이동
//            return "redirect:/login/login?error"; // 로그인 실패 시 리다이렉트할 페이지
//        }
//    }
}
