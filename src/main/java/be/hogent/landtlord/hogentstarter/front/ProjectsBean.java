package be.hogent.landtlord.hogentstarter.front;

import be.hogent.landtlord.hogentstarter.domain.service.FundsService;
import be.hogent.landtlord.hogentstarter.domain.service.ProjectService;
import be.hogent.landtlord.hogentstarter.domain.service.ServiceFactory;
import be.hogent.landtlord.hogentstarter.domain.service.UserService;
import be.hogent.landtlord.hogentstarter.domain.service.dto.ProjectDTO;
import be.hogent.landtlord.hogentstarter.domain.service.dto.UserDTO;
import lombok.Data;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

@ManagedBean(name = "projectsBean", eager = true)
@ApplicationScoped
@Data
public class ProjectsBean {
    private List<ProjectDTO> projects;

    public ProjectsBean() {
        projects = projectService().getAllProjects();
    }

    private ProjectService projectService() {
        return ServiceFactory.getInstance().getProjectService();
    }

}

