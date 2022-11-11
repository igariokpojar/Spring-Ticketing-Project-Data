package com.cydeo.converter;

import com.cydeo.dto.RoleDTO;
import com.cydeo.service.RoleService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class RoleDtoConverter implements Converter<String, RoleDTO> {

// why do we need converter? When we choose Role in IU is coming as a String, but we need to pass as an Object so that's why we need Converter
    RoleService roleService;

    // @Lazy -> do not rush to inject this Bean RoleTDO converter bc Bean is not ready yet
    // is going to be ready on the Form is fill up and Role is selected, and RoleDTOConverter is going to be executed or when Push the SAVE Button on Form
    public RoleDtoConverter(@Lazy RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public RoleDTO convert(String source) {

        if (source == null || source.equals("")) {  //  Select  -> ""
            return null;
        }

        return roleService.findById(Long.parseLong(source));

    }

}
