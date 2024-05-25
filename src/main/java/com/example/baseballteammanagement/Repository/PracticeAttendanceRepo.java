package com.example.baseballteammanagement.Repository;

import com.example.baseballteammanagement.Entity.PracticeAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PracticeAttendanceRepo extends JpaRepository<PracticeAttendance, Integer> {
    Optional<PracticeAttendance> findByMemberIDAndPracticeID(int memberID, int practiceID);
}
