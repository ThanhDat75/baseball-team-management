package com.example.baseballteammanagement.Service;

import com.example.baseballteammanagement.DTO.MemberDTO;
import com.example.baseballteammanagement.Entity.Member;

public interface IMemberService {
    Member newMember(MemberDTO memberDTO);
}
