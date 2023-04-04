package com.rean.filter;

import com.rean.constant.Constant;
import com.rean.exception.CustomMessageException;
import com.rean.model.Role;
import com.rean.model.User;
import com.rean.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.info("Authentication income {}", authentication);
        final String username = authentication.getName();
        final String password = authentication.getCredentials().toString();
        Optional<User> user;
        try {
            user = userRepository.findFirstByUsernameAndStatus(username, Constant.ACT);
        }catch (Exception ex) {
            log.error("{}", ex.getLocalizedMessage());
            throw new CustomMessageException("User not found.", String.valueOf(HttpStatus.UNAUTHORIZED.value()));
        }
        if(user.isEmpty()){
            throw new CustomMessageException("User not found.", String.valueOf(HttpStatus.UNAUTHORIZED.value()));
        }
        final List<GrantedAuthority> grantedAuthorities = grantedAuthorities(user.get().getRoles().stream().toList());
        final Authentication authz = new UsernamePasswordAuthenticationToken(username, password, grantedAuthorities);

        log.info("Authentication out come {}", authz);
        return authz;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }

    private List<GrantedAuthority> grantedAuthorities(List<Role> roles) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        Set<String> permissions = new HashSet<>();

        if(!roles.isEmpty()){
            roles.forEach(role -> {
                permissions.add(role.getName());
            });
        }

        permissions.forEach(permission -> grantedAuthorities.add(new SimpleGrantedAuthority(permission)));
        return grantedAuthorities;
    }

}
