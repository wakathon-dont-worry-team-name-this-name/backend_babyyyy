package com.project.Gatwork.Backend.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@Getter
public class Interests {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "interest_id")
    int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    Member member;

    public Interests(String interest) {
        this.interest = interest;
    }

    String interest;
}
