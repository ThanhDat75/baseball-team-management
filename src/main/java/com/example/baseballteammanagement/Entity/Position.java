package com.example.baseballteammanagement.Entity;

import com.example.baseballteammanagement.Enums.PositionEnums;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "Position")
@Getter
@Setter
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int positionID;


    @Column(name = "positionname")
    private PositionEnums positionName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "position")
    @JsonManagedReference(value = "position-memberPosition")
    private Set<MemberPosition> memberPositionSet;
}
