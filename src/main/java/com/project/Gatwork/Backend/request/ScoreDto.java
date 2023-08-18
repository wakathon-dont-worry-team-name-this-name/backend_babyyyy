package com.project.Gatwork.Backend.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ScoreDto {

    int studentId;
    List<Integer> scores;
}
