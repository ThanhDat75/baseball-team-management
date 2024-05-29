package com.example.baseballteammanagement.Repository;

import com.example.baseballteammanagement.Entity.PracticeAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PracticeAttendanceRepo extends JpaRepository<PracticeAttendance, Integer> {
    Optional<PracticeAttendance> findByMemberIDAndPracticeID(int memberID, int practiceID);

    @Query(value = "SELECT COUNT(PA.isAttend) " +
            "FROM PracticeAttendance AS PA " +
            "WHERE PA.isAttend = false AND PA.memberID = :memberID GROUP BY PA.memberID", nativeQuery = true)
    Integer countByAttendIsFalseAndMemberIDIs(@Param("memberID") Integer memberID);
}
