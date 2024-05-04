package com.example.baseballteammanagement.Enums;

import lombok.Getter;

@Getter
public enum AttendEnums {
    NO_WITHOUT_PERMIT("00"),
    NO_WITH_PERMIT("01"),
    YES("2"),
    LATE_WITHOUT_PERMIT("10"),
    LATE_WITH_PERMIT("11");

    private String code;

    private AttendEnums(String code) {
        this.code = code;
    }
}
