package com.dacn.logicsticservice.service.impl;

import com.dacn.logicsticservice.dto.UserDTO;
import com.dacn.logicsticservice.model.User;
import com.dacn.logicsticservice.model.UserRole;
import com.dacn.logicsticservice.repository.UserRepository;
import com.dacn.logicsticservice.repository.UserRoleRepository;
import com.dacn.logicsticservice.service.UserManagementService;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class UserManagementServiceImpl implements UserManagementService {

    private static Logger LOGGER = LoggerFactory.getLogger(UserManagementServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public List<UserDTO> getAllUser() {

        List<UserDTO> userDTOS = new ArrayList<>();
        try {
            List<UserRole> userRoles = userRoleRepository.findUserNameByRoleClient();
            LOGGER.info("getAllUser userRoles data : {}", new Gson().toJson(userRoles));
            if (userRoles.isEmpty()) {
                return userDTOS;
            }

            List<String> userNames = new ArrayList<>();
            userRoles.stream().forEach(userRole -> {
                if (!userRole.getUsername().isEmpty()) {
                    userNames.add(userRole.getUsername());
                }
            });

            List<User> users = userRepository.findAllByListUserName(userNames);
            LOGGER.info("getAllUser users data : {}", new Gson().toJson(users));
            if (users.isEmpty()) {
                return userDTOS;
            }

            for (User user : users) {
                UserDTO userDTO = new UserDTO();
                userDTO.doMappingUsers(user);
                userDTOS.add(userDTO);
            }

            LOGGER.info("getAllUser response data : {}", new Gson().toJson(userDTOS));
        } catch (Exception ex) {
            LOGGER.info("getAllUser exception: {}", ex);
        }
        return userDTOS;
    }
}
