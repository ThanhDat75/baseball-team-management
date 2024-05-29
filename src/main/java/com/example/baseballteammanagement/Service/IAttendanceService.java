package com.example.baseballteammanagement.Service;

import com.example.baseballteammanagement.DTO.AttendDTO;
import com.example.baseballteammanagement.DTO.MemberAttendDTO;

import java.util.Set;

public interface IAttendanceService {
    String practiceAttend(Set<AttendDTO> attendDTOSet);
    Set<MemberAttendDTO> allMemberMissedMoreThanNumberOfSessions(int numberOfSessions);
}
