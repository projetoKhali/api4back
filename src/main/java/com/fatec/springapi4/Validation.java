package com.fatec.springapi4;

import com.fatec.springapi4.entity.Partner;
import com.fatec.springapi4.entity.user.User;

import java.util.Optional;

public class Validation {
    public static Optional<String> validatePartner(Partner partner) {
        if (partner == null) {
            return Optional.of("Partner must be present.");
        }
        if (partner.getName() == null || partner.getName().length() < 3) {
            return Optional.of("Partner name must have at least 3 characters.");
        }
        if (partner.getCompanyId() == null || partner.getCompanyId().length() < 3) {
            return Optional.of("Partner company ID must have at least 3 characters.");
        }
        if (partner.getAdminName() == null || partner.getAdminName().length() < 3) {
            return Optional.of("Partner admin name must have at least 3 characters.");
        }
        if (partner.getAdminEmail() == null || partner.getAdminEmail().length() < 3) {
            return Optional.of("Partner admin email must have at least 3 characters.");
        }
        if (partner.getSlogan() == null || partner.getSlogan().length() < 3) {
            return Optional.of("Partner slogan must have at least 3 characters.");
        }
        if (partner.getCountry() == null || partner.getCountry().length() < 3) {
            return Optional.of("Partner country must have at least 3 characters.");
        }
        if (partner.getCity() == null || partner.getCity().length() < 2) {
            return Optional.of("Partner city must have at least 2 characters.");
        }
        if (partner.getAddress() == null || partner.getAddress().length() < 3) {
            return Optional.of("Partner address must have at least 3 characters.");
        }
        if (partner.getCompliance() == null) {
            return Optional.of("Partner compliance must be present.");
        }
        if (partner.getCredit() == null) {
            return Optional.of("Partner credit must be present.");
        }
        if (partner.getStatus() == null) {
            return Optional.of("Partner status must be present.");
        }
        if (partner.getMemberType() == null) {
            return Optional.of("Partner member type must be present.");
        }
        return Optional.empty();
    }

    public static Optional<String> validateUser(User user) {
        if (user == null) {
            return Optional.of("User must be present.");
        }
        if (user.getName() == null || user.getName().length() < 3) {
            return Optional.of("User name must have at least 3 characters.");
        }
        if (user.getLogin() == null || user.getLogin().length() < 3) {
            return Optional.of("User email must have at least 3 characters.");
        }
        return Optional.empty();
    }
}
