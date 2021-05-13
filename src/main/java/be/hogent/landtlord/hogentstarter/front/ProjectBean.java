package be.hogent.landtlord.hogentstarter.front;

import be.hogent.landtlord.hogentstarter.domain.service.FundsService;
import be.hogent.landtlord.hogentstarter.domain.service.ProjectService;
import be.hogent.landtlord.hogentstarter.domain.service.ServiceFactory;
import be.hogent.landtlord.hogentstarter.domain.service.UserService;
import be.hogent.landtlord.hogentstarter.domain.service.dto.FundsDTO;
import be.hogent.landtlord.hogentstarter.domain.service.dto.ProjectDTO;
import be.hogent.landtlord.hogentstarter.domain.service.dto.UserDTO;
import lombok.Data;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

@ManagedBean(name = "projectBean", eager = true)
@SessionScoped
@Data
public class ProjectBean {
    private List<ProjectDTO> projects;

    private List<UserDTO> users;

    private Double fund;

    private ProjectDTO project = new ProjectDTO();

    public ProjectBean() {
        projects = projectService().getAllProjects();
    }

    public String setMyProjects() {
        UserDTO userDTO = getUserDTO();
        projects = projectService().getAllProjectsOwnedBy(userDTO);
        return userDTO.getRole().toString().toLowerCase(Locale.ROOT);
    }

    public String setAllProjects() {
        UserDTO userDTO = getUserDTO();
        projects = projectService().getAllProjects();
        return userDTO.getRole().toString().toLowerCase(Locale.ROOT);
    }

    public String setMyBackedProjects() {
        UserDTO userDTO = getUserDTO();
        projects = fundsService().getAllProjectsBackedBy(userDTO);
        return userDTO.getRole().toString().toLowerCase(Locale.ROOT);
    }

    public String setUsers() {
        users = userService().getAllUsers();
        return "userView";
    }

    public String saveProject() {
        UserDTO userDTO = getUserDTO();
        project.setOwner(userDTO);
        project = projectService().createProject(project);
        return "projectView";
    }

    public String goToProjectView() {
        return "projectView";
    }

    public String newProject() {
        project = new ProjectDTO();
        return "projectNew";
    }

    public String backThisProject() {
        FundsDTO fundsDTO = new FundsDTO();
        fundsDTO.setUserDTO(getUserDTO());
        fundsDTO.setProjectDTO(project);
        fundsDTO.setAmount(fund);
        fundsService().addFunds(fundsDTO);
        fund = null;

        return "projectView";
    }

    public Double getFundsForProject() {
        List<FundsDTO> funds = fundsService().getFundsFor(project);

        return funds.stream()
                .mapToDouble(FundsDTO::getAmount)
                .sum();
    }

    public int getFundsInPercentage(){
        double result = Math.floor((getFundsForProject()/project.getNeededFunds())  * 100);
        return (int) result;
    }

    private UserDTO getUserDTO() {
        ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession currentSession = (HttpSession) ctx.getSession(true);
        return (UserDTO) currentSession.getAttribute("loggedInUser");
    }

    private ProjectService projectService() {
        return ServiceFactory.getInstance().getProjectService();
    }

    private FundsService fundsService() {
        return ServiceFactory.getInstance().getFundsService();
    }

    private UserService userService() {
        return ServiceFactory.getInstance().getUserService();
    }
}

