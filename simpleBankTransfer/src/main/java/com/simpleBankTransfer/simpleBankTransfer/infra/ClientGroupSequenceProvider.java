package com.simpleBankTransfer.simpleBankTransfer.infra;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import com.simpleBankTransfer.simpleBankTransfer.DTO.UserDTO;
import com.simpleBankTransfer.simpleBankTransfer.entities.user.UserType;

public class ClientGroupSequenceProvider implements DefaultGroupSequenceProvider<UserDTO>{

    @Override
    public List<Class<?>> getValidationGroups(UserDTO user) {
        List<Class<?>> groups = new ArrayList<>();

        groups.add(UserDTO.class);

        if(user != null) {

            EnumSet.allOf(UserType.class).forEach(userType -> {
                if(userType.toString().equals(user.userType().toString())){
                    groups.add(userType.getValidationGroup());
                }
            });

        }

        return groups;
    }
    
}
