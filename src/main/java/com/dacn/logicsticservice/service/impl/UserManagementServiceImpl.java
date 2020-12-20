package com.dacn.logicsticservice.service.impl;

import com.dacn.logicsticservice.dto.user.UserDTO;
import com.dacn.logicsticservice.dto.user.UserRegister;
import com.dacn.logicsticservice.dto.response.BaseResponseDTO;
import com.dacn.logicsticservice.model.Users;
import com.dacn.logicsticservice.repository.*;
import com.dacn.logicsticservice.service.UserManagementService;
import com.dacn.logicsticservice.utils.GsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagementServiceImpl implements UserManagementService {
    private static Logger LOGGER = LoggerFactory.getLogger(UserManagementServiceImpl.class);

    private final UserRepository userRepository;

    @Autowired
    public UserManagementServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public BaseResponseDTO registerUser(UserRegister userRegister) {
        BaseResponseDTO<Users> response = new BaseResponseDTO<>();
        String userName = userRegister.getUserName();
        try {
            Users userExists = userRepository.getUserByUserName(userName);
            if (userExists != null) {
                return response.fail("Sorry, that username already exists!");
            }

            Users user = new Users();
            user.doMappingEntity(userRegister);
            user.setUserType(1);
            user = userRepository.save(user);

            LOGGER.info("User register successfully... : {}", GsonUtils.toJsonString(user));

            response.success("User register successfully...");
        } catch (Exception ex) {

            LOGGER.info("registerUser exception: {}", ex);
            response.fail(ex.getMessage());
        }
        return response;
    }

    @Override
    public BaseResponseDTO<UserDTO> login(UserRegister userRegister) {
        BaseResponseDTO<UserDTO> response = new BaseResponseDTO<>();
        String userName = userRegister.getUserName();
        String password = userRegister.getPassword();
        try {
            Users user = userRepository.getUserVerifyLogin(userName, password);
            if (user != null) {
                UserDTO userDTO = new UserDTO();
                userDTO.doMappingEntity(user);
                LOGGER.info("User login successfully... : {}", GsonUtils.toJsonString(userDTO));
                return response.success(userDTO);
            }
        } catch (Exception ex) {
            LOGGER.info("login exception: {}", ex);
            response.fail(ex.getMessage());
        }
        return response;
    }
}
