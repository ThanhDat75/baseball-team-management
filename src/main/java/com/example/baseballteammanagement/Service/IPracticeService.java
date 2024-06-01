package com.example.baseballteammanagement.Service;

import com.example.baseballteammanagement.DTO.PracticeDTO;
import com.example.baseballteammanagement.Entity.Practice;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface IPracticeService {
    List<Practice> getAllPractice();
    String newPracticeSession(Practice practice);
    String updatePractice(int practiceSessionID, Practice practice);
    String deletePracticeSession(int practiceSessionID);
    Set<Practice> getPracticeSessionBetweenTwoDate(LocalDate date1, LocalDate date2);
    PracticeDTO getPracticeByID(int practiceID);
}
