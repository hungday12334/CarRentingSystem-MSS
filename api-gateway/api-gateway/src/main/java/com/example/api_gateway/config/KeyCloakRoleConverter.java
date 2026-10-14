package com.example.api_gateway.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class KeyCloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {
    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        Map<String, Object> realmAccess = jwt.getClaimAsMap("resource_access");
        if(realmAccess==null){
            return List.of();
        }
        Map<String, Object> fuCarRenting = (Map<String, Object>) realmAccess.get("fu_car_renting");
        if(fuCarRenting==null){
            return List.of();
        }
        Object roles = fuCarRenting.get("roles");
        if(!(roles instanceof Collection<?> listRoles) ){
            return List.of();
        }

        return listRoles.stream()
                .filter(role -> role instanceof String)
                .map(String.class :: cast)
                .map(role -> new SimpleGrantedAuthority("ROLE_"+role))
                .map(grantedAuthority -> ((GrantedAuthority) grantedAuthority))
                .toList();
    }
}
