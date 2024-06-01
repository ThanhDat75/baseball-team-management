package com.example.baseballteammanagement.Controller;

import com.example.baseballteammanagement.Entity.Practice;
import com.example.baseballteammanagement.Service.IPracticeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "api/v1/practice")
public class PracticeController {
    @Autowired
    private IPracticeService practiceService;

    @GetMapping(value = "/getAllPractice")
    public List<Practice> getAllPractice() {
        return practiceService.getAllPractice();
    }

    @PostMapping(value = "/newPracticeSession", produces = MediaType.APPLICATION_JSON_VALUE)
    public String newPracticeSession(@RequestBody Practice practice) {
        return practiceService.newPracticeSession(practice);
    }

    @PutMapping(value = "/updatePractice", produces = MediaType.APPLICATION_JSON_VALUE)
    public String updatePractice(@RequestParam int practiceSessionID, @RequestBody Practice practice) {
        return practiceService.updatePractice(practiceSessionID, practice);
    }

    @DeleteMapping(value = "/deletePractice")
    public String deletePracticeSession(@RequestParam int practiceSessionID) {
        return practiceService.deletePracticeSession(practiceSessionID);
    }

    @GetMapping(value = "/getPracticeSessionBetweenTwoDate")
    public Set<Practice> getPracticeSessionBetweenTwoDate(@RequestParam LocalDate date1, @RequestParam LocalDate date2) {
        return practiceService.getPracticeSessionBetweenTwoDate(date1, date2);
    }

    @GetMapping(value = "/getPracticeSessionByID")
    public ResponseEntity<?> getPracticeSessionByID (@RequestParam int practiceID) {
        try {
            return ResponseEntity.ok(practiceService.getPracticeByID(practiceID));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Practice not found!");
        }
    }
}
