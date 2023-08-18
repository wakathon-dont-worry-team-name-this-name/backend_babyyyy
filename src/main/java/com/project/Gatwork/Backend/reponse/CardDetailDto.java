package com.project.Gatwork.Backend.reponse;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardDetailDto {

    private String profileImg;
    private String studentId;
    private List<String> roles;
    private String name;
    private String introduce;
    private String kakao;
    private String contact;
}
