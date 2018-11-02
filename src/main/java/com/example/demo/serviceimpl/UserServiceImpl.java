package com.example.demo.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.example.utils.UsersUtils;
import com.example.demo.DTO.UserDTO;
import com.example.demo.dao.IUserDAO;
import com.example.demo.model.User;
import com.example.demo.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	IUserDAO userDAO;
	
	@Override
	public List<UserDTO> findAllUser() {
		// TODO Auto-generated method stub
		List<User> users= (List<User>) userDAO.findAll();
		List<UserDTO> userList=new ArrayList<>();
		users.forEach(user->{
			
			userList.add(UsersUtils.converToUserDTO(user));
		});
		return userList;
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.save(user);
	}

	@Override
	public void deleteUser(long userId) {
		// TODO Auto-generated method stub
		userDAO.deleteById(userId);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.save(user);
	}

	@Override
	public Optional<User> findUserById(long userId) {
		// TODO Auto-generated method stub
		return userDAO.findById(userId);
	}

}
