package com.example.baseballteammanagement.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
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
    private LocalDate practiceDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "practice")
    @JsonManagedReference(value = "practice-practiceAttendence")
    private Set<PracticeAttendence> practiceAttendenceSet;
}
