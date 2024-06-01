package com.example.baseballteammanagement.Controller;

import com.example.baseballteammanagement.DTO.MemberDTOv2;
import com.example.baseballteammanagement.DTO.ObjectCollection;
import com.example.baseballteammanagement.Entity.Member;
import com.example.baseballteammanagement.Service.IMemberService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "api/v1/member")
public class MemberController {
    @Autowired
    private IMemberService memberService;

//    @PostMapping(value = "/newMember", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Member newMember(MemberDTO memberDTO) {
//        return iMemberService.newMember(memberDTO);
//    }

    @PostMapping(value = "/newMember", produces = MediaType.APPLICATION_JSON_VALUE)
    public Member newMember(@RequestBody MemberDTOv2 memberDTOv2) {
        return memberService.newMember(memberDTOv2);
    }

    @PutMapping(value = "/updateMember", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateMember(@RequestBody MemberDTOv2 memberDTOv2, @RequestParam int memberID) {
        try {
            return ResponseEntity.ok(memberService.updateMember(memberID, memberDTOv2));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Update failed! Id is not exist!");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Update failed! Jersey number is already exist!");
        }
    }

    @GetMapping(value = "/getAllMember")
    public List<Member> getAllMember() {
        return memberService.getAllMember();
    }

    @DeleteMapping(value = "/deleteMember")
    public ResponseEntity<?> deleteMember(@RequestParam int memberID) {
        try {
            Member member = memberService.deleteMember(memberID);
            return ResponseEntity.ok(member.getMemberName() + " has been deleted!");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Member ID doesn't exist!");
        }
    }

    @PutMapping(value = "/setPositionOfMember", produces = MediaType.APPLICATION_JSON_VALUE)
    public String setPositionOfMember(@RequestParam int memberID,@RequestBody ObjectCollection objectCollection) {
        return memberService.setPositionOfMember(memberID, objectCollection.getPositionIDSet());
    }

    @GetMapping(value = "/findAllMemberByPosition")
    public Set<Member> findAllMemberByPosition(@RequestBody ObjectCollection objectCollection) {
        return memberService.findAllMemberByPosition(objectCollection.getPositionIDSet());
    }

    @GetMapping(value = "/findAllByName")
    public Set<Member> findAllMemberByName(@RequestParam String name) {
        return memberService.findAllMemberByName(name);
    }

    @GetMapping(value = "/findAllByNickName")
    public Set<Member> findAllMemberByNickName(@RequestParam String nickName) {
        return memberService.findAllMemberByNickName(nickName);
    }

    @GetMapping(value = "/findAllByMemberStatus")
    public Set<Member> findAllMemberByMemberStatus(@RequestParam String status) {
        return memberService.findAllMemberByStatus(status);
    }
}
