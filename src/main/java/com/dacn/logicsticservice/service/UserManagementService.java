package com.dacn.logicsticservice.service;

import com.dacn.logicsticservice.dto.user.UserDTO;
import com.dacn.logicsticservice.dto.user.UserRegister;
import com.dacn.logicsticservice.dto.response.BaseResponseDTO;
import com.dacn.logicsticservice.model.Users;

public interface UserManagementService {

    BaseResponseDTO registerUser(UserRegister userRegister);

    BaseResponseDTO<UserDTO> login(UserRegister userRegister);


}
