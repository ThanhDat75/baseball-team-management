package com.example.baseballteammanagement.Controller;

import com.example.baseballteammanagement.Service.IAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/attendance")
public class AttendanceController {
    @Autowired
    private IAttendanceService iAttendanceService;

    @PutMapping(value = "/practiceAttend", produces = MediaType.APPLICATION_JSON_VALUE)
    public String practiceAttend(@RequestBody ObjectCollection objectCollection) {
        return iAttendanceService.practiceAttend(objectCollection.getAttendDTOSet());
    }
}
