package com.project.Gatwork.Backend.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Roles {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    Member member;

    String role;

    public Roles(String role) {
        this.role = role;
    }
}
