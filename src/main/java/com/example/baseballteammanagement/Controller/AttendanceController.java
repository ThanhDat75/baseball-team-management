package com.example.baseballteammanagement.Controller;

import com.example.baseballteammanagement.DTO.MemberAttendDTO;
import com.example.baseballteammanagement.DTO.ObjectCollection;
import com.example.baseballteammanagement.Service.IAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "api/v1/attendance")
public class AttendanceController {
    @Autowired
    private IAttendanceService iAttendanceService;

    @PutMapping(value = "/practiceAttend", produces = MediaType.APPLICATION_JSON_VALUE)
    public String practiceAttend(@RequestBody ObjectCollection objectCollection) {
        return iAttendanceService.practiceAttend(objectCollection.getAttendDTOSet());
    }

    @PutMapping(value = "/allMemberMissedMoreThanNumberOfSessions", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<MemberAttendDTO> allMemberMissedMoreThanNumberOfSessions(@RequestParam int numberOfSessions) {
        return iAttendanceService.allMemberMissedMoreThanNumberOfSessions(numberOfSessions);
    }
}
