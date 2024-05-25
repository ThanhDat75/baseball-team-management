package com.example.baseballteammanagement.Service;

import com.example.baseballteammanagement.Entity.Member;
import com.example.baseballteammanagement.Entity.Practice;

import java.time.LocalDate;
import java.util.Set;

public interface IPracticeService {
    String newPracticeSession(Practice practice);
    String updatePractice(int practiceSessionID, Practice practice);
    String deletePracticeSession(int practiceSessionID);
    Set<Practice> getPracticeSessionBetweenTwoDate(LocalDate date1, LocalDate date2);

}
