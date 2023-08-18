package com.project.Gatwork.Backend.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

// 회원가입 Dto

@Getter
@Setter
public class MemberDto {

    // 가입할 회원의 아이디, 패스워드
    private String memberName;
    private String memberPwd;

    // 회원의 닉네임, 역할, 관심분야, 학번, 프로필, 학과
    private String nickName;
    private List<String> roles;
    private List<String> interests;
    private String studentId;
    private String profileImg;
    private String major;
    private String introduce;

    // 회원의 연락주소(노션, 깃 등 기타 웹사이트..)
    private String contact;
    private String kakao;
}
