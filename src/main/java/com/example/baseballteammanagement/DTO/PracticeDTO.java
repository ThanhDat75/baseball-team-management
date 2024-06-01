package com.example.baseballteammanagement.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PracticeDTO {
    private LocalDateTime practiceDate;
    private LocalDateTime endTime;
    private String content;
    private Integer totalActive;
    private Integer totalAttend;
    private Set<AttendDTO> attendDTOSet;
}
