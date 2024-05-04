package com.fatec.springapi4.converter;

import com.fatec.springapi4.entity.user.ProfileType;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class ProfileTypeConverter implements AttributeConverter<ProfileType, Boolean> {

    @Override
    public Boolean convertToDatabaseColumn(ProfileType attribute) {
        return attribute.getValue();
    }

    @Override
    public ProfileType convertToEntityAttribute(Boolean dbData) {
        return ProfileType.fromValue(dbData);

    }
}