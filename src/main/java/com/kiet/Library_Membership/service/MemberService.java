package com.kiet.Library_Membership.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiet.Library_Membership.model.Member;
import com.kiet.Library_Membership.repository.MemberRepository;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public void saveMember(Member member) {
        memberRepository.save(member);
    }

    public Member getMemberById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    public void updateMember(Long id, Member updatedMember) {
        Member existing = getMemberById(id);
        if (existing != null) {
            existing.setName(updatedMember.getName());
            existing.setJoinDate(updatedMember.getJoinDate());
            existing.setIssuedBooks(updatedMember.getIssuedBooks());
            existing.setActive(updatedMember.isActive());
            memberRepository.save(existing);
        }
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    public List<Member> getActiveMembers() {
        return memberRepository.findByActiveTrue();
    }
}
