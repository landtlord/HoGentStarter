package be.hogent.landtlord.hogentstarter.domain.service;

import lombok.Getter;

@Getter
public class ServiceFactory {
    private static ServiceFactory instance;

    private CommentService commentService;

    private FundsService fundsService;

    private ProjectService projectService;

    private UserService userService;

    public ServiceFactory() {
        commentService = new CommentService();
        fundsService = new FundsService();
        projectService = new ProjectService();
        userService = new UserService();
    }

    public static ServiceFactory getInstance() {
        if (instance == null) {
            instance = new ServiceFactory();
        }
        return instance;
    }
}
