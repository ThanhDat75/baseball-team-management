package com.example.baseballteammanagement.Controller;

import com.example.baseballteammanagement.DTO.MemberDTOv2;
import com.example.baseballteammanagement.Entity.Member;
import com.example.baseballteammanagement.Service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/member")
public class MemberController {
    @Autowired
    private IMemberService iMemberService;

//    @PostMapping(value = "/newMember", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Member newMember(MemberDTO memberDTO) {
//        return iMemberService.newMember(memberDTO);
//    }

    @PostMapping(value = "/newMember", produces = MediaType.APPLICATION_JSON_VALUE)
    public Member newMember(@RequestBody MemberDTOv2 memberDTOv2) {
        return iMemberService.newMember(memberDTOv2);
    }

    @PutMapping(value = "/updateMember", produces = MediaType.APPLICATION_JSON_VALUE)
    public Member updateMember(@RequestBody MemberDTOv2 memberDTOv2, @RequestParam int memberID) {
        return iMemberService.updateMember(memberID, memberDTOv2);
    }

    @GetMapping(value = "/getAllMember")
    public List<Member> getAllMember() {
        return iMemberService.getAllMember();
    }

    @DeleteMapping(value = "/deleteMember")
    public Member deleteMember(@RequestParam int memberID) {
        return iMemberService.deleteMember(memberID);
    }
}
