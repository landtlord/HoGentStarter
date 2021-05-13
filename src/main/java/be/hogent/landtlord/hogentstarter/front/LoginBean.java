package be.hogent.landtlord.hogentstarter.front;

import be.hogent.landtlord.hogentstarter.common.Role;
import be.hogent.landtlord.hogentstarter.domain.service.ServiceFactory;
import be.hogent.landtlord.hogentstarter.domain.service.dto.UserDTO;
import lombok.Data;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@ManagedBean(name = "loginBean")
@RequestScoped
@Data
public class LoginBean {
    private String userName;

    private String password;

    public LoginBean() {
        System.out.println("login bean");
    }

    public String login(){
        UserDTO foundUser = ServiceFactory.getInstance().getUserService().doLogin(userName, password);
        if (nonNull(foundUser)) {
            ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
            HttpSession currentSession = (HttpSession) ctx.getSession(true);
            currentSession.setAttribute("loggedInUser", foundUser);
            return foundUser.getRole().toString().toLowerCase(Locale.ROOT);
        }
        return "index";
    }

    public String logOut(){
        ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession currentSession = (HttpSession) ctx.getSession(true);
        currentSession.removeAttribute("loggedInUser");
        return "index";
    }
}
