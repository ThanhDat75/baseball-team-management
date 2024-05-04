package com.example.baseballteammanagement.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "memberposition")
@Getter
@Setter
@NoArgsConstructor
public class MemberPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberpositionid")
    private int memberPositionID;

    @Column(name = "memberid")
    private int memberID;

    @ManyToOne
    @JoinColumn(name = "memberid", insertable = false, updatable = false)
    @JsonBackReference(value = "member-memberPosition")
    private Member member;

    @Column(name = "positionid")
    private int positionID;

    @ManyToOne
    @JoinColumn(name = "positionid", insertable = false, updatable = false)
    @JsonBackReference(value = "position-memberPosition")
    private Position position;

    public MemberPosition(int memberID, int positionID) {
        this.memberID = memberID;
        this.positionID = positionID;
    }
}
