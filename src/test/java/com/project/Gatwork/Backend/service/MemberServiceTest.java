package com.project.Gatwork.Backend.service;

import com.project.Gatwork.Backend.request.MemberDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberLoginService memberLoginService;

    @Test
    @DisplayName("회원가입 테스트")
    public void test1() {
        MemberDto memberDto = new MemberDto();

        memberDto.setIntroduce("wow");
        memberDto.setMajor("wow");
        memberDto.setRoles(List.of("wow", "nice"));
        memberDto.setInterests(List.of("nice", "good"));
        memberDto.setMemberName("hoow");
        memberDto.setMemberPwd("1234");
        memberDto.setMajor("컴공");
        memberDto.setNickName("wooow");
        memberDto.setKakao("1231131");
        memberDto.setProfileImg("good");
        memberDto.setContact("231313");

        memberLoginService.signUp(memberDto);
    }
}