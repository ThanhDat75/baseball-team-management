package com.example.baseballteammanagement.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTOv2 {
    private String memberName;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String jerseyNumber;
    private String nickName;
    private String handedness;
}