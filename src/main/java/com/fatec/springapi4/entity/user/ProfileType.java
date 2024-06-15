package com.fatec.springapi4.entity.user;

public enum ProfileType {
    Oracle(false),
    PartnerAdmin(true);

    private final Boolean value;

    private ProfileType(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return value;
    }

    public static ProfileType fromValue(Boolean value) {
        for (ProfileType profile : ProfileType.values()) {
            if (profile.value == value) {
                return profile;
            }
        }
        throw new IllegalArgumentException("Valor inválido para ProfileType: " + value);
    }
}
