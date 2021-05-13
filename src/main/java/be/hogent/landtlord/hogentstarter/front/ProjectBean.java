package be.hogent.landtlord.hogentstarter.front;

import be.hogent.landtlord.hogentstarter.common.Role;
import be.hogent.landtlord.hogentstarter.domain.service.*;
import be.hogent.landtlord.hogentstarter.domain.service.dto.CommentDTO;
import be.hogent.landtlord.hogentstarter.domain.service.dto.FundsDTO;
import be.hogent.landtlord.hogentstarter.domain.service.dto.ProjectDTO;
import be.hogent.landtlord.hogentstarter.domain.service.dto.UserDTO;
import lombok.Data;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    private UserDTO selectedUserDTO;

    private String comment;

    public ProjectBean() {
        projects = projectService().getAllRunningProjects();
    }

    public String setMyProjects() {
        UserDTO userDTO = getUserDTO();
        projects = projectService().getAllProjectsOwnedBy(userDTO);
        return "page";
    }

    public String setAllRunningProjects() {
        projects = projectService().getAllRunningProjects();
        return "page";
    }

    public String setAllProjects() {
        projects = projectService().getAllProjects();
        return "page";
    }

    public String setMyBackedProjects() {
        UserDTO userDTO = getUserDTO();
        projects = fundsService().getAllProjectsBackedBy(userDTO);
        return "page";
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

    public String deleteThisProject(){
        project = projectService().deleteProject(project);
        return "projectView";
    }

    public String closeThisProject(){
        project = projectService().closeProject(project);
        return "projectView";
    }

    public String approveUser(){
        userService().approveUser(selectedUserDTO);
        return "userview";
    }

    public String saveChangesInUser(){
        selectedUserDTO = userService().changeUser(selectedUserDTO);
        return "userDetailView";
    }

    public String goToUserView(){
        return "userDetailView";
    }

    public String saveComment() {
        UserDTO user = getUserDTO();
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setUserDTO(user);
        commentDTO.setComment(comment);
        commentDTO.setProjectDTO(project);
        commentDTO.setCommentTime(LocalDate.now());
        commentService().addComment(commentDTO);
        comment = null;
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

    public boolean isAdmin(){
        return Role.ADMIN.equals(getUserDTO().getRole());
    }

    public boolean isOwner(){
        return project.getOwner().equals(getUserDTO());
    }

    public boolean needsExtraFunctionality(){
        return isAdmin()||isOwner();
    }

    public String getStartDateFormatted(){
        return project.getStartDate().format(DateTimeFormatter.ofPattern("EEE dd MMMM yyyy"));
    }
    public String getEndDateFormatted(){
        return project.getEndDate().format(DateTimeFormatter.ofPattern("EEE dd MMMM yyyy"));
    }

    public List<CommentDTO> getComments(){
        return commentService().getCommentsFor(project);
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

    private CommentService commentService() {
        return ServiceFactory.getInstance().getCommentService();
    }
}

