package com.example.baseballteammanagement.Enums;

import lombok.Getter;

@Getter
public enum PositionEnums {
    MANAGER("MANA"), PITCHER("P"), CATCHER("C"), FIRST_BASEMEN("1B"),
    SECOND_BASEMEN("2B"), THIRD_BASEMEN("3B"),
    SHORTSTOP("SS"), LEFT_FIELDER("LF"),
    CENTER_FIELDER("CF"), RIGHT_FILEDER("RF"),
    DESIGNATED_HITTER("DH"), OUT_FIELDER("OF");

    private final String code;

    private PositionEnums(String code) {
        this.code = code;
    }
}
