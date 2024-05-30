package com.example.baseballteammanagement.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberAttendDTO {
    private int memberID;
    private String memberName;
    private int numberOfPracticeNotAttend;
}
