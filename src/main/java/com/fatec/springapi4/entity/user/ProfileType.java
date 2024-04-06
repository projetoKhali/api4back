package com.fatec.springapi4.entity.user;

public enum ProfileType {
    Oracle(0),
    PartnerAdmin(1);

    private final int value;

    private ProfileType(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }

    public static ProfileType fromValue(int value) {
        for (ProfileType profile : ProfileType.values()) {
            if (profile.value == value) {
                return profile;
            }
        }
        throw new IllegalArgumentException("Valor inválido para ProfileType: " + value);
    }
}
