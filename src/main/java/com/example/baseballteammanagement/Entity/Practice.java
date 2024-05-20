package com.example.baseballteammanagement.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Table(name = "practice")
@Getter
@Setter
public class Practice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "practiceid")
    private int practiceID;

    @Column(name = "practicedate")
    private LocalDateTime practiceDate;

    @Column(name = "endTime")
    private LocalDateTime endTime;

    @Column(name = "content")
    private String content;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "practice")
    @JsonManagedReference(value = "practice-practiceAttendence")
    private Set<PracticeAttendence> practiceAttendenceSet;
}
