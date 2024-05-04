package com.example.baseballteammanagement.Entity;

import com.example.baseballteammanagement.Enums.AttendEnums;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "practiceattendence")
@Getter
@Setter
public class PracticeAttendence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int attendenceID;

    @Column(name = "memberid")
    private int memberID;

    @ManyToOne
    @JoinColumn(name = "memberid", insertable = false, updatable = false)
    @JsonBackReference(value = "member-practiceAttendence")
    private Member member;

    @Column(name = "practiceid")
    private int practiceID;

    @ManyToOne
    @JoinColumn(name = "practiceid", insertable = false, updatable = false)
    @JsonBackReference(value = "practice-practiceAttendence")
    private Practice practice;

    @Column(name = "attendcode")
    private AttendEnums attendCode;

//    @Column(name = "isattend")
//    private boolean isAttend;
//
//    @Column(name = "islate")
//    private boolean isLate;
}
