package com.project.Gatwork.Backend.repository;

import com.project.Gatwork.Backend.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer>{

    Optional<Member> findByMemberName(String memberName);
    Optional<Member> findByStudentId(String studentId);
}
