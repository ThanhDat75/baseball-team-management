package com.example.baseballteammanagement.DTO;

import com.example.baseballteammanagement.Entity.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberAttendDTO extends Member {
    private int memberID;
    private String memberName;
    private int numberOfPracticeNotAttend;

    public MemberAttendDTO(Member member, int numberOfPracticeNotAttend) {
        this.setMemberID(member.getMemberID());
        this.setMemberName(member.getMemberName());
        this.setPhoneNumber(member.getPhoneNumber());
        this.setDateOfBirth(member.getDateOfBirth());
        this.setJerseyNumber(member.getJerseyNumber());
        this.setNickName(member.getNickName());
        this.setHandedness(member.getHandedness());
        this.setJerseySize(member.getJerseySize());
        this.setMemberStatus(member.getMemberStatus());
        this.setMemberPositionSet(member.getMemberPositionSet());

        this.setNumberOfPracticeNotAttend(numberOfPracticeNotAttend);
    }
}
