package com.example.baseballteammanagement.Controller;

import com.example.baseballteammanagement.DTO.MemberDTO;
import com.example.baseballteammanagement.Entity.Member;
import com.example.baseballteammanagement.Service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/member")
public class MemberController {
    @Autowired
    private IMemberService iMemberService;

    @PostMapping(value = "/newMember", produces = MediaType.APPLICATION_JSON_VALUE)
    public Member newMember(MemberDTO memberDTO) {
        return iMemberService.newMember(memberDTO);
    }
}
