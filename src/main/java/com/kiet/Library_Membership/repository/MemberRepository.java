package com.kiet.Library_Membership.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiet.Library_Membership.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByActiveTrue();
}
