package be.hogent.landtlord.hogentstarter.domain.service;

import be.hogent.landtlord.hogentstarter.domain.bussines.User;
import be.hogent.landtlord.hogentstarter.domain.bussines.repository.UserRepository;
import be.hogent.landtlord.hogentstarter.domain.service.dto.ProjectDTO;
import be.hogent.landtlord.hogentstarter.domain.service.dto.UserDTO;
import be.hogent.landtlord.hogentstarter.domain.service.mappers.Mapper;

import java.util.Collections;
import java.util.List;

public class UserService {
    private UserRepository userRepository;

    private Mapper<User, UserDTO> userMapper;

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
}
