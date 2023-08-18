package com.project.Gatwork.Backend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private int id;

    // 로그인할 회원 아이디
    private String memberName;
    private String memberPwd;

    private String nickName;

    private String studentId;

    private String introduce;

    private String profileImg;

    private String contact;

    private String kakao;

    private int score;
    private int scoreCnt;

    public void updateScore(int score) {
        this.score += score;
    }
    public void updateScoreCnt() {
        this.scoreCnt++;
    }

    public void setInterests(List<String> interests) {
        for (String interest : interests) {
            this.interests.add(new Interests(interest));
        }
    }

    public void setRoles(List<String> roles) {
        for (String role : roles) {
            this.roles.add(new Roles(role));
        }
    }

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    List<Interests> interests = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    List<Roles> roles = new ArrayList<>();
}
