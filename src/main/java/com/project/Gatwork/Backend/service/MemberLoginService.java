package com.project.Gatwork.Backend.service;

import com.project.Gatwork.Backend.domain.Member;
import com.project.Gatwork.Backend.repository.MemberRepository;
import com.project.Gatwork.Backend.request.MemberDto;
import com.project.Gatwork.Backend.request.MemberLoginDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
@RequiredArgsConstructor
public class MemberLoginService {

    private final MemberRepository memberRepository;

    @Transactional
    public void signIn(MemberLoginDto memberLoginDto) {
        if (memberRepository.findByMemberName(memberLoginDto.getMemberId()).isEmpty())
            throw new RuntimeException("로그인 에러");
    }

    @Transactional
    public void signUp(MemberDto memberDto) {
        // member 생성
        Member member = Member.builder()
                .memberName(memberDto.getMemberName())
                .memberPwd(memberDto.getMemberPwd())
                .contact(memberDto.getContact())
                .profileImg(memberDto.getProfileImg())
                .studentId(memberDto.getStudentId())
                .introduce(memberDto.getIntroduce())
                .nickName(memberDto.getNickName())
                .kakao(memberDto.getKakao())
                .roles(new ArrayList<>())
                .interests(new ArrayList<>())
                .build();

        member.setRoles(memberDto.getRoles());
        member.setInterests(memberDto.getInterests());

        memberRepository.save(member);
    }
}
