package com.example.baseballteammanagement.Service;

import com.example.baseballteammanagement.DTO.MemberDTOv2;
import com.example.baseballteammanagement.Entity.Member;

import java.util.List;
import java.util.Set;

public interface IMemberService {
    Member newMember(MemberDTOv2 memberDTOv2);
    Member updateMember(int memberID, MemberDTOv2 memberDTOv2);
    List<Member> getAllMember();
    Member deleteMember(int memberID);
    String setPositionOfMember(int memberID, Set<Integer> positionIDSet);
    Set<Member> findAllMemberByPosition(Set<Integer> positionIDSet);
    Set<Member> findAllMemberByName(String name);
    Set<Member> findAllMemberByNickName(String nickName);
    Set<Member> findAllMemberByStatus(String status);
}
