package com.example.baseballteammanagement.Repository;

import com.example.baseballteammanagement.Entity.Practice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

@Repository
public interface PracticeRepo extends JpaRepository<Practice, Integer> {
    Set<Practice> getPracticeByPracticeDateBetween(LocalDateTime datetime1, LocalDateTime date2);
}
