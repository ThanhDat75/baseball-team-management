package com.example.baseballteammanagement.Service;

import com.example.baseballteammanagement.DTO.AttendDTO;

import java.util.Set;

public interface IAttendanceService {
    String practiceAttend(Set<AttendDTO> attendDTOSet);
}
