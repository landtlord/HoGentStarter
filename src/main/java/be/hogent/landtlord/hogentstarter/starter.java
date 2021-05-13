package be.hogent.landtlord.hogentstarter;

import be.hogent.landtlord.hogentstarter.domain.service.ProjectService;
import be.hogent.landtlord.hogentstarter.domain.service.UserService;
import be.hogent.landtlord.hogentstarter.domain.service.dto.ProjectDTO;
import be.hogent.landtlord.hogentstarter.domain.service.dto.UserDTO;

import java.time.LocalDate;

public class starter {
    public static void main(String[] args) {
        ProjectService projectService = new ProjectService();
        UserService userService= new UserService();

        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setTitle("titel");
        projectDTO.setDescription("testje");
        projectDTO.setStartDate(LocalDate.now());

        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("Andy");

        UserDTO user = userService.createUser(userDTO);

        projectDTO.setOwner(user);

        ProjectDTO project = projectService.createProject(projectDTO);

        System.out.println(project);
        System.out.println(projectService.getAllRunningProjects());
    }
}
