package com.example.baseballteammanagement.Enums.EnumConverter;

import com.example.baseballteammanagement.Enums.PositionEnums;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class PositionConverter implements AttributeConverter<PositionEnums, String> {
    @Override
    public String convertToDatabaseColumn(PositionEnums positionEnums) {
        if (positionEnums == null){
            return null;
        }
        return positionEnums.getCode();
    }

    @Override
    public PositionEnums convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }
        return Stream.of(PositionEnums.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst().orElseThrow(IllegalAccessError::new);
    }
}
