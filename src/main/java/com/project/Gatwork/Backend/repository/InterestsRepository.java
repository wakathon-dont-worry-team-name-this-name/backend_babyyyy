package com.project.Gatwork.Backend.repository;

import com.project.Gatwork.Backend.domain.Interests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterestsRepository extends JpaRepository<Interests, Interests> {

    List<Interests> findAllByInterestEquals(String interest);
}
