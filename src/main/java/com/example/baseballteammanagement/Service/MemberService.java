package com.example.baseballteammanagement.Service;

import com.example.baseballteammanagement.DTO.MemberDTOv2;
import com.example.baseballteammanagement.Entity.Member;
import com.example.baseballteammanagement.Entity.MemberPosition;
import com.example.baseballteammanagement.Entity.Position;
import com.example.baseballteammanagement.Repository.MemberPositionRepo;
import com.example.baseballteammanagement.Repository.MemberRepo;
import com.example.baseballteammanagement.Repository.PositionRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class MemberService implements IMemberService{
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private PositionRepo positionRepo;
    @Autowired
    private MemberRepo memberRepo;
    @Autowired
    private MemberPositionRepo memberPositionRepo;

    @Override
    public Member newMember(MemberDTOv2 memberDTOv2) {
        Member member = mapper.map(memberDTOv2, Member.class);
        try {
            memberRepo.save(member);
        } catch (Exception e) {
            return null;
        }
        return member;
    }

    @Override
    public Member updateMember(int memberID, MemberDTOv2 memberDTOv2) {
//        Optional<Member> member = memberRepo.findById(memberID);
//        if (member.isEmpty()) {
//            return null;
//        }
        Member member = memberRepo.findByMemberID(memberID);
        if (member == null) {
            return null;
        }
        member = mapper.map(memberDTOv2, Member.class);
        try {
            memberRepo.save(member);
        } catch (Exception e) {
            return null;
        }
        return member;
    }

    @Override
    public List<Member> getAllMember() {
        return memberRepo.findAll();
    }

    @Override
    public Member deleteMember(int memberID) {
        Optional<Member> member = memberRepo.findById(memberID);
        if (member.isEmpty()) {
            return null;
        }
        memberPositionRepo.deleteMemberPositionsByMemberID(memberID);
        memberRepo.delete(member.get());
        return member.get();
    }

    @Override
    public String setPositionOfMember(int memberID, Set<Integer> positionIDSet) {
        Optional<Member> member = memberRepo.findById(memberID);
        if (member.isEmpty()) {
            return "Member doesn't exist!";
        } else if (positionIDSet.isEmpty()) {
            return "At least one position!";
        }

        for (Integer positionID: positionIDSet) {
            MemberPosition memberPosition = new MemberPosition(memberID, positionID);
            memberPositionRepo.save(memberPosition);
            member.get().getMemberPositionSet().add(memberPosition);
        }
        memberRepo.save(member.get());
        return "Success!";
    }

    @Override
    public Set<Member> findAllMemberByPosition(Set<Integer> positionIDSet) {
        Set<Member> memberByPositionID = new HashSet<>();
        for (Integer positionID: positionIDSet) {
            memberByPositionID.addAll(memberRepo.findAllByPositionID(positionID));
        }
        return memberByPositionID;
    }

    @Override
    public Set<Member> findAllMemberByName(String name) {
        return memberRepo.findAllByMemberNameContaining(name);
    }

    @Override
    public Set<Member> findAllMemberByNickName(String nickName) {
        return memberRepo.findAllByNickNameContaining(nickName);
    }

    @Override
    public Set<Member> findAllMemberByStatus(String status) {
        return memberRepo.findAllByMemberStatus(status);
    }

    //    @Override
//    public Member newMember(MemberDTO memberDTO) {
//        // Member member = memberMapper.memberDtoToMember(memberDTO);
//        Member member = mapper.map(memberDTO, Member.class);
//        memberRepo.save(member);
//        // Set<MemberPosition> memberPositionSet = new HashSet<>();
//        for (PositionEnums positionEnums: memberDTO.getMemberPositionEnumsSet()) {
////            Position position = new Position();
////            position.setPositionName(positionEnums);
////            positionRepo.save(position);
//            Optional<Position> position = positionRepo.findPositionByPositionName(String.valueOf(positionEnums));
//            if (position.isEmpty()) {
//                return null;
//            }
//            MemberPosition memberPosition = new MemberPosition(member.getMemberID(), position.get().getPositionID());
//            // memberPositionSet.add(memberPosition);
//            memberPositionRepo.save(memberPosition);
//            member.getMemberPositionSet().add(memberPosition);
//            position.get().getMemberPositionSet().add(memberPosition);
//            positionRepo.save(position.get());
//        }
//        // member.setMemberPositionSet(memberPositionSet);
//        memberRepo.save(member);
//        return member;
//    }
}
