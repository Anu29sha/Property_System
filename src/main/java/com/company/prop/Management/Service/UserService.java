package com.company.prop.Management.Service;

import com.company.prop.Management.DTO.UserDTO;

public interface UserService {
    UserDTO register(UserDTO userDTO);
    UserDTO login(String email, String password);
}
