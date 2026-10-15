package com.fpt.shopflow.authentication.service;

import com.fpt.shopflow.user.mapper.UserMapper;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = userMapper.getUserByEmail(username);
        if (Objects.isNull(userDetails)) {
            throw new UsernameNotFoundException("User not exists");
        }
        return userDetails;
    }
}
