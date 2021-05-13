package be.hogent.landtlord.hogentstarter.domain.service;

import be.hogent.landtlord.hogentstarter.common.Role;
import be.hogent.landtlord.hogentstarter.domain.bussines.User;
import be.hogent.landtlord.hogentstarter.domain.bussines.repository.UserRepository;
import be.hogent.landtlord.hogentstarter.domain.service.dto.UserDTO;
import be.hogent.landtlord.hogentstarter.domain.service.mappers.Mapper;
import be.hogent.landtlord.hogentstarter.domain.service.mappers.UserMapper;
import be.hogent.landtlord.hogentstarter.persistence.repository.UserRepositoryImpl;

import java.util.List;
import java.util.Objects;

import static java.util.Objects.nonNull;

public class UserService {
    private UserRepository userRepository;

    private Mapper<User, UserDTO> userMapper;

    public UserService() {
        userRepository = new UserRepositoryImpl();
        userMapper = new UserMapper();
    }

    public List<UserDTO> getAllUsers(){
        List<User> users = userRepository.findAll();
        return userMapper.toDTO(users);
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.toObject(userDTO);
        user = userRepository.save(user);
        return userMapper.toDTO(user);
    }

    public UserDTO changeUser(UserDTO userDTO) {
        User user = userMapper.toObject(userDTO);
        user = userRepository.update(user);
        return userMapper.toDTO(user);
    }

    public UserDTO doLogin(String userName, String password) {
        User user = userRepository.findUserBy(userName);
        if (nonNull(user) && password.equals(user.getPassword()) && user.isApproved()) {
            return userMapper.toDTO(user);
        }
        return null;
    }

    public UserDTO approveUser(UserDTO userDTO) {
        userDTO.setApproved(true);
        return changeUser(userDTO);
    }
}
