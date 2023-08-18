package com.project.Gatwork.Backend.service;

import com.project.Gatwork.Backend.domain.Interests;
import com.project.Gatwork.Backend.domain.Member;
import com.project.Gatwork.Backend.reponse.CardDetailDto;
import com.project.Gatwork.Backend.reponse.GetMemberDto;
import com.project.Gatwork.Backend.repository.InterestsRepository;
import com.project.Gatwork.Backend.repository.MemberRepository;
import com.project.Gatwork.Backend.request.MemberDto;
import com.project.Gatwork.Backend.request.ScoreDto;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final InterestsRepository interestsRepository;

    // 회원 상세보기
    @Transactional
    public CardDetailDto memberDetailView(int studentId) {

        Member member = memberRepository.findById(studentId).orElseThrow(EntityNotFoundException::new);

        return CardDetailDto.builder()
                .name(member.getNickName())
                .kakao(member.getKakao())
                .contact(member.getContact())
                .profileImg(member.getProfileImg())
                .introduce(member.getIntroduce())
                .studentId(member.getStudentId())
                .build();
    }

    public List<GetMemberDto> getMembers(String category) {

        List<Interests> interests = interestsRepository.findAllByInterestEquals(category);

        List<GetMemberDto> memberDtos = new ArrayList<>();

        for (Interests interest : interests) {
            Member member = interest.getMember();

            memberDtos.add(GetMemberDto.builder()
                    .contact(member.getContact())
                    .profileImg(member.getProfileImg())
                    .nickName(member.getProfileImg())
                    .studentId(member.getStudentId())
                    .nickName(member.getNickName())
                    .introduce(member.getIntroduce())
                    .role(member.getRoles().get(0).getRole())
                    .build());
        }

        return memberDtos;
    }


    // 점수매기기 api service
    @Transactional
    public void score(ScoreDto scoreDto) {

        List<Integer> scores = scoreDto.getScores();
        int studentId = scoreDto.getStudentId();

        int sumScore = scores.stream()
                .collect(Collectors.summingInt(Integer::intValue));

        Member savedMember = memberRepository.findById(studentId).orElseThrow(EntityNotFoundException::new);

        savedMember.updateScore(sumScore);
        savedMember.updateScoreCnt();
    }

    @Transactional
    public GetMemberDto getRandomMember() {

        List<Member> members = memberRepository.findAll();

        int randomIdx = (int)(Math.random() * (members.size()));

        Member member = members.get(randomIdx);

        return GetMemberDto.builder()
                .role(member.getRoles().get(0).getRole())
                .contact(member.getContact())
                .introduce(member.getIntroduce())
                .nickName(member.getNickName())
                .profileImg(member.getProfileImg())
                .studentId(member.getStudentId())
                .viewCnt(0).build();
    }

}
