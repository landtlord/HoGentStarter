package be.hogent.landtlord.hogentstarter.front;

import be.hogent.landtlord.hogentstarter.domain.service.ProjectService;
import be.hogent.landtlord.hogentstarter.domain.service.ServiceFactory;
import be.hogent.landtlord.hogentstarter.domain.service.dto.ProjectDTO;
import lombok.Data;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean(name = "projectsBean", eager = true)
@ApplicationScoped
@Data
public class ProjectsBean {
    private List<ProjectDTO> projects;

    public ProjectsBean() {
    }

    private ProjectService projectService() {
        return ServiceFactory.getInstance().getProjectService();
    }

    public List<ProjectDTO> refresh(){
        projects = projectService().getAllRunningProjects();
        return projects;
    }

}

