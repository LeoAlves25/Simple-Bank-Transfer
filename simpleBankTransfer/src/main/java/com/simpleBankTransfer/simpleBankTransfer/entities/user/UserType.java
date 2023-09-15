package com.simpleBankTransfer.simpleBankTransfer.entities.user;

import com.simpleBankTransfer.simpleBankTransfer.entities.user.groups.CnpjGroup;
import com.simpleBankTransfer.simpleBankTransfer.entities.user.groups.CpfGroup;

public enum UserType {
    
    COMMON(CpfGroup.class),
    MERCHANT(CnpjGroup.class);

    private final Class<?> validationGroup;

    private UserType(Class<?> validationGroup) {
        this.validationGroup = validationGroup;
    }

    
    public Class<?> getValidationGroup() {
        return validationGroup;
    }
}
