package com.example.baseballteammanagement.Service;

import com.example.baseballteammanagement.DTO.Mapper.MemberMapper;
import com.example.baseballteammanagement.DTO.MemberDTO;
import com.example.baseballteammanagement.Entity.Member;
import com.example.baseballteammanagement.Entity.MemberPosition;
import com.example.baseballteammanagement.Entity.Position;
import com.example.baseballteammanagement.Enums.PositionEnums;
import com.example.baseballteammanagement.Repository.MemberPositionRepo;
import com.example.baseballteammanagement.Repository.MemberRepo;
import com.example.baseballteammanagement.Repository.PositionRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class MemberService implements IMemberService{
    @Autowired
    private ModelMapper mapper;
    private MemberMapper memberMapper;
    @Autowired
    private PositionRepo positionRepo;
    @Autowired
    private MemberRepo memberRepo;
    @Autowired
    private MemberPositionRepo memberPositionRepo;

    @Override
    public Member newMember(MemberDTO memberDTO) {
        // Member member = memberMapper.memberDtoToMember(memberDTO);
        Member member = mapper.map(memberDTO, Member.class);
        memberRepo.save(member);
        // Set<MemberPosition> memberPositionSet = new HashSet<>();
        for (PositionEnums positionEnums: memberDTO.getMemberPositionEnumsSet()) {
//            Position position = new Position();
//            position.setPositionName(positionEnums);
//            positionRepo.save(position);
            Optional<Position> position = positionRepo.findPositionByPositionName(String.valueOf(positionEnums));
            if (position.isEmpty()) {
                return null;
            }
            MemberPosition memberPosition = new MemberPosition(member.getMemberID(), position.get().getPositionID());
            // memberPositionSet.add(memberPosition);
            memberPositionRepo.save(memberPosition);
            member.getMemberPositionSet().add(memberPosition);
            position.get().getMemberPositionSet().add(memberPosition);
            positionRepo.save(position.get());
        }
        // member.setMemberPositionSet(memberPositionSet);
        memberRepo.save(member);
        return member;
    }
}
