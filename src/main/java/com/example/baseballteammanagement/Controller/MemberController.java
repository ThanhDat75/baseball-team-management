package com.example.baseballteammanagement.Controller;

import com.example.baseballteammanagement.DTO.MemberDTOv2;
import com.example.baseballteammanagement.DTO.ObjectCollection;
import com.example.baseballteammanagement.Entity.Member;
import com.example.baseballteammanagement.Service.IMemberService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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
    public String updateMember(@RequestBody MemberDTOv2 memberDTOv2, @RequestParam int memberID) {
        try {
            iMemberService.updateMember(memberID, memberDTOv2);
            return "Update successfully!";
        } catch (EntityNotFoundException e) {
            return "Update failed! Id is not exist!";
        } catch (DataIntegrityViolationException e) {
            return "Update failed! Jersey number is already exist!";
        }
    }

    @GetMapping(value = "/getAllMember")
    public List<Member> getAllMember() {
        return iMemberService.getAllMember();
    }

    @DeleteMapping(value = "/deleteMember")
    public String deleteMember(@RequestParam int memberID) {
        try {
            iMemberService.deleteMember(memberID);
            return "Deleted";
        } catch (EntityNotFoundException e) {
            return "Member ID doesn't exist!";
        }
    }

    @PutMapping(value = "/setPositionOfMember", produces = MediaType.APPLICATION_JSON_VALUE)
    public String setPositionOfMember(@RequestParam int memberID,@RequestBody ObjectCollection objectCollection) {
        return iMemberService.setPositionOfMember(memberID, objectCollection.getPositionIDSet());
    }

    @GetMapping(value = "/findAllMemberByPosition")
    public Set<Member> findAllMemberByPosition(@RequestBody ObjectCollection objectCollection) {
        return iMemberService.findAllMemberByPosition(objectCollection.getPositionIDSet());
    }

    @GetMapping(value = "/findAllByName")
    public Set<Member> findAllMemberByName(@RequestParam String name) {
        return iMemberService.findAllMemberByName(name);
    }

    @GetMapping(value = "/findAllByNickName")
    public Set<Member> findAllMemberByNickName(@RequestParam String nickName) {
        return iMemberService.findAllMemberByNickName(nickName);
    }

    @GetMapping(value = "/findAllByMemberStatus")
    public Set<Member> findAllMemberByMemberStatus(@RequestParam String status) {
        return iMemberService.findAllMemberByStatus(status);
    }
}
