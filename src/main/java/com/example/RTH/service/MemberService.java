package com.example.RTH.service;

import com.example.RTH.Enum.RoleType;
import com.example.RTH.entity.Member;
import com.example.RTH.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.function.Supplier;

@Slf4j
@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public Member getUser(String username) {
        //검색 결과가 없을때 빈 객체를 반환한다
        Member findUser = memberRepository.findByUsername(username).orElseGet(
                new Supplier<Member>() {
                    @Override
                    public Member get() {
                        return new Member();
                    }
                });
        return findUser;
    }

    @Transactional
    public void insertUser(Member member) {
//        비밀번호 암호화 설정
        member.setPassword(passwordEncoder.encode(member.getPassword()));

        member.setRole(RoleType.USER);
        memberRepository.save(member);
    }
}