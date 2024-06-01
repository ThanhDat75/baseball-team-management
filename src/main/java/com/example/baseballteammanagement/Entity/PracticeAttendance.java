package com.example.baseballteammanagement.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "practiceattendance")
@Getter
@Setter
@NoArgsConstructor
public class PracticeAttendance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int attendanceID;

    @Column(name = "memberid")
    private int memberID;

//    @ManyToOne
//    @JoinColumn(name = "memberid", insertable = false, updatable = false)
//    @JsonBackReference(value = "member-practiceAttendance")
//    private Member member;

    @Column(name = "practiceid")
    private int practiceID;

    @ManyToOne
    @JoinColumn(name = "practiceid", insertable = false, updatable = false)
    @JsonBackReference(value = "practice-practiceAttendance")
    private Practice practice;
//
//    @Column(name = "attendcode")
//    private AttendEnums attendCode;

    @Column(name = "isattend")
    private boolean isAttend;

    public PracticeAttendance(int memberID, int practiceID, boolean isAttend) {
        this.memberID = memberID;
        this.practiceID = practiceID;
        this.isAttend = isAttend;
    }
}
