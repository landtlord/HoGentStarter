package be.hogent.landtlord.hogentstarter.domain.service;

import be.hogent.landtlord.hogentstarter.domain.bussines.Funds;
import be.hogent.landtlord.hogentstarter.domain.bussines.Project;
import be.hogent.landtlord.hogentstarter.domain.bussines.User;
import be.hogent.landtlord.hogentstarter.domain.bussines.repository.FundsRepository;
import be.hogent.landtlord.hogentstarter.domain.service.dto.FundsDTO;
import be.hogent.landtlord.hogentstarter.domain.service.dto.ProjectDTO;
import be.hogent.landtlord.hogentstarter.domain.service.dto.UserDTO;
import be.hogent.landtlord.hogentstarter.domain.service.mappers.FundsMapper;
import be.hogent.landtlord.hogentstarter.domain.service.mappers.Mapper;
import be.hogent.landtlord.hogentstarter.domain.service.mappers.ProjectMapper;
import be.hogent.landtlord.hogentstarter.domain.service.mappers.UserMapper;
import be.hogent.landtlord.hogentstarter.persistence.repository.FundsRepositoryImpl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FundsService {
    private FundsRepository fundsRepository;

    private Mapper<Funds, FundsDTO> fundsMapper;

    private Mapper<Project, ProjectDTO> projectMapper;

    private Mapper<User, UserDTO> userMapper;

    public FundsService() {
        this.fundsRepository = new FundsRepositoryImpl();
        fundsMapper = new FundsMapper();
        projectMapper = new ProjectMapper();
        userMapper = new UserMapper();
    }

    public FundsDTO addFunds(FundsDTO fundsDTO) {
        Funds funds = fundsMapper.toObject(fundsDTO);
        funds = fundsRepository.save(funds);
        return fundsMapper.toDTO(funds);
    }

    public List<FundsDTO> getFundsFor(ProjectDTO projectDTO) {
        Project project = projectMapper.toObject(projectDTO);
        List<Funds> fundsList = fundsRepository.findFundsFor(project);
        return fundsMapper.toDTO(fundsList);
    }

    public List<ProjectDTO> getAllProjectsBackedBy(UserDTO userDTO){
        User user = userMapper.toObject(userDTO);
        List <Funds> fundsList = fundsRepository.findFundsFor(user);
        List<FundsDTO> fundsDTOList = fundsMapper.toDTO(fundsList);
        return fundsDTOList.stream()
                .map(FundsDTO::getProjectDTO)
                .collect(Collectors.toList());
    }
}
