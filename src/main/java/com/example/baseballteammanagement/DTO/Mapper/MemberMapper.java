package com.example.baseballteammanagement.DTO.Mapper;

import com.example.baseballteammanagement.DTO.MemberDTO;
import com.example.baseballteammanagement.Entity.Member;
import com.example.baseballteammanagement.Entity.MemberPosition;
import com.example.baseballteammanagement.Entity.Position;

import java.util.HashSet;
import java.util.Set;

public class MemberMapper {
    public MemberDTO memberToMemberDTO(Member member) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberName(member.getMemberName());
        memberDTO.setDateOfBirth(member.getDateOfBirth());
        memberDTO.setPhoneNumber(member.getPhoneNumber());
        memberDTO.setHandedness(member.getHandedness());
        memberDTO.setNickName(member.getNickName());
        memberDTO.setJerseyNumber(member.getJerseyNumber());

        return memberDTO;
    }

    public Member memberDtoToMember(MemberDTO memberDTO) {
        Member member = new Member();
        member.setMemberName(memberDTO.getMemberName());
        member.setDateOfBirth(memberDTO.getDateOfBirth());
        member.setPhoneNumber(memberDTO.getPhoneNumber());
        member.setHandedness(memberDTO.getHandedness());
        member.setNickName(memberDTO.getNickName());
        member.setJerseyNumber(memberDTO.getJerseyNumber());

        return member;
    }
}
