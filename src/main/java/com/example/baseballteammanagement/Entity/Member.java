package com.example.baseballteammanagement.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "member")
@Setter
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberID;


    @Column(name = "membername",nullable = false)
    private String memberName;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "dateofbirth")
    private LocalDate dateOfBirth;

    @Column(name = "jerseynumber", unique = true)
    private String jerseyNumber;

    @Column(name = "nickname")
    private String nickName;

    @Column(name = "handedness")
    private String handedness;

    @Column(name = "jerseysize")
    private String jerseySize;

    @Column(name = "memberstatus", nullable = false)
    private String memberStatus = "ACTIVITY";

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    @JsonManagedReference(value = "member-memberPosition")
    private Set<MemberPosition> memberPositionSet;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    @JsonManagedReference(value = "member-practiceAttendence")
    private Set<PracticeAttendence> practiceAttendenceSet;
}
