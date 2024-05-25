package com.example.baseballteammanagement.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
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

    @Column(name = "totalactive")
    private Integer totalActive;

    @Column(name = "totalattend")
    private Integer totalAttend;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "practice")
    @JsonManagedReference(value = "practice-practiceAttendance")
    private Set<PracticeAttendance> practiceAttendanceSet;
}
