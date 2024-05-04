package com.example.baseballteammanagement.Enums.EnumConverter;

import com.example.baseballteammanagement.Enums.AttendEnums;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class AttendConverter implements AttributeConverter<AttendEnums, String> {
    @Override
    public String convertToDatabaseColumn(AttendEnums attendEnums) {
        if (attendEnums == null) {
            return null;
        }
        return attendEnums.getCode();
    }

    @Override
    public AttendEnums convertToEntityAttribute(String attendCode) {
        if (attendCode == null){
            return null;
        }
        return Stream.of(AttendEnums.values())
                .filter(c -> c.getCode().equals(attendCode))
                .findFirst().orElseThrow(IllegalAccessError::new);
    }
}
