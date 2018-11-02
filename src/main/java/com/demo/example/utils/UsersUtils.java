package com.demo.example.utils;

import com.example.demo.DTO.RolesDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.model.User;

public class UsersUtils {

	public static UserDTO converToUserDTO(User user) {
		final UserDTO userDTO = new UserDTO();
		if (user != null) {
			// userDTO=new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setCreated(user.getCreated());
			userDTO.setFirstName(user.getFirstName());
			userDTO.setLastName(user.getLastName());
			userDTO.setEmail(user.getEmail());
			userDTO.setEnabled(user.getEnabled());
			userDTO.setUsername(user.getUsername());
			if (user.getRoles() != null) {
				for (int i = 0; i < user.getRoles().size(); i++) {
					RolesDTO role= new RolesDTO();
					role.setId(user.getRoles().get(i).getId());
					role.setRole(user.getRoles().get(i).getRole());
					userDTO.getRoles().add(role);
				}
			}
		}

		return userDTO;
	}

}
