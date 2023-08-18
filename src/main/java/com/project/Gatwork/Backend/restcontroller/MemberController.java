package com.project.Gatwork.Backend.restcontroller;

import com.project.Gatwork.Backend.reponse.CardDetailDto;
import com.project.Gatwork.Backend.reponse.GetMemberDto;
import com.project.Gatwork.Backend.request.MemberDto;
import com.project.Gatwork.Backend.request.MemberLoginDto;
import com.project.Gatwork.Backend.request.ScoreDto;
import com.project.Gatwork.Backend.service.MemberLoginService;
import com.project.Gatwork.Backend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class MemberController {

    private final MemberLoginService memberLoginService;
    private final MemberService memberService;

    // 회원 로그인
    @PostMapping("/api/signin")
    public void signin(@RequestBody MemberLoginDto memberLoginDto) {
        memberLoginService.signIn(memberLoginDto);
    }

    // 회원가입
    @PostMapping("/api/signUp")
    private void signUp(@RequestBody MemberDto memberDto) {
        memberLoginService.signUp(memberDto);
    }

    // 홈 화면 - 카테고리  (해커톤, 프로젝트, 공모전) - 아직 정렬 안해준 상태임..
    @GetMapping(path = "/api/home")
    public List<GetMemberDto> getMemberList(@RequestParam("category")String category) {
        return memberService.getMembers(category);
    }


    // 선택한 명함의 상세정보 받기
    @GetMapping(path = "/api/member/{memberId}/detail")
    public CardDetailDto getDetail(@PathVariable int memberId) {
        return memberService.memberDetailView(memberId);
    }

    // 선택의 시간 사용자 아무나 출력하기
    @GetMapping("/api/member/choose")
    public GetMemberDto getRandomMember() {
        return memberService.getRandomMember();
    }

    // 선택한 사람의 점수 매기기
    @PostMapping("/api/member/{memberId}/score")
    public ResponseEntity scoreApi(@RequestBody ScoreDto scoreDto) {

        memberService.score(scoreDto);

        return new ResponseEntity(HttpStatus.OK);
    }

}
