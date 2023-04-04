package com.rean.security;

import com.rean.constant.Constant;
import com.rean.exception.CustomMessageException;
import com.rean.model.User;
import com.rean.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.customUserDetail(username);
    }

    private CustomUserDetail customUserDetail(String username) {
        Optional<User> user = userRepository.findFirstByUsernameAndStatus(username, Constant.ACT);
        if(user.isEmpty()){
            log.warn("Username {} unauthorized", username);
            throw new CustomMessageException("Unauthorized", String.valueOf(HttpStatus.UNAUTHORIZED.value()));
        }

        return new CustomUserDetail(
                user.get().getUsername(),
                user.get().getPassword(),
                user.get().getRoles()
                        .stream().map(role -> new SimpleGrantedAuthority(role.getName()))
                        .collect(Collectors.toList()));
    }

    public void saveUserAttemptAuthentication(String username) {
        Optional<User> user = userRepository.findFirstByUsernameAndStatus(username, Constant.ACT);
        if(user.isPresent()) {
            int attempt = user.get().getAttempt() + 1;
            user.get().setAttempt(attempt);
            user.get().setUpdated(LocalDateTime.now());
            if(user.get().getAttempt() > 3) {
                log.warn("User {} update status to blocked", username);
                user.get().setStatus(Constant.BLK);
            }
            userRepository.save(user.get());
        }
    }

    public void updateAttempt(String username) {
        Optional<User> user = userRepository.findFirstByUsernameAndStatus(username, Constant.ACT);
        if(user.isPresent()) {
            user.get().setAttempt(0);
            user.get().setUpdated(LocalDateTime.now());
            userRepository.save(user.get());
        }
    }

}
