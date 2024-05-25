package com.example.baseballteammanagement.Controller;

import com.example.baseballteammanagement.Entity.Practice;
import com.example.baseballteammanagement.Service.IPracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Set;

@RestController
@RequestMapping(value = "api/v1/practice")
public class PracticeController {
    @Autowired
    private IPracticeService iPracticeService;

    @PostMapping(value = "newPracticeSession", produces = MediaType.APPLICATION_JSON_VALUE)
    public String newPracticeSession(@RequestBody Practice practice) {
        return iPracticeService.newPracticeSession(practice);
    }

    @PutMapping(value = "updatePractice", produces = MediaType.APPLICATION_JSON_VALUE)
    public String updatePractice(@RequestParam int practiceSessionID, @RequestBody Practice practice) {
        return iPracticeService.updatePractice(practiceSessionID, practice);
    }

    @DeleteMapping(value = "deletePractice")
    public String deletePracticeSession(@RequestParam int practiceSessionID) {
        return iPracticeService.deletePracticeSession(practiceSessionID);
    }

    @GetMapping(value = "getPracticeSessionBetweenTwoDate")
    public Set<Practice> getPracticeSessionBetweenTwoDate(@RequestParam LocalDate date1, @RequestParam LocalDate date2) {
        return iPracticeService.getPracticeSessionBetweenTwoDate(date1, date2);
    }
}
