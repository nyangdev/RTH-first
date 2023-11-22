package com.example.RTH.controller;

import com.example.RTH.dto.MemberDTO;
import com.example.RTH.dto.ResponseDTO;
import com.example.RTH.entity.Member;
import com.example.RTH.repository.MemberRepository;
import com.example.RTH.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/join")
    public String joinPage() {
        return "join/join";
    }

    @PostMapping("/join/Member")
    public String Member(MemberDTO memberDTO) {
        //1. DTO를 엔티티로 변환
        Member member = memberDTO.toEntity();
        //2. 리파지터리로 엔티티를 DB에 저장
//        Member saved = memberRepository.save(member);
        return "redirect:/login/login";
    }

    @Autowired
    private MemberService memberService;

    @PostMapping("/join/create")
    public @ResponseBody ResponseDTO<?> insertUser(@RequestBody Member member) {
        Member findUser = memberService.getUser(member.getUsername());

        if(findUser.getUsername() == null) {
            memberService.insertUser(member);
            return new ResponseDTO<>(HttpStatus.OK.value(),
                    member.getUsername() + "가입 성공");
        } else {
            return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(),
                    member.getUsername() + "은 이미 존재하는 아이디");
        }
    }
}
