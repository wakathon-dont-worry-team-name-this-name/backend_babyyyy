package com.project.Gatwork.Backend.reponse;

import lombok.*;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetMemberDto {
    //아이디, 학번, 관심분야, 조회수, 프로필이미지, 자기소개, contact
    private String nickName;
    private String studentId;
    private String role;
    private int viewCnt;
    private String profileImg;
    private String introduce;
    private String contact;
}
