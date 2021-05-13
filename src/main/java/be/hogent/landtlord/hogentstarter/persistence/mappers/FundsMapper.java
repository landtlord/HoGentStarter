package be.hogent.landtlord.hogentstarter.persistence.mappers;

import be.hogent.landtlord.hogentstarter.domain.bussines.Funds;
import be.hogent.landtlord.hogentstarter.domain.bussines.Project;
import be.hogent.landtlord.hogentstarter.domain.bussines.User;
import be.hogent.landtlord.hogentstarter.persistence.FundsEntity;
import be.hogent.landtlord.hogentstarter.persistence.ProjectEntity;
import be.hogent.landtlord.hogentstarter.persistence.UserEntity;

public class FundsMapper implements Mapper<Funds, FundsEntity> {
    private Mapper<Project, ProjectEntity> projectMapper;

    private Mapper<User, UserEntity> userMapper;

    public FundsMapper() {
        this.projectMapper = new ProjectMapper();
        this.userMapper = new UserMapper();
    }

    @Override
    public Funds toObject(FundsEntity fundsEntity) {
        Funds funds = new Funds();
        funds.setId(fundsEntity.getId());
        funds.setProject(projectMapper.toObject(fundsEntity.getProjectEntity()));
        funds.setUser(userMapper.toObject(fundsEntity.getUserEntity()));
        funds.setAmount(fundsEntity.getAmount());
        return funds;
    }

    @Override
    public FundsEntity toEntity(Funds funds) {
        FundsEntity fundsEntity = new FundsEntity();
        fundsEntity.setId(funds.getId());
        fundsEntity.setProjectEntity(projectMapper.toEntity(funds.getProject()));
        fundsEntity.setUserEntity(userMapper.toEntity(funds.getUser()));
        fundsEntity.setAmount(funds.getAmount());
        return fundsEntity;
    }
}
