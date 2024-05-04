package com.example.baseballteammanagement.Service;

import com.example.baseballteammanagement.DTO.MemberDTOv2;
import com.example.baseballteammanagement.Entity.Member;

import java.util.List;

public interface IMemberService {
    Member newMember(MemberDTOv2 memberDTOv2);
    Member updateMember(int memberID, MemberDTOv2 memberDTOv2);
    List<Member> getAllMember();
    Member deleteMember(int memberID);
}
