package com.example.baseballteammanagement.Controller;

import com.example.baseballteammanagement.DTO.AttendDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ObjectCollection {
    private Set<Integer> positionIDSet;
    private Set<AttendDTO> attendDTOSet;
}
