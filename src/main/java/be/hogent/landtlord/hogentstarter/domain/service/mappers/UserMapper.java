package be.hogent.landtlord.hogentstarter.domain.service.mappers;

import be.hogent.landtlord.hogentstarter.domain.bussines.User;
import be.hogent.landtlord.hogentstarter.domain.service.dto.UserDTO;

import static java.util.Objects.isNull;

public class UserMapper implements Mapper<User, UserDTO> {
    @Override
    public User toObject(UserDTO userDTO) {
        if (isNull(userDTO)) {
            return null;
        }

        User user = new User();

        user.setId(userDTO.getId());
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());

        return user;
    }

    @Override
    public UserDTO toDTO(User user) {
        if (isNull(user)) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setUserName(user.getUserName());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole());

        return userDTO;
    }
}
