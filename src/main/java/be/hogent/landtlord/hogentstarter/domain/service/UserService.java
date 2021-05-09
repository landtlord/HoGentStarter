package be.hogent.landtlord.hogentstarter.domain.service;

import be.hogent.landtlord.hogentstarter.domain.service.dto.ProjectDTO;
import be.hogent.landtlord.hogentstarter.domain.service.dto.UserDTO;

import java.util.Collections;
import java.util.List;

public class UserService {
    public List<UserDTO> getAllUsers(){
        return Collections.emptyList();
    }

    public List<ProjectDTO> getAllProjectsOwnedBy(Long userId){
        return Collections.emptyList();
    }

    public List<ProjectDTO> getAllProjectsBackedBy(Long userId){
        return Collections.emptyList();
    }

    public UserDTO createUser(UserDTO userDTO) {
        return null;
    }

    public UserDTO changeUser(UserDTO userDTO) {
        return null;
    }
}
