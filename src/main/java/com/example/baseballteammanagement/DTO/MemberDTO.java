package com.example.baseballteammanagement.DTO;

import com.example.baseballteammanagement.Entity.Member;
import com.example.baseballteammanagement.Enums.PositionEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private String memberName;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String jerseyNumber;
    private String nickName;
    private String handedness;
    private Set<PositionEnums> positionEnumsSet;

    public void memberToDTO(@NotNull Member member) {
        this.memberName = member.getMemberName();
        this.dateOfBirth = member.getDateOfBirth();
        this.phoneNumber = member.getPhoneNumber();
        this.jerseyNumber = member.getJerseyNumber();
        this.nickName = member.getNickName();
        this.handedness = member.getHandedness();
    }
}
