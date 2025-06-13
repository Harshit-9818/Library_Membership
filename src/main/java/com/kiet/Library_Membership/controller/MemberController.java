package com.kiet.Library_Membership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kiet.Library_Membership.model.Member;
import com.kiet.Library_Membership.service.MemberService;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    // Show all members
    @GetMapping("/members")
    public String viewMembers(Model model) {
        model.addAttribute("members", memberService.getAllMembers());
        return "members";
    }

    // Show form to add new member
    @GetMapping("/addmember")
    public String showAddMemberForm(Model model) {
        model.addAttribute("member", new Member());
        return "addmember";
    }

    // Handle POST request to save member
    @PostMapping("/members")
    public String saveMember(@ModelAttribute Member member) {
        memberService.saveMember(member);
        return "redirect:/members";
    }

    // Show form to edit an existing member
    @GetMapping("/editmember/{id}")
    public String showEditMemberForm(@PathVariable("id") Long id, Model model) {
        Member member = memberService.getMemberById(id);
        model.addAttribute("member", member);
        return "editmember";
    }

    // Handle POST request to update member
    @PostMapping("/update-member/{id}")
    public String updateMember(@PathVariable("id") Long id, @ModelAttribute Member updatedMember) {
        memberService.updateMember(id, updatedMember);
        return "redirect:/members";
    }

    // Delete a member
    @GetMapping("/deletemember/{id}")
    public String deleteMember(@PathVariable("id") Long id) {
        memberService.deleteMember(id);
        return "redirect:/members";
    }

    // View active members only
    @GetMapping("/activemembers")
    public String viewActiveMembers(Model model) {
        model.addAttribute("members", memberService.getActiveMembers());
        return "activemembers";
    }
}
