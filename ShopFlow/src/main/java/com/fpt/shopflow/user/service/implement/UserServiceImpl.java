package com.fpt.shopflow.user.service.implement;

import com.fpt.shopflow.common.constant.CommonConstants;
import com.fpt.shopflow.common.exception.ExistedEmailException;
import com.fpt.shopflow.common.exception.ExistedUsernameException;
import com.fpt.shopflow.user.domain.User;
import com.fpt.shopflow.user.dto.CreateUserRequestDTO;
import com.fpt.shopflow.user.dto.UserResponseDTO;
import com.fpt.shopflow.user.enums.Gender;
import com.fpt.shopflow.user.enums.UserRole;
import com.fpt.shopflow.user.mapper.UserMapper;
import com.fpt.shopflow.user.service.UserService;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    public List<UserResponseDTO> getAllUsers() {
        return userMapper.getAllUser()
                         .stream()
                         .map(user -> UserResponseDTO.builder()
                                                     .username(user.getUsername())
                                                     .email(user.getEmail())
                                                     .fullName(getFullName(user.getFirstName(), user.getLastName()))
                                                     .phoneNumber(user.getPhoneNumber())
                                                     .dateOfBirth(user.getDateOfBirth())
                                                     .gender(user.getGender().name())
                                                     .avatarUrl(user.getAvatarUrl())
                                                     .role(user.getRole().name())
                                                     .status(user.getStatus().name())
                                                     .build())
                         .toList();
    }

    public void insertUser(final CreateUserRequestDTO requestDTO) {
        LocalDate dateOfBirth = LocalDate.parse(requestDTO.getDateOfBirth(), CommonConstants.DATE_INPUT_FORMATTER);

        boolean isExistedUsername = userMapper.isExistedUsername(requestDTO.getUsername());
        if (isExistedUsername) {
            throw new ExistedUsernameException("username existed");
        }

        boolean isExistedEmail = userMapper.isExistedEmail(requestDTO.getEmail());
        if (isExistedEmail) {
            throw new ExistedEmailException("email existed");
        }

        User newUser = User.builder()
                           .username(requestDTO.getUsername())
                           .email(requestDTO.getEmail())
                           .password(passwordEncoder.encode(requestDTO.getPassword()))
                           .firstName(requestDTO.getFirstName())
                           .lastName(requestDTO.getLastName())
                           .phoneNumber(requestDTO.getPhoneNumber())
                           .dateOfBirth(dateOfBirth)
                           .gender(Gender.valueOf(requestDTO.getGender()))
                           .avatarUrl(requestDTO.getAvatarUrl())
                           .role(UserRole.valueOf(requestDTO.getRole()))
                           .build();
        userMapper.insertUser(newUser);
    }

    private String getFullName(String firstName, String lastName) {
        if (StringUtils.hasText(firstName) && StringUtils.hasText(lastName)) {
            return firstName + CommonConstants.SPACE + lastName;
        }
        if (StringUtils.hasText(firstName)) {
            return firstName;
        }
        if (StringUtils.hasText(lastName)) {
            return lastName;
        }
        return CommonConstants.EMPTY;
    }
}
