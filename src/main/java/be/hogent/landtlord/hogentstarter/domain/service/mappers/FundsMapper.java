package be.hogent.landtlord.hogentstarter.domain.service.mappers;

import be.hogent.landtlord.hogentstarter.domain.bussines.Comment;
import be.hogent.landtlord.hogentstarter.domain.bussines.Funds;
import be.hogent.landtlord.hogentstarter.domain.bussines.Project;
import be.hogent.landtlord.hogentstarter.domain.bussines.User;
import be.hogent.landtlord.hogentstarter.domain.service.dto.FundsDTO;
import be.hogent.landtlord.hogentstarter.domain.service.dto.ProjectDTO;
import be.hogent.landtlord.hogentstarter.domain.service.dto.UserDTO;

import javax.inject.Inject;

import static java.util.Objects.isNull;

public class FundsMapper implements Mapper<Funds, FundsDTO> {
    private Mapper<Project, ProjectDTO> projectMapper;
    private Mapper<User, UserDTO> userMapper;

    public FundsMapper() {
        this.projectMapper = new ProjectMapper();
        this.userMapper = new UserMapper();
    }

    @Override
    public Funds toObject(FundsDTO fundsDTO) {
        if (isNull(fundsDTO)){
            return null;
        }
        Funds funds = new Funds();

        funds.setId(fundsDTO.getId());
        ProjectDTO projectDTO = fundsDTO.getProjectDTO();
        Project project = projectMapper.toObject(projectDTO);
        funds.setProject(project);
        UserDTO userDTO = fundsDTO.getUserDTO();
        User user = userMapper.toObject(userDTO);
        funds.setUser(user);

        return funds;
    }

    @Override
    public FundsDTO toDTO(Funds funds) {
        if (isNull(funds)){
            return null;
        }
        FundsDTO fundsDTO = new FundsDTO();

        fundsDTO.setId(funds.getId());
        Project project = funds.getProject();
        ProjectDTO projectDTO = projectMapper.toDTO(project);
        fundsDTO.setProjectDTO(projectDTO);
        User user = funds.getUser();
        UserDTO userDTO = userMapper.toDTO(user);
        fundsDTO.setUserDTO(userDTO);

        return fundsDTO;
    }
}
