package com.demo.example.utils;

import com.example.demo.DTO.RolesDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.model.Roles;
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
					role.setRole(user.getRoles().get(i).getRoleName());
					userDTO.getRoles().add(role);
				}
			}
		}

		return userDTO;
	}
	
	public static User converToUserEntity(UserDTO user) {
		final User userEntity = new User();
		if (user != null) {
			// userDTO=new UserDTO();
			userEntity.setId(user.getId());
			userEntity.setCreated(user.getCreated());
			userEntity.setFirstName(user.getFirstName());
			userEntity.setLastName(user.getLastName());
			userEntity.setEmail(user.getEmail());
			userEntity.setEnabled(user.getEnabled());
			userEntity.setUsername(user.getUsername());
			if (user.getRoles() != null) {
				for (int i = 0; i < user.getRoles().size(); i++) {
					Roles role= new Roles();
					role.setId(user.getRoles().get(i).getId());
					role.setRoleName(user.getRoles().get(i).getRole());
					userEntity.getRoles().add(role);
				}
			}
		}

		return userEntity;
	}

}
